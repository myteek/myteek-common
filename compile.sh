#!/usr/bin/env bash

source /etc/profile

mvn clean install package -DskipTests --settings ./settings.xml


