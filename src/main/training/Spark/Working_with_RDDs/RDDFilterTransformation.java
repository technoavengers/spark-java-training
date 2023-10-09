package main.training.Spark.Working_with_RDDs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class RDDFilterTransformation {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkFilterTransformation")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");;

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Create an RDD with a list of numbers
            JavaRDD<Integer> numbersRDD = sparkContext.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

            // Step 4: Apply the filter transformation to keep only odd numbers
            JavaRDD<Integer> oddNumbersRDD = numbersRDD.filter(number -> number % 2 != 0);

            // Step 5: Print the odd numbers
            oddNumbersRDD.foreach(number -> System.out.println(number));
        } finally {
            // Step 6: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}

