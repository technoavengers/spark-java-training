package main.training.Spark.Working_with_RDDs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class ReduceByKeyTransformation {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("CustomerDataAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Create an RDD with a list of names
            JavaRDD<String> countryRDD = sparkContext.parallelize(Arrays.asList("US", "US", "IN", "IN", "US"));

            // Step 4: Use a MaptoPair transformation to convert each element into tuple such that (US,1),(IN,1)
            JavaPairRDD<String, Integer> countryTuple = countryRDD.mapToPair(country -> new Tuple2<>(country, 1));


            // Step 5: Use reduceByKey transformation to calculate total count per country
            JavaPairRDD<String, Integer> countryCount = countryTuple.reduceByKey(Integer::sum);


            // Step6: print the results of above operation
            countryCount.foreach(tuple -> System.out.println("country -->"+ tuple._1()+ " count-->" + tuple._2()));

        } finally {
            // Step 7: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}




