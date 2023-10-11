package main.training.Spark.Optimization;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class FilePartitioning {

    public static void main(String[] args) {


        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();

        //Create a Dataset from movies.csv file
        Dataset<Row> custDs = spark.read().option("header", true).csv("src/main/resources/customers_new.csv");

        custDs = custDs.withColumn("month",month(to_date(col("purchase_date"))));
        custDs = custDs.withColumn("year",year(to_date(col("purchase_date"))));

        custDs.write().mode("overwrite").partitionBy("year","month").parquet("src/main/resources/output");

    }
}
