package main.training.Spark.Working_with_Datasets;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import java.util.Arrays;

public class MapFilterExample {
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
            Encoder<Integer> integerEncoder = Encoders.INT();
            Dataset<Integer> numbersDataset = spark.createDataset(
                    Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                    integerEncoder
            );

            // Step 4: Use the map transformation to double each value
            Dataset<Integer> doubledDataset = numbersDataset.map(
                    (MapFunction<Integer, Integer>) value -> value * 2,
                    integerEncoder
            );

            // Step 5: Use the filter transformation to keep only odd numbers
            Dataset<Integer> filtered = numbersDataset.filter(
                    (FilterFunction<Integer>) value -> value%2==0
            );

            //Dataset<Integer> oddNumbersDataset = doubledDataset.filter(col("value").mod(2).notEqual(0));


            // Step 6: Show the results
            filtered.show();
        } finally {
            // Step 7: Stop the SparkSession to release resources
            spark.stop();
        }
    }
}

