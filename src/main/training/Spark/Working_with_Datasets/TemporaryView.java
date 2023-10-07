package Spark.Working_with_Datasets;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


/**
 * Create Temporary View and Use Spark SQL to
 * Read customers data
 * Filter data based on age (get only those customers whose age is greater than or equals to 20)
 * Print the result
 *
 */


public class TemporaryView {

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
        Dataset<Row> filteredCust = spark.sql("select * from customers where age>= 20");

        //print the result
        filteredCust.show();

        //Stop spark session to release resources
        spark.stop();


    }

}

