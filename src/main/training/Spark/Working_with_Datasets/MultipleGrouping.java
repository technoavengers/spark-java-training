package Spark.Working_with_Datasets;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;


/**
 * Use Spark SQL
 * Read Credit Cards data
 * Extract month and month_num from Last_Date column and add them as extra column
 * Group By credit_card type, month
 * Order the result by credit_card type and month
 * Based on above grouping, calculate the total amount spent on each card type by month
 *
 */


public class MultipleGrouping {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from credit_card.csv file
        Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/credit_cards.csv");

        //Extract month and month number from Last_Date column and add them as extra column in Dataset
        Dataset<Row> updatedCust  =
                dataset
                        .withColumn("month",date_format(to_date(col("Last_Date"),"dd-MM-yyyy"), "MMMM"))
                        .withColumn("month_num",date_format(to_date(col("Last_Date"),"dd-MM-yyyy"), "M").cast(DataTypes.IntegerType));

        //Create temporary view on top of Dataset
        updatedCust.createOrReplaceTempView("customers");

        //Run SQL query against the temporary view
        //Group the data based on Card type and month
        //Calculate the total amount spent on each card_type by month
        //Order the data by credit_type and month
        Dataset<Row> groupedCust = spark.sql("select Card_type,month,sum(Total_spent) as total_spent from customers group by Card_type,month,month_num order by Card_type,month_num");

        //print the result
        groupedCust.show();

        //Stop spark session to release resources
        spark.stop();


    }

}

