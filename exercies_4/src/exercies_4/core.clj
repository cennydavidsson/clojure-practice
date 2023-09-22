(ns exercies-4.core
  (:gen-class))

(defn -main
  "Mad-lib"
  [& args]
  (println "Enter a noun:")
  (flush)
  (def noun (read-line))
  (println "Enter a verb:")
  (flush)
  (def verb (read-line))
  (println "Enter a adjective:")
  (flush)
  (def adjective (read-line))
  (println "Enter a adverb")
  (flush)
  (let [adverb (read-line)]
    (println "Do you" verb "your" adjective noun (str adverb "?") "That's hilarious!")))

