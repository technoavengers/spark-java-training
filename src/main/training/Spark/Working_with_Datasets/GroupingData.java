package main.training.Spark.Working_with_Datasets;

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


public class GroupingData {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from customers.csv file
        Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/customers.csv");

        //Create temporary view on top of Dataset
        dataset.createOrReplaceTempView("customers");

        //Run SQL query against the temporary view
        Dataset<Row> groupedCust = spark.sql("select city,count(*) from customers group by city");


        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //print the result
        groupedCust.show();

        //Stop spark session to release resources
        spark.stop();


    }

}

