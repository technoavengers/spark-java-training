package main.training.labs.spark.rdd.lab1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkAnonymousFunctions")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Create an RDD with a list of names
            JavaRDD<String> namesRDD = sparkContext.parallelize(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva"));

            // Step 4: Use a map transformation with an anonymous function to convert names to uppercase
            JavaRDD<String> uppercaseNamesRDD = namesRDD.map(name -> name.toUpperCase());

            // Step 5: Use a filter transformation with an anonymous function to filter names that start with 'A'
            JavaRDD<String> filteredNamesRDD = namesRDD.filter(name -> name.startsWith("A"));

            // Step 6: Print the results
            System.out.println("Uppercase Names:");
            uppercaseNamesRDD.foreach(name -> System.out.println(name));

            System.out.println("\nNames Starting with 'A':");
            filteredNamesRDD.foreach(name -> System.out.println(name));
        } finally {
            // Step 7: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}

