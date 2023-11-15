(ns exercise-6.core
  (:gen-class))

(defn- ask-number! [text]
  (println text)
  (flush)
  (parse-long (read-line)))

(defn valid-age? [age]
  (nat-int? age))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- years-until-retirement-answer [this-year years-left]
  (let [retirement-year (+ this-year years-left)]
    (str 
      "You have " 
      years-left 
      " years left to retirement"
      "\n"
      "It's "
      this-year
      ", so you can retire in "
      retirement-year)))

(def retirement-age-reached-answer "You can already retire")

(defn- can-retire? [years-left]
  (<= years-left 0))

(defn retirement-answer [retirement-age current-age this-year]
  (let [years-left (- retirement-age current-age)]
    (if (can-retire? years-left)
      retirement-age-reached-answer 
      (years-until-retirement-answer this-year years-left))))

(defn -main "Retirement" [& args]
  (let [current-age (ask-number! "What is your current age?")
        _ (when-not (valid-age? current-age)
            (exit! "Age must be a natural number"))
        retirement-age (ask-number! "When would you like to retire?")
        _ (when-not (valid-age? retirement-age)
            (exit! "Age must be a natural number"))
        this-year (.getYear (java.time.LocalDate/now))]
    (println (retirement-answer retirement-age current-age this-year))))

