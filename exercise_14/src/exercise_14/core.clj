(ns exercise-14.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-text! [text]
  (println text)
  (flush)
  (read-line))

(defn- ask-number! [text]
  (println text)
  (flush)
  (if-let [number (parse-double (read-line))]
    number
    (exit! "Must be a natural number")))

(defn- round-up [value & {:keys [decimal]}]
  (let [decimal (Math/pow 10 decimal)]
    (/ (Math/ceil (* decimal value)) decimal)))

(defn- truncate [value & {:keys [decimal]}]
  (let [decimal (Math/pow 10 decimal)]
    (double (/ (int (* decimal value)) decimal))))

(defn tax [amount state]
  (if (= state "WI")
    (let [tax-rate 1.055
          total (round-up (* amount tax-rate) :decimal 2)
          tax (truncate (- total amount) :decimal 2)]
      {:total total :subtotal amount :tax tax})
    {:total amount}))

(defn -main
  "Tax Calculator"
  [& args]
  (let [amount (ask-number! "What is the order amount?")
        state (ask-text! "What is the state?")
        result (tax amount state)]
    (println (str 
               (when-let [subtotal (result :subtotal)]
                 (format "The subtotal is $%.2f\n" subtotal))
               (when-let [tax (result :tax)]
                 (format "The tax is $%.2f\n" tax))
               (format "The total is $%.2f" (result :total))))))

