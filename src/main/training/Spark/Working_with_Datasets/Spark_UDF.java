package Spark.Working_with_Datasets;

import org.apache.log4j.Level;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.log4j.Logger;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

import static org.apache.spark.sql.functions.*;


/**
 * Create a Spark UDF
 * Normalize the country field of Dataset
 * Use Spark UDF in Dataframe API & Spark SQL
 *
 */


public class Spark_UDF {



    public static void main(String[] args) {

        Logger.getLogger("org.apache").setLevel(Level.INFO);

        //Create a Spark Session to run in local mode
        SparkSession spark = SparkSession.builder().appName("firstApplication").master("local[*]")
                .config("spark.testing.memory", "471859200") // Set the driver memory here
                .getOrCreate();


        //Create some in memory data structure
        List<Row> custRows = new ArrayList<Row>();
        custRows.add(RowFactory.create(1, "Jim", "US"));
        custRows.add(RowFactory.create(2, "Monica", "USa"));
        custRows.add(RowFactory.create(4, "Rachael", "United states of America"));
        custRows.add(RowFactory.create(5, "Joey", "Ussaa"));
        custRows.add(RowFactory.create(6, "Ross",  "United states"));

        //Defining a schema
        StructType schema = new StructType(new StructField[] {
                new StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("name", DataTypes.StringType, false, Metadata.empty()),
                new StructField("country", DataTypes.StringType, false, Metadata.empty())
        });

        Dataset<Row> userData = spark.createDataFrame(custRows,schema);



        //Registering a Spark UDF
        spark.udf().register("normalisedCountry",(String country) -> {

            List countryList = new ArrayList<>();
            countryList.add("US");
            countryList.add("USa");
            countryList.add("USA");
            countryList.add("United states");
            countryList.add("United states of America");

            if (countryList.contains(country)) {
                return "USA";
            }
            else {
               return  "unknown";
            }
        },DataTypes.StringType);


        //Using Spark UDF with Dataframes API
        userData
                .withColumn("country"
                        ,callUDF("normalisedCountry",col("country")))
                .explain();


        //Using Spark USF with Spark SQL
        userData.createOrReplaceTempView("users");
        spark.sql("select id,name,normalisedCountry(country) as country from users")
                .explain();



        //Stop spark session to release resources
        spark.stop();


    }

}

