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


public class Working_With_Columns {

    public static void main(String[] args) {

        Logger.getLogger("org.apache").setLevel(Level.INFO);

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create a Dataset from customers json file
        Dataset<Row> custDF = spark.read().option("multiLine", true).json("src/main/resources/customer_data.json");


        //Derive new column country code from country column
        custDF
                .withColumn("country_code",upper(col("country").substr(0,2)))
                .show(5);


       /* //Add a new column Continent and derive this column from countries
        custDF
                .withColumn("continent",
                                 when(col("country").isin("Netherlands","Switzerland","Norway"),lit("Europe"))
                                .when(col("country").isin("India","China"),lit("Asia"))
                                .otherwise(lit("other")))
                .show();
*/

        /*//Drop a column country from Dataset
        custDF
                .drop("country")
                .show(5);
        */

        /*//Rename an existing column
        custDF
                .withColumnRenamed("id","cust_id")
                .show(5);
        */

        //Stop spark session to release resources
        spark.stop();


    }

}

