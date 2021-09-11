(ns repl_start
  (:require [clojure.string :as str]
            [clojure.pprint :as pp]))

(defn name-to-string [varname]
  (let [namestr (name varname)
        replace1 (str "/" (str/replace namestr "." "/"))
        replace2 (str/replace replace1 "-" "_")]
    replace2))

(defn ns-swap [name]
  (load (name-to-string name))
  (in-ns name)
  (use 'tools.repl-navigate))

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
;;
)

