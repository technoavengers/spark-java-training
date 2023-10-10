package main.training.labs.spark.datasets.lab7;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.*;

public class solution {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("MovieRatingAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        // Load the customer data from CSV into a Dataset
        String customerDataPath = "src/main/resources/customers_new.csv";
        Dataset<Row> customerData = spark.read()
                .option("header", "true")
                .option("inferSchema", "true")
                .csv(customerDataPath);

        // Data Cleaning
        Dataset<Row> cleanedData = customerData
                .na().fill(0, new String[]{"age"})  // Replace missing ages with 0 (you can adjust as needed)
                .dropDuplicates("customer_id")
                .withColumn("purchase_amount", col("purchase_amount").cast("double"))
                .withColumn("gender",
                        when(col("gender").isin("Male","M"), "M")
                                .when(col("gender").isin("Female","F"), "F")
                                .otherwise("Unknown"))
                .withColumn("full_name",concat(col("first_name"),lit(" "),col("last_name")))
                .drop("first_name","last_name");

        cleanedData.show();

        // Data Analysis
        long totalCustomers = cleanedData.count();
        double averageAge = cleanedData.agg(avg("age")).first().getDouble(0);
        double totalRevenue = cleanedData.agg(sum("purchase_amount")).first().getDouble(0);

        // Print the analysis results
        System.out.println("Total Number of Customers: " + totalCustomers);
        System.out.println("Average Age of Customers: " + averageAge);
        System.out.println("Total Revenue Generated: " + totalRevenue);

        spark.stop();
    }
}
