package main.training.labs.spark.datasets.lab1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import java.util.Arrays;

import static org.apache.spark.sql.functions.col;

public class solution {
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

            // Step 4: Use the map transformation to convert each element to upper
            //Use toUpperCase() inbuilt function
            Dataset<String> upperCase = nameDataset.map(
                    (MapFunction<String, String>) name -> name.toUpperCase(),
                    stringEncoder
            );

            // Step 5: Use the filter transformation to keep only names starting with A
            //Use startWith("A") inbuilt function
            Dataset<String> filtered = upperCase.filter(
                    (FilterFunction<String>) name -> name.startsWith("A")
            );

            // Step 6: Show the results
            filtered.show();
        } finally {
            // Step 7: Stop the SparkSession to release resources
            spark.stop();
        }
    }
}

