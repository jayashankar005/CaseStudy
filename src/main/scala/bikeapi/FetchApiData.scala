package bikeapi

import utils.Constants.{bikeApiDataEndpoint, nThreads, one}
import utils.Utility.{getDataAndSave, getTotalPageCount}

import java.util.concurrent.{CompletableFuture, Executors}

object FetchApiData {

  /**
   * the run method will fetch the api data in batches asynchronously
   */
  private def run(): Unit ={
    val executorService = Executors.newFixedThreadPool(nThreads)

    for (pageNumber <- one to getTotalPageCount) {
      CompletableFuture.runAsync(() =>
        getDataAndSave(bikeApiDataEndpoint.format(pageNumber), pageNumber),
        executorService)
    }

    executorService.shutdown()
  }

  def main(args: Array[String]): Unit = {
    run()
  }
}