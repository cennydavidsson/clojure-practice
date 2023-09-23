(ns exercies-4.core
  (:gen-class))

(defn prombt [word]
  (printf "Enter a %s%n" word)
  (flush)
  (read-line))


(defn -main
  "Mad-lib"
  [& args]
  (def noun (prombt "noun"))
  (def verb (prombt "verb"))
  (def adjective (prombt "adjective"))
  (def adverb (prombt "adverb"))
  (printf "Do you %1s your %2s %3s %4s? That's hilarious!" verb adjective noun  adverb))

