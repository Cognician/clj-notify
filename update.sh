#!/bin/bash

aws lambda update-function-code \
  --function-name clj-notifyc \
  --zip-file fileb://./target/clj-notify-0.1.0-SNAPSHOT-standalone.jar
