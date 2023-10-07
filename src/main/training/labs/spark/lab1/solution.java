package labs.spark.lab1;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.*;
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

        // Filter movies with ratings greater than 3
        Dataset<Row> filteredRatingsDF = ratingsDF.filter(ratingsDF.col("rating").gt(3));

        // Add a new column "category" based on the rating
        Dataset<Row> categorizedRatingsDF = filteredRatingsDF.withColumn("category",
                org.apache.spark.sql.functions.when(filteredRatingsDF.col("rating").lt(2), "Average")
                        .when(filteredRatingsDF.col("rating").geq(2).and(filteredRatingsDF.col("rating").lt(4)), "Good")
                        .otherwise("Excellent")
        );

        // Show the filtered and categorized data
        System.out.println("Filtered and Categorized Ratings Data:");
        categorizedRatingsDF.show();

        // Stop the SparkSession
        spark.stop();
    }

}
