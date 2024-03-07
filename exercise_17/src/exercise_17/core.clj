(ns exercise-17.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-text! [text]
  (println text)
  (flush)
  (read-line))

(defn- ask-number! [text]
  (println text)
  (flush)
  (if-let [number (parse-double (read-line))]
    number
    (exit! "Must be a natural number")))

(defn bac [alcohol weight gender time-elapsed]
  (let [gender-ratio (if (= gender :female) 0.66 0.73) 
        content (- (/ (* alcohol 5.14) (* weight gender-ratio)) (* 0.15 time-elapsed))]
    (str "Your BAC is "
         (format "%.2f" content)
         (if (< 0.08 content)
           ", it's not legal for you to drive"
           ", it's legal for you to drive"))))

(defn -main
  "Blood alcohol calculator"
  [& args]
  (let [alcohol (ask-number! "Alcohol consumed in ounces: ")
        weight (ask-number! "What is your weight in pounds: ")
        gender (ask-text! "What is your gender: ")
        time-elapsed (ask-number! "Time since last drink: ")]
    (println (bac alcohol weight (keyword gender) time-elapsed))))

