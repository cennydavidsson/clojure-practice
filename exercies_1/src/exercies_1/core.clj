(ns exercise-1.core
  (:gen-class))

(defn -main
  "Saying Hello. No challanges"
  [& args]
  (println "What is your name?")
  (flush)
  (def input (read-line))
  (printf "Hello, %s, nice to meet you!%n" input)
)
