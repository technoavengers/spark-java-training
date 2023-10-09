package main.training.Spark.Working_with_RDDs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

/**
 * We create a SparkConf object and set the application name.
 *
 * We create a JavaSparkContext using the SparkConf.
 *
 * We create an RDD named numbersRDD with a list of integers (1, 2, 3, 4, 5) using parallelize.
 *
 * We apply the map transformation to numbersRDD to square each number. The lambda function number -> number * number is used to perform the squaring operation.
 *
 * We print the squared numbers using the foreach action.
 *
 * Finally, we stop the JavaSparkContext to release Spark resources
 */
public class RDDMapTransformation {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkMapTransformation")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Create an RDD with a list of numbers
            JavaRDD<Integer> numbersRDD = sparkContext.parallelize(Arrays.asList(1, 2, 3, 4, 5));

            // Step 4: Apply the map transformation to square each number
            JavaRDD<Integer> squaredNumbersRDD = numbersRDD.map(number -> number * number);

            // Step 5: Print the squared numbers
            squaredNumbersRDD.foreach(number -> System.out.println(number));

        } finally {
            // Step 6: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}
