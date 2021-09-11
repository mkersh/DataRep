(ns repl_start
  (:require [clojure.string :as str]
            [clojure.pprint :as pp]
            [clojure.java.shell :as sh]
            ))

;; Print the classpath
(defn printClassPath []
  (println "JAVA CLASSPATH - Has the following configuration:")
  (println "===============")
  (pp/pprint (sort (str/split
                    (System/getProperty "java.class.path")
                    #":"))))
;; To test
(comment
  (printClassPath)
  (sh/sh "ls" "-aul" "src/http")
;;
)

