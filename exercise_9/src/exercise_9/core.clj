(ns exercise-9.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-number! [text]
  (println text)
  (flush)
  (if-let [number (parse-long (read-line))]
    number
    (exit! "Must be a natural number")))

(def square-feet->gallons-factor 350)

(defn gallons [area] 
  (int (Math/ceil (/ area square-feet->gallons-factor))))
 
(defn paint-in-gallons [width length]
  (let [area (* width length)
        amount (gallons area)]
    (str 
      "You will need to purchase "
      amount
      " gallons of paint to cover " 
      area
      " square feet.")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [width (ask-number! "Width?")
        length (ask-number! "Length?")]
  (println (paint-in-gallons width length))))

