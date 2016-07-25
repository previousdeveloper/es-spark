import org.apache.spark.SparkConf
import org.apache.spark.SparkContext    
import org.apache.spark.SparkContext._
import org.elasticsearch.spark._ 

/**
 * Simple es-hadoop example.
 * Sends a map from spark to elasticsearch.
 */
object EsExample {

  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("EsExample")
    val sc = new SparkContext(sparkConf)

    // create map
    val numbers = Map("one" -> 1, "two" -> 2, "three" -> 3)
    // make RDD from map and save to elasticsearch
    sc.makeRDD(Seq(numbers)).saveToEs("spark/numbers")
  }
}