(ns exercise-21.core
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
  (ask-text! #(Integer/parseInt %) "Must be a natural number" text))

(def months 
    {1 "January"
     2 "Febuary"
     3 "March"
     4 "April"
     5 "May"
     6 "June"
     7 "July"
     8 "August"
     9 "September"
     10 "October"
     11 "November"
     12 "December"})

(defn month [n] 
  (get months n))

(defn -main
  "Numbers to Names"
  [& args]
  (let [number (ask-number! "Please enter the number of the month:")]
    (if-let [name (month number)]
      (println "The name of the month is" name)
      (println "The number is out of scope"))))

