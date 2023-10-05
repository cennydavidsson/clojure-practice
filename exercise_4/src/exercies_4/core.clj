(ns exercies-4.core
  (:gen-class))

(defn prombt-for [word]
  (printf "Enter a %s%n" word)
  (flush)
  (read-line))


(defn -main
  "Mad-lib"
  [& args]
  (let [noun (prombt-for "noun") 
        verb (prombt-for "verb")
        adjective (prombt-for "adjective")
        adverb (prombt-for "adverb")]
    (printf "Do you %1s your %2s %3s %4s? That's hilarious!" verb adjective noun adverb)))

