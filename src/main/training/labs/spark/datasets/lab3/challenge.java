package main.training.labs.spark.datasets.lab3;


import org.apache.spark.SparkConf;
import org.apache.spark.sql.*;

public class challenge {

    public static void main(String[] args) {
        // Create a Spark configuration and SparkSession
        SparkConf conf = new SparkConf()
                .setAppName("MovieRatingAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        //TODO: Step1 --> Read the ratings_new.csv file into a DataFrame

        //TODO: Step2 --> Show the original ratings data

        //TODO: Step3 --> Group the data by "movieId" and calculate the average rating for each movie

        //TODO: Step4 --> Show the average rating for each movie

        // Stop the SparkSession
        spark.stop();
    }
}

