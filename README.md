# Java Cloud Firestore

Real time database in Java.

Created with:

Apache flink
* https://ci.apache.org/projects/flink/flink-docs-release-1.9/getting-started/docker-playgrounds/flink-operations-playground.html

Debezium
*  https://github.com/debezium/debezium-examples/tree/master/tutorial

##How to run 
Run docker

`docker-compose up -d`

Start DB watching

`curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/ -d @register-mysql.json`

Open Apache Flink pannel

`http://localhost:8081/#/overview`
 
