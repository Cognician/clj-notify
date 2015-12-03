(ns clj-notify.core
  (:require [uswitch.lambada.core :refer [deflambdafn]]
             [clojure.data.json :as json]
             [clojure.java.io :as io]
             [clojure.edn :as edn]
             [clojure.tools.logging :as log]
             [clj-http.client :as client]))


(defn get-in-config
  [config]
  (edn/read-string (slurp (io/resource config))))

(defn twilio-request
  [config phone msg]
  (let [url-base (:url-base config)
        sid (:sid config)
        token (:token config)
        from (:from config)
        url (format "%s/Accounts/%s/Messages.json" url-base sid)]
    (client/post url
                 {
                  :basic-auth [sid token]
                  :conn-timeout 1000
                  :form-params {:To phone
                                :From from
                                :Body msg}})))

(deflambdafn clj-notify.core.MainFn
  [in out ctx]
  (let [event (json/read (io/reader in))
        config (get-in-config "config.edn")]
    (doseq [phone (vals (:phones config))]
      (log/info (str "Trying to send message to: " phone))
      (try (twilio-request (:twilio config) phone
                           (str(get-in event ["Records" 0 "Sns" "Message"])))
           (catch Exception e (log/info (str "caught exception: " (.getMessage e))))))
    (with-open [w (io/writer out)]
      (json/write {:message (str(get-in event ["Records" 0 "Sns" "Message"]))} w))))



;; {:message (str (get-in event ["Records" 0 "Sns" "Message"]))})



