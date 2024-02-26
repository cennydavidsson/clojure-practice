(ns exercise-15.core
  (:gen-class))

(defn- exit! [message]
  (println message)
  (System/exit 0))

(defn- ask-text! [text]
  (println text)
  (flush)
  (read-line))

(defn validate-user [username password store]
  (= password (store username)))

(defn -main
  "Password Validator"
  [& args]
  (let [username (ask-text! "What is the username?")
        password (ask-text! "What is the password?")]
    (if (validate-user username password "asdf")
      (println "Welcome!")
      (println "I don't know you."))))

