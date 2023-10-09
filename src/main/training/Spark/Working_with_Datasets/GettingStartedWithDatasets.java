package main.training.Spark.Working_with_Datasets;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import static org.apache.spark.sql.functions.*;


/**
 * Read customers data
 * Filter data based on age (get only those customers whose age is greater than or equals to 20)
 * Print the result
 *
 */


public class GettingStartedWithDatasets {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from customers.csv file
        Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/customers.csv");

        //Filter customers whose age >= 20 using Column
        Dataset<Row> filteredCust = dataset.filter(col("age").geq(lit(20)));

        //Filter customers whose age >= 20 using Expressions
        //Dataset<Row> filteredCust = dataset.filter("age>20");

        //print the result
        filteredCust.show();

        //Stop spark session to release resources
        spark.stop();


    }

}

