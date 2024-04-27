(ns exercise-24.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-text! 
  ([text]
   (ask-text! (fn [x] x) text))
  ([f text]
   (ask-text! f "Couldn't parse input" text))
  ([f error text]
   (println text)
   (flush)
   (if-let [value (f (read-line))]
     value
     (exit! error))))

(defn anagram? [s1 s2]
  (= (sort s1) (sort s2)))

(defn -main
  "Anagram checker"
  [& args]
  (println "Enter two strings and I'll tell you if they are anagrams:")
  (let [first (ask-text! "Enter the first string:")
        second (ask-text! "Enter the second string:")]
    (if (anagram? first second)
      (println first "and" second "are anagrams")
      (println first "and" second "are not anagrams"))))

