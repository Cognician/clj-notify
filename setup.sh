#!/bin/bash

aws lambda create-function \
  --function-name clj-notify23 \
  --handler clj-notify.core.MainFn \
  --runtime java8 \
  --memory 192 \
  --timeout 10 \
  --role arn:aws:iam::61106EXAMPLE:role/lambda_exec_role \
  --zip-file fileb://./target/clj-notify-0.1.0-SNAPSHOT-standalone.jar



