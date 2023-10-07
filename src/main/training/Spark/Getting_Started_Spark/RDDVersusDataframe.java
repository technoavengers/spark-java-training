package Spark.Getting_Started_Spark;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class RDDVersusDataframe {
    public static void main(String[] args) {
        // Create a SparkConf and JavaSparkContext
        Logger.getLogger("org.apache").setLevel(Level.ERROR);

        SparkConf conf = new SparkConf()
                .setAppName("RDD vs Dataset Example")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        // Create a SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("RDD vs Dataset Example")
                .config("spark.master", "local[*]")
                .config("spark.testing.memory", "471859200")
                .getOrCreate();

        // Create an RDD from a text file (e.g., CSV)
        JavaRDD<String> rdd = sc.textFile("src/main/resources/customers.csv");

        // Convert RDD to Dataset<Row>
        Dataset<Row> dataset = spark
                .read()
                .option("header","true")
                .csv("src/main/resources/customers.csv");

        System.out.println("=== RDD ===");
        rdd.take(5).forEach(System.out::println);

        System.out.println("=== Dataset ===");
        dataset.show(5);

        // Stop SparkContext and SparkSession
        sc.stop();
        spark.stop();
    }
}

