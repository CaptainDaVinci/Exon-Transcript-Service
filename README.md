# Exon Transcript Service

A Java spring appliction for a REST service which fetches all exons for a given transcript

# Getting Started

### Running the application

#### Prerequisites
1. Java 11
2. MySQL Database

Clone this repository and run the jar file provided in the `target` directory using,

```
$ DB_HOST=<host> DB_PORT=<port> DB_USER=<user> DB_PASSWORD=<pwd> DB_NAME=<name> java -jar ./target/exon-transcript-0.0.1-SNAPSHOT.jar
```

Use the MySQL database host, port, user, passowrd and database name where you'd like to create the database. You can install the data by following the guide in https://m.ensembl.org/info/docs/webcode/mirror/install/ensembl-data.html 

Once the spring application runs successfully, navigate to `http://localhost:8080/healthcheck` in your browser and check if you get a 200 OK response. You can now query the `exons` for a given transcript ID using the end point `http://localhost:8080/api/exons?transcriptId=<id>` replace ID with the transcript ID.


### Running the tests

You can run the unit tests using the command 

```
$ mvn test
```

from the root of this project
