(ns exercise-11.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-number! [text]
  (println text)
  (flush)
  (if-let [number (parse-double (read-line))]
    number
    (exit! "Must be a natural number")))

(defn- round-up [value & {:keys [decimal]}]
  (let [decimal (Math/pow 10 decimal)]
    (/ (Math/ceil (* decimal value)) decimal)))

(defn convert-currency [& {:keys [amount rate-from rate-to]}]
  (let [converted (-> (* amount rate-from)
                      (/ rate-to)
                      (round-up :decimal 2))]
    (str 
      amount 
      " euros at an exchange rate of "
      rate-from
      " is "
      converted 
      " U.S. dollars.")))

(defn -main
  "Currency Conversion"
  [& args]
  (let [amount (ask-number! "How many euros are you exchanging?")
        euro-rate (ask-number! "What is the exchange rate?")
        us-rate 100]
    (println (convert-currency 
               :amount amount 
               :rate-from euro-rate 
               :rate-to us-rate))))
