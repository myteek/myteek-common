#!/usr/bin/env bash

source /etc/profile

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -DskipTests --settings ./settings.xml


