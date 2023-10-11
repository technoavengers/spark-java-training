package main.training.Spark.Spark_Integrations;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;



import org.apache.spark.sql.SparkSession;

import java.util.Properties;

public class Working_with_JDBC {

    public static void main(String[] args) {


        SparkSession spark = SparkSession
                .builder()
                .appName("JDBCExample")
                .master("local[*]")
                .getOrCreate();

        String jdbcUrl = "jdbc:mysql://localhost:3306/retail_db";
        String tableName = "customers";
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "root");
        connectionProperties.put("password", "password");

        spark.read()
                .jdbc(jdbcUrl, tableName, connectionProperties).show();



    }

}
