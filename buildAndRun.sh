#!/bin/sh
mvn clean package && docker build -t ma.Gadi/TpCompteBancaire .
docker rm -f TpCompteBancaire || true && docker run -d -p 9080:9080 -p 9443:9443 --name TpCompteBancaire ma.Gadi/TpCompteBancaire