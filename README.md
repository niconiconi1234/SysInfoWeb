# SysInfoWeb
## Description
This is a simple web server that displays server information to clients. It is written in Java and uses the Spring Boot framework.

After launching this application, a web server will be started on port 8080. Users can get the server information by accessing the following URL: http://server-hostname:8080/sysinfo (replace `server-hostname` with the actual hostname of the server).

## Usage example
After launching this application on localhost......

```
$ curl http://localhost:8080/sysInfo
{"hostname":"huajuan-ws","osVersion":"5.15.90.1-microsoft-standard-WSL2","cpuCores":"12","javaVersion":"20.0.2","userWorkingDirectory":"/home/huajuan/code/SysInfoWeb","userHomeDirectory":"/home/huajuan","javaVendor":"Oracle Corporation","osName":"Linux","javaHomeDirectory":"/home/huajuan/.sdkman/candidates/java/20.0.2-graal"}
```

## Build Requirements
* Java 17 or higher

## Build
To build this application, run the following command:
```
./gradlew build
```
The build result will be located in the `build/libs` directory.

## Build with GraalVM
To build a native image of this application using GraalVM, run the following command:
```
./gradlew nativeCompile
```
The build result will be located in the `build/native` directory.


## Docker

### Use Docker Hub Image

We have built a Docker image for this application and pushed it to Docker Hub. You can pull it by running the following command:
```
docker pull huajuan6848/sys-info-web:tatest
```
Then run the following command to start the container:
```
docker run -p 8080:8080 huajuan6848/sys-info-web:tatest
```
You can access the server information by accessing the following URL: http://localhost:8080/sysInfo
### Build Docker Image By Yourself

You can also build a Docker image by yourself. To do this, run the following command:
```
docker build -t sys-info-web .
```
Then run the following command to start the container:
```
docker run -p 8080:8080 sys-info-web
```