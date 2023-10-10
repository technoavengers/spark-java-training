package main.training.Spark.Delta_Tables;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SaveMode;


public class Writing_To_Delta_Tables {
    public static void main(String[] args) {
        // Configure Spark
        SparkConf conf = new SparkConf()
                .set("spark.testing.memory", "471859200")
                .setAppName("DeltaLakeExample");
        SparkSession spark = SparkSession.builder()
                .config(conf)
                .master("local[*]")
                .getOrCreate();


        //Create a Dataset from customers.csv file
        Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/customers.csv");


        // Write data to Delta Lake table
        dataset.write()
                .format("delta")
                .mode(SaveMode.Append) // Choose the appropriate save mode
                .save("customers");

        // Stop Spark session
        spark.stop();
    }
}
