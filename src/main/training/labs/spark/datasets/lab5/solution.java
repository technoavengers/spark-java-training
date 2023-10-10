package main.training.labs.spark.datasets.lab5;

import org.apache.spark.sql.*;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataTypes;

import java.util.Arrays;

public class solution {

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

        // Register a UDF
        spark.udf().register("customToUpper",(String input) -> {
            if (input != null) {
                return input.toUpperCase();
            } else {
                return null;
            }
        },DataTypes.StringType);


        // Use the UDF to transform a column
        df = df.withColumn("name_uppercase", functions.callUDF("customToUpper", df.col("value")));

        // Show the result
        df.show();

        // Stop the SparkSession
        spark.stop();
    }

    // Define a custom UDF by implementing UDF1
    public static class CustomToUpperUDF implements UDF1<String, String> {
        @Override
        public String call(String input) throws Exception {
            // Custom logic to convert a string to uppercase
            if (input != null) {
                return input.toUpperCase();
            } else {
                return null;
            }
        }
    }
}
