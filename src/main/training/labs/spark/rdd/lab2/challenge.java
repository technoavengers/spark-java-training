package main.training.labs.spark.rdd.lab2;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class challenge {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("CustomerDataAnalysis")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Create an RDD with a list of names
            JavaRDD<String> countryRDD = sparkContext.parallelize(Arrays.asList("US", "US", "IN", "IN", "US"));

            // TODO Step 4: Use a MaptoPair transformation to convert each element into tuple such that (US,1),(IN,1)


            // TODO Step 5: Use reduceByKey transformation to calculate total count per country


            // TODO Step6: print the results of above operation

        } finally {
            // Step 7: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}



