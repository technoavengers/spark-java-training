package main.training.labs.spark.datasets.lab8;


import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class challenge {

    public static void main(String[] args) {
        // Create a Spark configuration and SparkSession
        SparkConf conf = new SparkConf()
                .setAppName("MovieRatingAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        //TODO: Step1 --> Read the ratings_new.csv file into a DataFrame

        //TODO: Step2 --> Add a new colum rating_category such that
        /*
         WHEN rating <= 3 THEN 'Average' " +
                "        WHEN rating > 3 AND rating < 4 THEN 'Good' " +
                "        WHEN rating >= 4 THEN 'Excellent' "
         */

        //TODO: Step3 --> show the final dataset

        // Stop the SparkSession
        spark.stop();
    }
}

