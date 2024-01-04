(ns exercise-10.core
  (:gen-class))

(defn total-cost [items]
  (let [sum (reduce + (map #(* (% :price) (% :quantiy)) items))
        tax (* sum 0.055)
        total (+ sum tax)]
    (str "Subtotal: $" (format "%.2f" (double sum))
         "\nTax: $" (format "%.2f" tax) 
         "\nTotal: $" (format "%.2f" (double total)))))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-number! [text]
  (println text)
  (flush)
  (if-let [number (parse-long (read-line))]
    number
    (exit! "Must be a natural number")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (loop [count 1 items []]
    (let [price (ask-number! (format "Enter the price of item %d:" count))]
      (if (zero? price)
        (println (total-cost items))
        (let [quantiy (ask-number! (format "Enter the quantity of item %d" count))]
          (recur (inc count) (conj items {:price price :quantiy quantiy})))))))

