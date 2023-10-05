(ns exercies-3.core
  (:gen-class))

(defn -main
  "Printing Quotes"
  [& args]
  (println "What is the quote?")
  (flush)
  (def quote (read-line))
  (println "Who said it?")
  (def author (read-line))
  (println author "says," (str \" quote \")))

