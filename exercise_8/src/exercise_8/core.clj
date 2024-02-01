(ns exercise-8.core
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


(defn pizza-party [people pizzas slices]
  (let [slices (* pizzas slices)
        slicesPerPerson (quot slices people)
        leftover (rem slices people)]
    (str 
      people " people with " pizzas " pizzas\n"
      "Each person gets " slicesPerPerson " pieces of pizza.\n"
      "There are " leftover " leftover pieces.")))

(defn -main
  "Pizza party"
  [& args]
  (let [people (ask-number! "How many people?")
        pizzas (ask-number! "How many pizzas do you have?")
        slices (ask-number! "How many slices should each pizza have?")]
    (println (pizza-party people pizzas slices))))
