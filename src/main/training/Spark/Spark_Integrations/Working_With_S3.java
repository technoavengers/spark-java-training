package main.training.Spark.Spark_Integrations;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

public class Working_With_S3 {

    public static void main(String[] args) {
        // Initialize SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("SparkS3Example")
                .config("spark.testing.memory", "471859200")
                .master("local[*]")
                .getOrCreate();

        System.setProperty("AWS_ACCESS_KEY_ID", "AKIA3OHF7P5GNQWKLMEC");
        System.setProperty("AWS_SECRET_ACCESS_KEY", "9gxyG44kWdYpq9UuNfw9YTAZDqLwN4dZp7xO6MU6");

        // Replace with your AWS access and secret keys
        spark.conf().set("spark.hadoop.fs.s3a.access.key", "AKIA3OHF7P5GNQWKLMEC");
        spark.conf().set("spark.hadoop.fs.s3a.secret.key", "9gxyG44kWdYpq9UuNfw9YTAZDqLwN4dZp7xO6MU6");

        // Read data from S3 into a Dataset
        String s3InputPath = "s3a://spark-input12345/";
        String s3OutputPath = "s3a://spark-input12345/output";

       spark.read()
                .option("header","true")
                .option("inferSchema","true")
                .csv(s3InputPath)
                .filter(col("title").startsWith("T"))
                .write().csv(s3OutputPath);

        // Stop the SparkSession
        spark.stop();
    }
}

