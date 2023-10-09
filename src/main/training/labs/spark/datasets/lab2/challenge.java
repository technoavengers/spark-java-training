package main.training.labs.spark.datasets.lab2;

import org.apache.spark.SparkConf;
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

            nameDataset.show();
            //TODO Step 4: Use the withColumn to map each  element to upper
            //Use upper(col("col_name")) inbuilt function

            //TODO Step 6: Show the results


        } finally {
            // Step 7: Stop the SparkSession to release resources
            spark.stop();
        }
    }
}

