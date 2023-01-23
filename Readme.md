    This Project will get the data from the given REST API and save the data to given S3 Location.

### **Execution**:
1. First Execute the `src/main/scala/bikeapi/FetchApiData.scala` file to get the data from the API and save it to file system.
2. Once the first step is complete execute the `src/main/scala/spark/FilesToS3.scala` file to read the data from files and save it to the given s3 Location.

#### Notes:
1. You can check `src/main/scala/utils/Constants.scala` file to modify API endpoints and data paths and other required variables used in the project.
2. `Utility.scala` file has some utility methods used in the project.
3. For this project a local path is given instead of S3 path to save the final outcome.
4. Considering the smaller data size and bottleneck of infrastructure it was given as the local path instead of S3 Location.
5. Same script works with multiple environments with S3 path configured in the `Constants.scala` file.


                                Thanks for Reading