(ns exercise-23.core
  (:gen-class))

(defn car-issue [state answer] 
  (case [state answer]
    [:silent true] :battery-corroded 
    [:silent false] :clicking
    [:battery-corroded true] :clean-terminals
    [:battery-corroded false] :replace-cables
    [:clicking true] :replace-battery
    [:clicking false] :crank-up
    [:crank-up true] :check-spark
    [:crank-up false] :engine-die
    [:engine-die true] :fuel-injection
    [:fuel-injection true] :service
    [:fuel-injection false] :check-choke))

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

(def copy 
  {:silent "Is the car silent when you rurn the key?"
   :battery-corroded "Are the battery terminals corroded?"
   :replace-battery "Replace the battery"
   :replace-cables "Replace cables and try again."
   :clicking "Does the car make clicking noise?"
   :crank-up "Does the car crank up but fail to start?"
   :check-spark "Check spark plug connections"
   :engine-die "Does the engine start and then die?"
   :fuel-injection "Does your car have fuel injection?"
   :check-choke "Check to ensure the choke is opening and closing."
   :service "Get it in for service."
   :clean-terminals "Clean terminals and try starting again"})

(defn done [state] 
  (contains? #{:clean-terminals :check-spark :service :check-choke :replace-battery :replace-cables} state))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (loop [state :silent]
    (if (done state)
      (println (copy state))
      (let [answer (ask-text! (copy state))]
        (recur (car-issue state (= answer "y")))))))

