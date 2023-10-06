package spark.Day1.Spark;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDTransformations {
    public static void main(String[] args) {
        // Create a SparkConf and JavaSparkContext

        Logger.getLogger("org.apache").setLevel(Level.ERROR);

        SparkConf conf = new SparkConf()
                .setAppName("Spark Transformation Example")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        // Create an RDD with sample data
        JavaRDD<Integer> numbers = sc.parallelize(
                java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );

        // Transformation 1: Map
        JavaRDD<Integer> squaredNumbers = numbers.map(x -> x * x);

        // Transformation 2: Filter
        JavaRDD<Integer> evenNumbers = numbers.filter(x -> x % 2 == 0);

        // Transformation 3: Reduce
        int sum = numbers.reduce((x, y) -> x + y);

        // Transformation 4: Distinct
        JavaRDD<Integer> distinctNumbers = numbers.distinct();

        // Transformation 5: FlatMap
        JavaRDD<String> words = sc.parallelize(
                java.util.Arrays.asList("Hello World", "Spark Transformation Example", "Java")
        );
        JavaRDD<String> flattenedWords = words.flatMap(line -> java.util.Arrays.asList(line.split(" ")).iterator());

        // Transformation 6: Union
        JavaRDD<Integer> moreNumbers = sc.parallelize(
                java.util.Arrays.asList(11, 12, 13, 14, 15)
        );
        JavaRDD<Integer> combinedNumbers = numbers.union(moreNumbers);

        // Print results
        System.out.println("Squared Numbers: " + squaredNumbers.collect());
        System.out.println("Even Numbers: " + evenNumbers.collect());
        System.out.println("Sum of Numbers: " + sum);
        System.out.println("Distinct Numbers: " + distinctNumbers.collect());
        System.out.println("Flattened Words: " + flattenedWords.collect());
        System.out.println("Combined Numbers: " + combinedNumbers.collect());

        // Stop the SparkContext
        sc.stop();
    }
}

