#!/bin/bash

export PORT0=${PORT0:-"8080"}

export JAVA_OPTS="--server.port=${PORT0}"

java -jar /data/app.jar ${JAVA_OPTS}
