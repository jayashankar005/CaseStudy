package utils

import org.apache.spark.sql.types.{StructField, StructType}
import org.apache.spark.sql.types._

object Constants {

  val bikeApiCountEndpoint = "https://bikeindex.org/api/v3/search/count"
  val dataFilePath = "./data/intermediate%s.json"
  val dataFinalPath = "./data/final_data.json"
  val bikeApiDataEndpoint = "https://bikeindex.org:443/api/v3/search?page=%s&per_page=100&stolenness=all"
  val nThreads = 10
  val maxRecordsPerPage = 100
  val stolen = "stolen"
  val non = "non"
  val master = "local[*]"
  val appName = "FilesToS3"
  val one = 1
  private val dateStolen = "date_stolen"
  private val description = "description"
  private val externalId = "external_id"
  private val frameColors = "frame_colors"
  private val frameModel = "frame_model"
  private val id = "id"
  private val isStockImg = "is_stock_img"
  private val largeImg = "large_img"
  private val locationFound = "location_found"
  private val manufacturerName = "manufacturer_name"
  private val registryName = "registry_name"
  private val registryUrl = "registry_url"
  private val serial = "serial"
  private val status = "status"
  private val stolenCoordinates = "stolen_coordinates"
  private val stolenLocation = "stolen_location"
  private val thumb = "thumb"
  private val title = "title"
  val url = "url"
  private val year = "year"
  val bikes = "bikes"
  val data = "data"
  private val True:Boolean = true

  private val element = StructType(
    Array(
      StructField(dateStolen, LongType, True),
      StructField(description, StringType, True),
      StructField(externalId, StringType, True),
      StructField(frameColors, ArrayType(StringType, True), True),
      StructField(frameModel, StringType, True),
      StructField(id, LongType, True),
      StructField(isStockImg, BooleanType, True),
      StructField(largeImg, StringType, True),
      StructField(locationFound, StringType, True),
      StructField(manufacturerName, StringType, True),
      StructField(registryName, StringType, True),
      StructField(registryUrl, StringType, True),
      StructField(serial, StringType, True),
      StructField(status, StringType, True),
      StructField(stolen, StringType, True),
      StructField(stolenCoordinates, ArrayType(DoubleType, True), True),
      StructField(stolenLocation, StringType, True),
      StructField(thumb, StringType, True),
      StructField(title, StringType, True),
      StructField(url, StringType, True),
      StructField(year, LongType, True)
    )
  )

  val schema: StructType = StructType(
    Array(
      StructField(bikes, ArrayType(element, True), True)
    )
  )

}
