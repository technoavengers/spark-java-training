package Spark.Optimization;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.broadcast;



/**
 * Use Spark SQL
 * Read customers data
 * Group the data based on city
 * and count the customers
 *
 */


public class Forced_Broadcast_Join {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from movies.csv file
        Dataset<Row> tagsDS = spark.read().option("header", true).csv("src/main/resources/tags_new.csv");

        //Create a Dataset from ratings file
        Dataset<Row> ratingsDS = spark.read().option("header", true).csv("src/main/resources/ratings_new.csv");

        // Explicitly mark the smaller DataFrame for broadcasting
        Dataset<Row> joinedDF = tagsDS.join(broadcast(ratingsDS), "movieId");


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

