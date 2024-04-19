(ns exercise-22.core
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

(defn max-number 
  "Not allowed to use max function in this challange."
  [n1 n2 n3] 
  (when (distinct? n1 n2 n3)
    (if (> n1 n2 ) 
      n1 
      (if (> n2 n3) 
        n2 
        n3))))

(defn -main
  "Comparing numbers"
  [& args]
  (let [first (ask-number! "Enter the first number: ")
        second (ask-number! "Enter the second number: ")
        third (ask-number! "Enter the third number: ")]
    (if-let [largest (max-number first second third)]
      (println "The largest number is" largest)
      (println "Found duplicates"))))

