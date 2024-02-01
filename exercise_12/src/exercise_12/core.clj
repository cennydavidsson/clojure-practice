(ns exercise-12.core
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

(defn interest [& {:keys [principal rate years]}]
  (let [rate (/ rate 100)
        amount (* principal (+ 1 (* rate years)))]
    (round-up amount :decimal 2)))

(defn format-interest [& {:keys [amount principal rate years]}]
  (str "After " 
       (int years)
       " years at " 
       rate "%, the investment will be worth $" 
       (format "%.2f" amount) "."))

(defn -main
  "Simple interest"
  [& args]
  (let [investment {:principal (ask-number! "Enter the principal: ") 
                    :rate (ask-number! "Enter the rate of interest: ") 
                    :years (ask-number! "Enter the number of years: ")}
        interest (interest investment)]
    (println (format-interest :amount interest investment))))

