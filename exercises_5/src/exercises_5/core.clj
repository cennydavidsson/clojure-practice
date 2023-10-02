(ns exercises-5.core
  (:gen-class))
(require '[clojure.string :as string])

(defn join-terms [term1 term2 operator result]
  (string/join " " [term1 operator term2 "=" result]))

(defn format-expressions [input1 input2]
  (let [format (partial join-terms input1 input2)
        result #(str (% (read-string input1) (read-string input2)))]
    (map 
      #(let [[operator f] %] 
          (format operator (result f))) 
      [["+" +] ["-" -] ["*" *] ["/" /]])))

(defn -main
  "Simple math"
  [& args]
  (print "What is the first number ")
  (flush)
  (let [first (read-line)]
    (print "What is the second number ")
    (flush)
    (let [second (read-line)]
      (run! println (format-expressions first second)))))

