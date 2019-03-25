#!/bin/sh
mvn clean package && docker build -t it.ciacformazione/NostalCIAC .
docker rm -f NostalCIAC || true && docker run -d -p 8080:8080 -p 4848:4848 --name NostalCIAC it.ciacformazione/NostalCIAC 
