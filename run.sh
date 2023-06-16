#!/bin/bash

# Build the project with Maven and suppress output
mvn clean package >/dev/null 2>&1

# Check if build succeeded
if [ $? -ne 0 ]; then
  echo "Build failed."
  exit 1
fi

# Run the tests and suppress output
mvn test >/dev/null 2>&1

# Check if tests succeeded
if [ $? -ne 0 ]; then
  echo "Tests failed."
  exit 1
fi

# Run the application and display output
mvn exec:java -Dexec.mainClass="com.matome.poker.game.PokerGame" | grep -v "\[INFO\]"
