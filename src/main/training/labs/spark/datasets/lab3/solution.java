package main.training.labs.spark.datasets.lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.*;
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

        // Show the original ratings data
        System.out.println("Original Ratings Data:");
        ratingsDF.show();

        // Group the data by "movieId" and calculate the average rating for each movie
        Dataset<Row> averageRatingsDF = ratingsDF.groupBy("movieId")
                .agg(avg("rating").alias("average_rating"));

        // Show the average rating for each movie
        System.out.println("Average Ratings by Movie:");
        averageRatingsDF.show();

        // Stop the SparkSession
        spark.stop();
    }
}
