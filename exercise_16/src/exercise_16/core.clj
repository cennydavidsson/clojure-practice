(ns exercise-16.core
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

(defn driving-age [age]
  (if (< age 16)
    "You are not old enough to legally drive"
    "You are old enough to legally drive"))

(defn -main
  "Legal driving age"
  [& args]
  (let [age (ask-number! "What is your age?")]
    (println (driving-age age))))

