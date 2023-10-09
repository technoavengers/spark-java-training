package main.training.Spark.Working_with_RDDs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class RDDFlatMapTransformation {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkFlatMapExample")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Create an RDD with a list of lines of text
            JavaRDD<String> textRDD = sparkContext.parallelize(Arrays.asList(
                    "Apache Spark is an open-source distributed computing system.",
                    "It provides high-level APIs in Java, Scala, and Python.",
                    "Spark offers powerful data processing capabilities."
            ));

            // Step 4: Apply the flatMap transformation to split lines into words
            JavaRDD<String> wordsRDD = textRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

            // Step 5: Count the total number of words
            long wordCount = wordsRDD.count();

            // Step 6: Print the word count
            System.out.println("Total number of words: " + wordCount);
        } finally {
            // Step 7: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}

