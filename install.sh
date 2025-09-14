#!/bin/bash
set -e

echo "Deploying ROOT.war to Tomcat..."

# Stop Tomcat
sudo systemctl stop tomcat || true

# Remove old deployment
sudo rm -rf /usr/share/tomcat/webapps/ROOT*

# Move new WAR
sudo mv /tmp/ROOT.war /usr/share/tomcat/webapps/ROOT.war

# Start Tomcat
sudo systemctl start tomcat

echo "Deployment completed!"
