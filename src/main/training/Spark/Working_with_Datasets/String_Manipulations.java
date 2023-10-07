package Spark.Working_with_Datasets;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;


/**
 * Read customers data provided in Json
 * Manipulate columns to add, drop or change values
 * using withColumn API's
 *
 */


public class String_Manipulations {

    public static void main(String[] args) {

        Logger.getLogger("org.apache").setLevel(Level.INFO);

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from customers json file
        Dataset<Row> custDF = spark.read().option("multiLine", true).json("src/main/resources/customer_data.json");


        //Use lower & upper built-in SQL function
        //Select customers first name in upper case & last name in lower case
        custDF
                .select(upper(col("first_name")),lower(col("last_name")))
                .show(5);

        //Concat first name,last name and country in single column
        // first_name:last_name|country(first two characters)
        //May:Joseph|SW
        // Also, drop first_name and last_name column
        custDF
                .withColumn("full_name",concat(col("first_name"),lit(":"),col("last_name"),lit("|"),col("country").substr(0,2)))
                .drop("first_name","last_name")
                .show(5);


        //Split the email address based on "@" and get the username and domain in seperate columns
        custDF
                .select(col("email")
                        ,split(col("email"),"@").getItem(0).as("username")
                        ,split(col("email"),"@").getItem(1).as("domain"))
                .show(5);


        //Using Regular Expressions to extract
        custDF
                .select(regexp_extract(col("email"),"(.*)@(.*).com",2).as("domain"))
                .show(5);


        //Stop spark session to release resources
        spark.stop();


    }

}

