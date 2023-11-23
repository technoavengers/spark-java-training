package main.training.Spark.Working_with_Datasets;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CustomEncoders {

    // Define a Java bean class
    public static class Person implements Serializable {
        private String name;
        private int age;

        public Person() { }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        // Create a Spark session
        SparkSession spark = SparkSession.builder()
                .appName("CustomEncoderFileReadingExample")
                .master("local[*]")
                .getOrCreate();

        // Specify the path to the CSV file
        String filePath = "src/main/resources/file.csv";

        // Define a custom encoder for the Person class
        Encoder<Person> personEncoder = Encoders.bean(Person.class);

        // Read the CSV file and use the custom encoder
        Dataset<Person> df = spark.read()
                .option("header", "true")
                .option("inferSchema","true")
                .csv(filePath)
                .as(personEncoder);

        // Show the DataFrame
        df.filter((FilterFunction<Person>) person  -> person.getAge() > 25).show();

        // Stop the Spark session
        spark.stop();
    }
}
