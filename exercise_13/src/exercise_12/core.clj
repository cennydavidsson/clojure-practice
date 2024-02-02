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

(defn interest [& {:keys [principal rate years period]}]
  (let [rate (/ rate 100)
        amount (* principal (Math/pow (+ 1 (/ rate period)) (* period years)))]
    (round-up amount :decimal 2)))

(defn format-interest [& {:keys [amount principal rate years period]}]
  (str "After " 
       (int years)
       " years at " 
       rate "% compunded " 
       period " times per year, the investment will be worth $" 
       (format "%.2f" amount) "."))

(defn -main
  "compunded interest"
  [& args]
  (let [investment {:principal (ask-number! "Enter the principal: ") 
                    :rate (ask-number! "Enter the rate of interest: ") 
                    :years (ask-number! "Enter the number of years: ")
                    :period (ask-number! "Enter the number of times the interest is compunded per year?")}
        interest (interest investment)]
    (println (format-interest :amount interest investment))))

