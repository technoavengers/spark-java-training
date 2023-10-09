package main.training.labs.spark.datasets.lab1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import java.util.Arrays;

public class challenge {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkDatasetMapFilterExample")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");;

        // Step 2: Create a SparkSession using the SparkConf
        SparkSession spark = SparkSession.builder().config(sparkConf).getOrCreate();

        try {
            // Step 3: Create a Dataset of integers
            Encoder<String> stringEncoder = Encoders.STRING();
            Dataset<String> nameDataset = spark.createDataset(
                    Arrays.asList("alice","sam","arya","andy"),
                    stringEncoder
            );

            // TODO Step 4: Use the map transformation & MapFunction to convert each element to upper
            //Use toUpperCase() inbuilt function

            // TODO Step 5: Use the filter transformation & FilterFunction to keep only names starting with A
            //Use startWith("A") inbuilt function


            // TODO Step 6: Show the results

        } finally {
            // Step 7: Stop the SparkSession to release resources
            spark.stop();
        }
    }
}

