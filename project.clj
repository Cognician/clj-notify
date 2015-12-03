(defproject clj-notify "0.1.0-SNAPSHOT"
  :description "Lambda function sends alarms"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/tools.logging "0.3.1"]
                 [com.amazonaws/aws-lambda-java-core "1.0.0"]
                 [com.amazonaws/aws-lambda-java-events "1.0.0"]
                 [clj-http "2.0.0"]
                 [cheshire "5.5.0"]
                 [uswitch/lambada "0.1.0"]]
  :java-source-paths ["src/java"]
  :resource-paths ["resources"]
  :aot :all)
