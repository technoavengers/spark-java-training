package main.training.Spark.Working_with_RDDs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;


/**
 * We create a SparkConf object and set the application name.
 *
 * We create a JavaSparkContext using the SparkConf.
 *
 * We load the customer data from a CSV file into an JavaRDD<String> called customerData.
 *
 * We filter the customers with an age greater than 20 using the filter transformation.
 *
 * We create a JavaPairRDD<String, Integer> with (city, 1) as key-value pairs.
 *
 * We use the reduceByKey transformation to count the number of customers per city.
 *
 * We print the city-wise customer counts using foreach.
 *
 * Finally, we stop the JavaSparkContext to release Spark resources
 */
public class RDDCustomers {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("CustomerDataAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Load the customer data from a CSV file into an RDD
            JavaRDD<String> customerData = sparkContext.textFile("src/main/resources/customers.csv");

            // Step 4: Skip the header by using the zipWithIndex transformation
            // and filtering out the first line (index 0)
            JavaRDD<String> CustomerDataWithoutHeader = customerData.zipWithIndex()
                    .filter(tuple -> tuple._2() > 0)
                    .map(tuple -> tuple._1());

            // Step 4: Filter customers with age greater than 20
            JavaRDD<String> filteredCustomers = CustomerDataWithoutHeader.filter(line -> {
                String[] parts = line.split(",");
                int age = Integer.parseInt(parts[3].trim());
                return age > 20;
            });

            // Step 5: Create a PairRDD with (city, 1) as key-value pairs
            JavaPairRDD<String, Integer> cityCounts = filteredCustomers.mapToPair(
                    (PairFunction<String, String, Integer>) line -> {
                        String[] parts = line.split(",");
                        String city = parts[2].trim();
                        return new Tuple2<>(city, 1);
                    }
            );

            // Step 6: Perform a reduceByKey operation to count customers per city
            JavaPairRDD<String, Integer> cityCustomerCounts = cityCounts.reduceByKey(Integer::sum);

            // Step 7: Print the city-wise customer counts
            cityCustomerCounts.foreach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));
        } finally {
            // Step 8: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}
