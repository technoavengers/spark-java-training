package Spark.Working_with_Datasets;

import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

import static org.apache.spark.sql.functions.*;
import java.util.List;


/**
 * Use Spark Dataframe API
 * Create Pivot Table
 * Read Credit Cards data
 * Extract month and month_num from Last_Date column and add them as extra column
 * Group By credit_card type, month
 * Order the result by credit_card type and month
 * Based on above grouping, calculate the total amount spent on each card type by month
 *
 */


public class PivotTable {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


       Object[] months = new  Object[] {"January","February","March","April","May","June"};
       List<Object> columns = Arrays.asList(months);

        spark
                .read().option("header", true).option("inferSchema",true).csv("src/main/resources/credit_cards.csv")
                .withColumn("month",date_format(to_date(col("Last_Date"),"dd-MM-yyyy"), "MMMM"))
                .groupBy("Card_type")
                //.pivot("month")
                .pivot("month",columns)
                .sum("Total_spent")
                .orderBy("Card_type")
                .show();


        //Stop spark session to release resources
        spark.stop();


    }

}

