package main.training.Spark.Delta_Tables;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;


public class Reading_From_Delta_Tables {
    public static void main(String[] args) {
        // Configure Spark
        SparkConf conf = new SparkConf()
                .set("spark.testing.memory", "471859200")
                .setAppName("DeltaLakeExample");
        SparkSession spark = SparkSession.builder()
                .config(conf)
                .master("local[*]")
                .getOrCreate();


        String deltaTablePath = "file:///home/training/spark-java-training/customers";
        Dataset<Row> deltaTable = spark.read().format("delta").load(deltaTablePath);


        deltaTable.show();

        // Stop Spark session
        spark.stop();
    }
}
