(ns exercise-18.core
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

(defn temp-unit [input]
  (let [input (clojure.string/lower-case input)]
    (case input
      "c" :celsius
      "f" :fahrenheit
      nil)))

(defn celsius->fahrenheit [celsius]
  (+ (* celsius (/ 9 5)) 32))

(defn fahrenheit->celsius [celsius]
  (* (- celsius 32) (/ 5 9)))

(defn convert-temp [temp from to] 
  (if (= from to) 
    temp
    (case [from to] 
      [:fahrenheit :celsius] (fahrenheit->celsius temp)
      [:celsius :fahrenheit] (celsius->fahrenheit temp))))

(def copy 
  {:from-unit "Convert from (C)elsius, (F)ahrenheit"
   :to-unit "to (C)elsius, (F)ahrenheit"
   :prompt-temp "Please enter temperature"
   :temp "The temperature is"})

(defn -main
  "Tempeture Converter"
  [& args]
  (let [from-unit (ask-text! temp-unit (:from-unit copy))
        to-unit (ask-text! temp-unit (:to-unit copy))
        from-temp (ask-number! (:prompt-temp copy))
        temp (convert-temp from-temp from-unit to-unit)]
    (println (:temp copy) temp)))

