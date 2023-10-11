package main.training.Spark.File_Formats;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class WorkingwithParquet {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("parquetApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();

        String hdfsPath = "hdfs://datacouch.training.io:8020/user/training/spark-data/pageviews_by_second_par";

        Dataset<Row> parquetData = spark.read().parquet(hdfsPath);

        //parquetData.filter("requests > 1000").explain();

        parquetData.write().mode("overwrite").json("hdfs://datacouch.training.io:8020/user/training/spark-data/output");


        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        spark.stop();


    }
}
