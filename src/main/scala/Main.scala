import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.SparkConf

object Main extends App {
  val conf: SparkConf = new SparkConf()
    .setAppName("Simple Application")
    .setMaster("local[1]")
    .set("spark.driver.memory", "1G")
    // Setting this property is often necessary for testing if you have issues with memory limits
    .set("spark.testing.memory", "2147480000")

  val sparkSession: SparkSession = SparkSession
    .builder()
    .config(conf)
    .enableHiveSupport()
    .getOrCreate()

  val inputDF: DataFrame = sparkSession.sql("SELECT 'A' AS column")
  print(inputDF.show())
}
