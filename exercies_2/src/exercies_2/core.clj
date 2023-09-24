(ns exercies-2.core
  (:gen-class))

(defn -main
  "Counting the number of characters"
  [& args]
  (println "What is the input string?")
  (flush)
  (def input (read-line))
  (if (empty? input)
    (println "String can't be empty")
    (printf "%1s has %2d characters" input (count input))))

