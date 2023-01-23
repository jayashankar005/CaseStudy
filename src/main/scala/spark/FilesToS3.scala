package spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, explode}
import utils.Constants._

import java.util
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

object FilesToS3 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master(master).appName(appName).getOrCreate()

    val files = new util.ArrayList[String]()
    for(pageNumber <- one to maxRecordsPerPage) {
      files.add(dataFilePath.format(pageNumber))
    }

    val df = spark.read.schema(schema).json(files.toSeq: _*)
    val df_all_records = df.withColumn(data, explode(col(bikes))).select(col(data))
    df_all_records.coalesce(10).write.json(dataFinalPath)
  }
}
