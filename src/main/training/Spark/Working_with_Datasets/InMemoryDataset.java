package Spark.Working_with_Datasets;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.lit;
import java.util.List;
import org.apache.spark.sql.types.*;


/**
 * Read customers data
 * Filter data based on age (get only those customers whose age is greater than or equals to 20)
 * Print the result
 *
 */


public class InMemoryDataset {

    public static void main(String[] args) {

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create some in memory data structure
        List<Row> custRows = new ArrayList<Row>();
        custRows.add(RowFactory.create(1,"John","NY",22));
        custRows.add(RowFactory.create(2,"Jim","LA",34));
        custRows.add(RowFactory.create(3,"Mary","NY",12));
        custRows.add(RowFactory.create(4,"Adam","LA",18));
        custRows.add(RowFactory.create(5,"Sam","NY",40));


        //Defining a schema
        StructType schema = new StructType(new StructField[] {
                new StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("name", DataTypes.StringType, false, Metadata.empty()),
                new StructField("city", DataTypes.StringType, false, Metadata.empty()),
                new StructField("age", DataTypes.IntegerType, false, Metadata.empty())

        });


        //Create a Dataset from in-memory data
        Dataset<Row> inMemoryCust = spark.createDataFrame(custRows,schema);

        //Filter customers whose age >= 20 using Column
        Dataset<Row> filteredCust = inMemoryCust.filter(col("age").geq(lit(20)));

        //print the result
        filteredCust.show();

        //Stop spark session to release resources
        spark.stop();


    }

}

