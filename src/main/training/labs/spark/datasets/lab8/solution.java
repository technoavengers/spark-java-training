package main.training.labs.spark.datasets.lab8;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

import static org.apache.spark.sql.functions.avg;

public class solution {

    public static void main(String[] args) {
        // Create a Spark configuration and SparkSession
        SparkConf conf = new SparkConf()
                .setAppName("MovieRatingAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        // Read the ratings.csv file into a DataFrame
        Dataset<Row> ratingsDF = spark.read()
                .option("header", "true")
                .option("inferSchema", "true")
                .csv("src/main/resources/ratings_new.csv");



        // Stop the SparkSession
        spark.stop();
    }
}
