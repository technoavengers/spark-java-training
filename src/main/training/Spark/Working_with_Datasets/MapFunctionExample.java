package main.training.Spark.Working_with_Datasets;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.apache.spark.sql.types.StructType;
import static org.apache.spark.sql.types.DataTypes.*;

public class MapFunctionExample {

    public static void main(String[] args) {

        // Create a Spark configuration and SparkSession
        SparkConf conf = new SparkConf().setAppName("SparkCSVExample")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

        // Define the custom schema for the CSV file
        StructType schema = new StructType()
                .add("id", IntegerType, false)
                .add("Name",StringType, false)
                .add("City", StringType, false)
                .add("Age", IntegerType, false);

        // Read the CSV file with the custom schema
        Dataset<Row> df = spark.read()
                .option("header", "true")
                .schema(schema)
                .csv("src/main/resources/customers.csv");

        // Show the original data
        System.out.println("Original Data:");
        df.show();

        // Filter the data to select only adults (age >= 18)
        Dataset<Row> adultsDF = df.filter((FilterFunction<Row>) row -> row.getInt(3) >= 18);

        // Show the filtered data
        System.out.println("Filtered Data (Adults Only):");
        adultsDF.show();

        // Map the data to a new column "Greeting" based on age
        Dataset<Row> mappedDF = adultsDF.map((MapFunction<Row, Row>) row -> {
            int id = row.getInt(0);
            String name = row.getString(1);
            String city = row.getString(2);
            int age = row.getInt(3);
            String greeting = age >= 21 ? "Hello, " + name : "Hi, " + name;
            return RowFactory.create(id, name, city, age , greeting);
        }, RowEncoder.apply(schema.add("Greeting", StringType, false)));

        /**
         *     // Add a new column "Greeting" based on age using withColumn
         *         Dataset<Row> withGreetingDF = adultsDF.withColumn("Greeting",
         *             org.apache.spark.sql.functions.when(adultsDF.col("Age").geq(21), org.apache.spark.sql.functions.lit("Hello, ").concat(adultsDF.col("Name")))
         *                 .otherwise(org.apache.spark.sql.functions.lit("Hi, ").concat(adultsDF.col("Name")))
         *         );
         */


        // Show the mapped data
        System.out.println("Mapped Data with Greetings:");
        mappedDF.show();

        // Stop the SparkSession
        spark.stop();

    }

}
