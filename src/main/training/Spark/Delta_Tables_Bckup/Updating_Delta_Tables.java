package main.training.Spark.Delta_Tables;

import io.delta.tables.DeltaTable;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * To update a Delta table in Spark using the Delta Lake API,
 * you can perform various operations like inserting, updating,
 * or deleting data. Delta Lake supports ACID transactions,
 * which ensures that these operations are atomic, consistent, isolated, and durable.
 */
public class Updating_Delta_Tables {
    public static void main(String[] args) {
        // Configure Spark
        SparkConf conf = new SparkConf()
                .set("spark.testing.memory", "471859200")
                .setAppName("DeltaLakeExample");
        SparkSession spark = SparkSession.builder()
                .config(conf)
                .master("local[*]")
                .getOrCreate();


        DeltaTable deltaTable = DeltaTable.forPath(spark, "file:///home/training/spark-java-training/customers");

        // Create a DataFrame (df) with updated data
        // For simplicity, assume df is created from some data source
        Dataset<Row> df = spark.read().format("csv")
                .option("header", "true")
                .load("src/main/resources/customers_updated.csv");

        // Define a condition to match rows for update (e.g., based on a unique key)
        String updateCondition = "target.id = source.id";


        // Perform the update operation
        deltaTable.as("target")
                .merge(df.as("source"), updateCondition)
                .whenMatched()
                .updateAll()
                .execute();

        // Stop Spark session
        spark.stop();
    }
}
