package main.training.labs.spark.datasets.lab5;


import org.apache.spark.sql.*;

import java.util.Arrays;

public class challenge {

    public static void main(String[] args) {
        // Create a SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("SparkJavaUDFExample")
                .master("local[*]")  // Use local mode for simplicity, replace with your cluster URL in a real environment
                .config("spark.testing.memory", "471859200")
                .getOrCreate();

        // Create a DataFrame
        Encoder<String> stringEncoder = Encoders.STRING();
        Dataset<Row> df = spark.createDataset(
                Arrays.asList("John", "Doe", "Alice", "Smith"),
                stringEncoder
        ).toDF();

        // TODO : Register a UDF called "custmToUpper" and implement the code to convert incoming value to uppercase
        // use String's toUpperCase() inbuilt function

        // TODO: Use the UDF inside withColumn API to transform a column "value" to uppercase

        // TODO : Show the result

        // Stop the SparkSession
        spark.stop();
    }
}
