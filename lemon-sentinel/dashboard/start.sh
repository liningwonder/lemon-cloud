#! /bin/bash

java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=192.168.50.241:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.1.jar