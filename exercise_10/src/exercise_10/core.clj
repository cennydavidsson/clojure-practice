(ns exercise-10.core
  (:gen-class))

(defn total-cost [[item1 item2 item3]]
  (let [item1 (* (:quantiy item1) (:price item1))
        item2 (* (:quantiy item2) (:price item2))
        item3 (* (:quantiy item3) (:price item3))
        sum (+ item1 item2 item3)
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
  (let [price1 (ask-number! "Enter the price of item 1:")
        quantity1 (ask-number! "Enter the quantity of item 1")
        price2 (ask-number! "Enter the price of item 2:")
        quantity2 (ask-number! "Enter the quantity of item 2")
        price3 (ask-number! "Enter the price of item 3:")
        quantity3 (ask-number! "Enter the quantity of item 3")]
    (println (total-cost [{:quantiy price1 :count quantity1}
                          {:quantiy price2 :count quantity2}
                          {:quantiy price3 :count quantity3}]))))
