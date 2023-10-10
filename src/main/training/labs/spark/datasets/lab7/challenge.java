package main.training.labs.spark.datasets.lab7;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Imagine you are working for a retail company that wants to analyze customer data
 * to gain insights into customer behavior and preferences. The company has provided
 * you with a dataset containing customer information and purchase history. Your task
 * is to use Apache Spark with Datasets to perform various data processing and
 * analysis tasks.
 */
public class challenge {

    public static void main(String[] args) {
        // Create a Spark configuration and SparkSession
        SparkConf conf = new SparkConf()
                .setAppName("MovieRatingAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();


        //TODO Step1: Load Data
        //Load the `customer_new.csv` file into a Dataset.
        //Ensure that the schema is inferred correctly.

        //TODO Step2: Data Cleaning
        //Handle missing values from column age, if age is missing add 0 (Hints: use na().fill api)
        //remove rows with duplicates customer_id (Hints: use dropDuplicates api)
        //convert the data type of purchase_amount to double (Hints: use withColumn api with cast function)
        //Make gender column consistent to contain either M/F values only (Hints: withColumn when statements)
        //combine first_name, last_name in new column called full_name (Hints: use withColumn api with concat function)
        //Also drop first_name, last_name columns (Hints: use drop API)

        //TODO Step3: Data Analytics
        //Calculate the total number of customers.
        //Find the average age of customers.
        //Calculate the total revenue generated from the sales.

        // Stop the SparkSession
        spark.stop();
    }
}
