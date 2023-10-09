package main.training.labs.spark.rdd.lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class solution {
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
                    "Spark provides high-level APIs in Java, Scala, and Python.",
                    "Spark offers powerful data processing capabilities.Spark is an engine to go for"
            ));

            // Step 4: Apply the flatMap transformation to split lines into words
            JavaRDD<String> wordsRDD = textRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

            // Step 5: Use mapToPair transformation to create word tuple by appending to 1 to each word
            // (Apache,1) (Spark,1)
            JavaPairRDD<String, Integer> wordTuple = wordsRDD.mapToPair(word -> new Tuple2<>(word, 1));


            // Step 6: Reduce the data based on words to get count per word
            JavaPairRDD<String,Integer> wordsCount = wordTuple.reduceByKey(Integer::sum);

            //Step 7: Print out each word along with count
            wordsCount.foreach(tuple -> System.out.println("word -->" + tuple._1() + " count-->" + tuple._2()));


        } finally {
            // Step 7: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}

