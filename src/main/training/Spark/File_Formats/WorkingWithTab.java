package Spark.File_Formats;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class WorkingWithTab {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from customers.csv file
        Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/customers.csv");

    }
}
