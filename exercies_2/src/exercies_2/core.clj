(ns exercies-2.core
  (:gen-class))

(defn -main
  "Counting the number of characters"
  [& args]
  (println "What is the input string?")
  (flush)
    (loop [input (read-line)]
      (if (not (empty? input))
        (printf "%s has %d characters" input (count input))
        (do 
          (println "String can't be empty")
          (recur (read-line))))))

