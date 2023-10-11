package main.training.Spark.Delta_Tables;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import io.delta.tables.DeltaTable;

public class Time_Travel_Delta_Table {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("TimeTravelDeltaTable")
                .master("local[*]")
                .getOrCreate();

        // Specify the path to your Delta table
        String deltaTablePath = "file:///home/training/spark-java-training/customers";

        // Load the Delta table
        DeltaTable deltaTable = DeltaTable.forPath(spark, deltaTablePath);

        // List available versions of the Delta table
        deltaTable.history().show();

        String targetTimestamp = "2023-10-11T01:37:20.000Z"; // Replace with your desired timestamp
        // Query the Delta table as of a specific version or timestamp
        String versionOrTimestamp = "0"; // Replace with the desired version number or timestamp
        spark.read()
                .format("delta")
                .option("timestampAsOf", targetTimestamp)
                .load(deltaTablePath)
                .show();
        spark.stop();
    }
}
