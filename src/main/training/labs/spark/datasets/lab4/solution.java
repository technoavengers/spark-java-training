package main.training.labs.spark.datasets.lab4;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

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


       //Create a temporary view on top of ratings dataset
        ratingsDF.createOrReplaceTempView("ratings");

        //Run SQL query against the temporary view to count total ratings given to each movie
        //Use group by movieId clause
        Dataset<Row> filteredCust = spark.sql("select movieId,count(*) from ratings group by movieId");

        //print the result
        filteredCust.show();

        // Stop the SparkSession
        spark.stop();
    }
}
