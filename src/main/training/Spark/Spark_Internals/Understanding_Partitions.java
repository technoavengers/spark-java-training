package Spark.Spark_Internals;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Understanding_Partitions {

    public static void main(String[] args) {

        Logger.getLogger("org.apache").setLevel(Level.ERROR);


        // Create a SparkConf and SparkSession
        SparkConf conf = new SparkConf()
                .setAppName("Narrow vs Wide Transformation Example")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        // Create a DataFrame from a CSV file
        Dataset<Row> dataFrame = spark
                .read()
                .option("header","true")
                .csv("spark-data/ratings.csv");

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Stop the SparkSession
        spark.stop();
    }

}
