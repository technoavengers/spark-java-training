package main.training.labs.spark.datasets.lab6;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
public class solution {


    public static void main(String[] args) {
        // Create a Spark configuration and SparkSession
        SparkConf conf = new SparkConf()
                .setAppName("MovieRatingAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        // Define the custom schema for the ratings.csv file
        StructType schema = new StructType()
                .add("userId", DataTypes.IntegerType, false)
                .add("movieId", DataTypes.IntegerType, false)
                .add("rating", DataTypes.DoubleType, false)
                .add("timestamp", DataTypes.LongType, false);

        // Read the ratings.csv file with the custom schema
        Dataset<Row> ratingsDF = spark.read()
                .option("header", "true")
                .schema(schema)
                .csv("src/main/resources/ratings_new.csv");

        // Show the original ratings data
        System.out.println("Original Ratings Data:");
        ratingsDF.show();


        ratingsDF.createOrReplaceTempView("ratings");
        String sqlQuery = "SELECT " +
                "    userId, " +
                "    movieId, " +
                "    rating, " +
                "    timestamp, " +
                "    CASE " +
                "        WHEN rating <= 3 THEN 'Average' " +
                "        WHEN rating > 3 AND rating < 4 THEN 'Good' " +
                "        WHEN rating >= 4 THEN 'Excellent' " +
                "        ELSE 'Low' " +
                "    END AS category " +
                "FROM ratings";
        Dataset<Row> categorizedRatingsDF = spark.sql(sqlQuery);

        // Show the filtered and categorized data
        System.out.println("Filtered and Categorized Ratings Data:");
        categorizedRatingsDF.show();

        // Stop the SparkSession
        spark.stop();
    }

}
