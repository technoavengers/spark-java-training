package main.training.Spark.Junits;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

class SparkMain {


public static Dataset<Row> aggregateCustomersOnCity(Dataset<Row> cust){

    Dataset<Row> result = cust
                             .groupBy("city")
                              .count();
    return  result;

}


}
