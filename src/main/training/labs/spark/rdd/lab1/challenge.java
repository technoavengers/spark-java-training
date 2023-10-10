package main.training.labs.spark.rdd.lab1;

import org.apache.spark.api.java.JavaRDD;

public class challenge {
    public static void main(String[] args) {
        // TODO Step 1: Create a SparkConf and set the application name, master and other configs

        // TODO Step 2: Create a JavaSparkContext using the SparkConf

        try {
            // TODO Step 3: Uncomment below code to create an RDD with a list of names
            //JavaRDD<String> namesRDD = sparkContext.parallelize(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva"));

            // TODO Step 4: Use a map transformation with an anonymous function to convert names to uppercase
            // There is an inbuilt string function called "toUpperCase()" & use it inside the map, you can apply on each record

            // TODO Step 5: Use a filter transformation with an anonymous function to filter names that start with 'A'
           //There is an inbuilt string function called "startsWith("A")" & use it inside the filter , you can apply on each element

            // TODO Step 6: Uncomment below code to print the results of RDD wit upper case
            //System.out.println("Uppercase Names:");
            //uppercaseNamesRDD.foreach(name -> System.out.println(name));

            // TODO Step 6: Uncomment below code Print the results of RDD wit names starting with A
            //System.out.println("\nNames Starting with 'A':");
            //filteredNamesRDD.foreach(name -> System.out.println(name));

        } finally {
            // TODO Step 7: Uncomment below line to Stop the JavaSparkContext to release resources
            //sparkContext.stop();
        }
    }
}


