# clj-notify

Simple lambda function which sends SMS messages via Twilio and AWS Lambda

## Installation on AWS

```
lein uberjar
bash setup.sh
```

## Config

You need to configure your own Lambda. Copy and edit
resources/config.edn.sample w/o sample in name

Edit setup.sh (change AccoutID)

Connect your SNS topic to created lambda function


## License

Copyright © 2015 Cognician

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
