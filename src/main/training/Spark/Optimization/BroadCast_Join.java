package Spark.Optimization;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


/**
 * Use Spark SQL
 * Read customers data
 * Group the data based on city
 * and count the customers
 *
 */


public class BroadCast_Join {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from movies.csv file
        Dataset<Row> moviesDs = spark.read().option("header", true).csv("src/main/resources/movies.csv");

        //Create a Dataset from ratings file
        Dataset<Row> ratingsDS = spark.read().option("header", true).csv("src/main/resources/ratings_new.csv");


        Dataset<Row> joinedDF = ratingsDS.join(moviesDs,moviesDs.col("movieId").equalTo(ratingsDS.col("movieId")),"outer");

        joinedDF.explain();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Stop spark session to release resources
        spark.stop();


    }

}

