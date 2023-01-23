package utils

import org.json.JSONObject
import play.api.libs.json.Json
import requests.Response
import utils.Constants.{bikeApiCountEndpoint, dataFilePath, maxRecordsPerPage, non, stolen}

import java.io.FileWriter

object Utility {
  /**
   * this method hits the get method and fetch the response from the url given.
   * @param url contains url that will be hit
   * @return returns a response object
   */
  private def getResponse(url: String): Response = {
    requests.get(url)
  }

  /**
   * this method takes the response object and write it to a file in the given path.
   * @param response
   * @param dataPath
   */
  private def writeResponseToFIle(response: Response, dataPath: String): Unit = {
    val fw: FileWriter = new FileWriter(dataPath)
    fw.write(
      Json.parse(response.text()).toString()
    )
    fw.close()
  }

  /**
   * this method takes the url end point and pagenumber of rest api as input
   * and gets the data writes it to local path.
   * @param url
   * @param pageNumber
   */
  def getDataAndSave(url: String, pageNumber: Int): Unit = {
    val response: Response = getResponse(url)
    writeResponseToFIle(response, dataFilePath.format(pageNumber))
  }

  /**
   * this method get the total number of pages possible in the
   * given API endpoint according to the data available
   * @return returns the count of possible page number
   */
  def getTotalPageCount: Int = {
    val countResponse = getResponse(bikeApiCountEndpoint)
    val countJSONObject = new JSONObject(countResponse)
    val totalPageCount: Int = (countJSONObject.get(stolen).asInstanceOf[Int] +
      countJSONObject.get(non).asInstanceOf[Int]) / maxRecordsPerPage
    totalPageCount
  }
}
