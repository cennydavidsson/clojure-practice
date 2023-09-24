(ns exercies-2.core
  (:gen-class))

(defn -main
  "Counting the number of characters"
  [& args]
  (println "What is the input string?")
  (flush)
  (let [input (read-line)]
    (if (empty? input)
      (println "String can't be empty")
      (printf "%s has %d characters" input (count input)))))

