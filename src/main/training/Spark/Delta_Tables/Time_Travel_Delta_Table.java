package main.training.Spark.Delta_Tables;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import io.delta.tables.DeltaTable;

public class Time_Travel_Delta_Table {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("TimeTravelDeltaTable")
                .getOrCreate();

        // Specify the path to your Delta table
        String deltaTablePath = "/path/to/delta/table";

        // Load the Delta table
        DeltaTable deltaTable = DeltaTable.forPath(spark, deltaTablePath);

        // List available versions of the Delta table
        deltaTable.history().show();

        // Query the Delta table as of a specific version or timestamp
        String versionOrTimestamp = "1"; // Replace with the desired version number or timestamp
        Dataset<Row> historicalData = deltaTable.toDF().filter(
                "version = " + versionOrTimestamp
        );
        // Perform operations on the historical data
        historicalData.show();

        spark.stop();
    }
}
