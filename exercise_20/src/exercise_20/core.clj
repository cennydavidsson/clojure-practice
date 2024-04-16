(ns exercise-20.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-text! 
  ([text]
   (ask-text! (fn [x] x) text))
  ([f text]
   (ask-text! f "Couldn't parse input" text))
  ([f error text]
   (println text)
   (flush)
   (if-let [value (f (read-line))]
     value
     (exit! error))))

(defn- ask-number! [text]
  (ask-text! parse-double "Must be a natural number" text))

(def state-taxes 
  {"Wisconsin" {"Eau Claire County" 1.05
                "Dunn County" 1.04}
   "Illinois" 1.08})

(defn- get-tax [state county]
  (when-let [state-tax (get state-taxes state)]
    (if (map? state-tax)
      (get state-tax county)
      state-tax)))

(defn sales-tax [order state county]
  (when-let [tax (get-tax state county)]
    (let [total (* order tax)]
      {:tax (- total order) :total total})))

(defn -main
  "Multistate Sales Tax Calculator"
  [& args]
  (let [order (ask-number! "What is the order amount?: ")
        state (ask-text! "What state do you live in?: ")
        county (ask-text! "What is you county?: ")
        result (sales-tax order state county)]
    (if result
      (println "The tax is" (:tax result) "USD" "\n"
               "The total is:" (:total result) "USD")
      (println "Could not find state or county"))))

