package main.training.labs.spark.datasets.lab3;

/**
 * In this Spark Java application:
 * We create a Spark configuration and a SparkSession.
 * We define a custom schema for the ratings.csv file.
 * We read the ratings.csv file using spark.read() with the custom schema.
 * We show the original ratings data.
 * We filter movies with ratings greater than 3 using the filter transformation.
 * We add a new column "category" based on the rating using the withColumn API and the when and otherwise functions from org.apache.spark.sql.functions.
 * We show the filtered and categorized data.
 */

public class challenge {

    public static void main(String[] args) {
        //TODO Step1 --> Create a Spark configuration and SparkSession

        //TODO Step2 -->  Define the custom schema for the ratings.csv file

        //TODO Step3 --> Read the ratings_new.csv file with the custom schema

        //TODO Step4 --> Show the original ratings data

        //TODO Step5 --> Add a new column "category" based on the rating
        // rating < 3 average
        // rating between 3 and 4 , good
        // rating > 4 , excellent

        //TODO Step7 -->  Show the filtered and categorized data

        //TODO Step8 -->  Stop the SparkSession
    }



}
