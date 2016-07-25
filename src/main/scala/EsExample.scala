import org.apache.spark.SparkConf
import org.apache.spark.SparkContext    
import org.apache.spark.SparkContext._
import org.elasticsearch.spark._ 

object EsExample {

  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("EsExample")
    // sparkConf.set("es.nodes", "10.20.1.92")
    val sc = new SparkContext(sparkConf)

    val numbers = Map("one" -> 1, "two" -> 2, "three" -> 3)
    sc.makeRDD(Seq(numbers)).saveToEs("spark/numbers")
  }
}