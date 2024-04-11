(ns exercise-19.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-text! 
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

(defn bmi [{:keys [height weight]}]
  (* 703 (/ weight (* height height))))

(defn health [bmi]
  (cond 
    (< bmi 18.5) :underweight
    (< 25 bmi) :overweight
    :else :normal))

(efn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [weight (ask-number! "What is your weight?")
        height (ask-number! "What is your height?")
        bmi (bmi {:height height :weight weight})]
    (println "your BMI is" bmi)
    (println (case (health bmi)
               :overweight "You are overweight. You should see a doctor."
               :underweight "You are underweight. You should eat more."
               :normal "You are within the ideal weight range."))))
  
