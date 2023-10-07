package Spark.Spark_Internals;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class NarrowVsWideTransformations {
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
                .csv("src/main/resources/customers.csv");

        // Show the initial DataFrame
        System.out.println("=== Initial DataFrame ===");
        dataFrame.show();

        // Narrow Transformation: Select
        Dataset<Row> nameColumn = dataFrame.select("name");

        // Narrow Transformation: Filter
        Dataset<Row> highScore = dataFrame.filter("age >= 20");

        // Wide Transformation: Group By
        Dataset<Row> avgScorePerName = dataFrame.groupBy("city").count();

        // Show the results of transformations
        System.out.println("=== Narrow Transformation: Select ===");
        nameColumn.show();

        System.out.println("=== Narrow Transformation: Filter ===");
        highScore.show();

        System.out.println("=== Wide Transformation: Group By ===");
        avgScorePerName.show();

        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Stop the SparkSession
        spark.stop();
    }
}

