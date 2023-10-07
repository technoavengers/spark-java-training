package Spark.Working_with_Datasets;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;


/**
 * Use Dataframe API
 * Read customers data
 * Group the data based on city
 * and count the customers
 *
 */


public class Grouping_Dataframe {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from customers.csv file
        Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/customers.csv");

        Dataset<Row> groupedCust  = dataset.groupBy(col("city")).count();

        //print the result
        groupedCust.show();

        //Stop spark session to release resources
        spark.stop();


    }

}

