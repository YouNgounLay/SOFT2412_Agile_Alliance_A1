#! /bin/bash

clear 

cd Assignment1/Scaffold 

gradle clean build 
gradle test jacocoTestReport

open app/build/reports/jacoco/test/html/index.html
