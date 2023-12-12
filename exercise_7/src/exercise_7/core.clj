(ns exercise-7.core
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

(def square-feet->square-meters-factor 0.09290304)

(defn- feet->meters [area]
  (* area square-feet->square-meters-factor))

(defn area-answer [width length]
  (let [area (* width length)]
    (str 
      "You entered dimensions of " width " feet by " length " feet.\n"
      "The area is\n" 
      area " square feet\n" 
      (format "%.3f" (feet->meters area)) " square meters")))

(defn -main
  "Area calculator"
  [& args]
  (let [length (ask-number! "What is the length of the room in feet?")
        width (ask-number! "What is the width of the room in feet?")]
    (println (area-answer width length))))

