package main.training.Spark.Working_with_RDDs;

/**
 * PairRDDs are commonly used for performing operations that
 * require grouping and aggregating data by keys,
 * such as reducing data by key or joining datasets based on keys.
 *
 * We create a SparkConf object and set the application name.
 * We create a JavaSparkContext using the SparkConf.
 * We load a text file into an RDD named lines.
 * We split each line into words using the flatMap transformation.
 * We create a PairRDD named wordLengths where each word is paired with its length using the mapToPair transformation.
 * We print each word and its length using the foreach action.
 * Finally, we stop the JavaSparkContext to release Spark resources.
 */
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import java.util.Arrays;

public class PairRDD {
    public static void main(String[] args) {
        // Step 1: Create a SparkConf and set the application name
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkPairRDDExample")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        // Step 2: Create a JavaSparkContext using the SparkConf
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        try {
            // Step 3: Load a text file into an RDD
            JavaRDD<String> lines = sparkContext.textFile("src/main/resources/sample.txt");

            // Step 4: Split each line into words
            JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

            // Step 5: Create a PairRDD with words as keys and their lengths as values
            JavaPairRDD<String, Integer> wordLengths = words.mapToPair(word -> new Tuple2<>(word, word.length()));

            // Step 6: Print the word and its length
            wordLengths.foreach(tuple -> System.out.println("Word: " + tuple._1() + ", Length: " + tuple._2()));
        } finally {
            // Step 7: Stop the JavaSparkContext to release resources
            sparkContext.stop();
        }
    }
}

