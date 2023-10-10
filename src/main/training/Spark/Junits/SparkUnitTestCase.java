package main.training.Spark.Junits;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.types.DataTypes;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SparkUnitTestCase {

    private SparkSession spark;

    @Before
    public void setUp() {
        SparkConf conf = new SparkConf()
                .setAppName("YourUnitTest")
                .set("spark.testing.memory", "471859200")
                .setMaster("local[*]"); // Use a local Spark master for testing

        spark = SparkSession.builder()
                .config(conf)
                .getOrCreate();
    }


    @Test
    public void testYourDatasetOperation() {
        // Create a DataFrame (Dataset<Row>) for testing
        List<Row> data = Arrays.asList(
                RowFactory.create(1, "Alice","NY"),
                RowFactory.create(2, "Bob","LY"),
                RowFactory.create(3, "Charlie","NY"),
                RowFactory.create(4, "Sam","LY"),
                RowFactory.create(5, "Linda","NY")
        );

        StructType schema = new StructType()
                .add("id", DataTypes.IntegerType, false)
                .add("name", DataTypes.StringType, false)
                .add("city", DataTypes.StringType, false);

        Dataset<Row> customers = spark.createDataFrame(data, schema);

        // Call your Dataset operation
        Dataset<Row> resultDataset = SparkMain.aggregateCustomersOnCity(customers);

        // Perform assertions
        long rowCount = resultDataset.count();
        assertEquals(2L, rowCount);

        Row firstRow = resultDataset.first();
        assertEquals("NY", firstRow.getString(0));
        assertEquals(3L, firstRow.getLong(1));
    }



    @After
    public void tearDown() {
        if (spark != null) {
            spark.stop();
        }
    }

}
