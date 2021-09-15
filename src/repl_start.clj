;;; This is my startup namespace for the DataRep App. 
;;; lein run - Will start running the -main function below
;;;
;;; I run the App within a docker container using the following bash alias:
;;;
;;; alias clojure-docker-syncui-datarep='cd /Users/mkersh/clojure/tools/DataRep;docker run -it -v $(pwd):/app -w /app mkersh65/clojure:version2 lein run'
;;;
;;; The above will run within an isolated docker environment running from the /app directory
;;; within the docker container. Where /app is mapped to /Users/mkersh/clojure/tools/DataRep
;;; /Users/mkersh/clojure/tools/DataRep is cloned from https://github.com/mkersh/DataRep
;;;
;;; The -it parameter passed to the docker run command is important because this then directs
;;; input and output to the host terminal that the docker is run from. Which is what we need.
;;;
;;; To start a REPL up for the DataRep that you can then attach to from your favourite Clojure Editor/IDE:
;;; 
;;; alias clojure-docker-datarep='cd /Users/mkersh/clojure/tools/DataRep;docker run -p 5007:5007 -v $(pwd):/app -w /app mkersh65/clojure:version2 lein repl :headless :host 0.0.0.0 :port 5007&'
;;; NOTE: You can then attach to the REPL using localhost:5007 from your editor

(ns repl_start
  (:require [clojure.string :as str]
            [clojure.pprint :as pp]
            [clojure.java.shell :as sh]
            [mambu.extensions.data_replication.datarep :as datarep]
            ))

;; Print the classpath
(defn printClassPath []
  (println "JAVA CLASSPATH - Has the following configuration:")
  (println "===============")
  (pp/pprint (sort (str/split
                    (System/getProperty "java.class.path")
                    #":"))))

;; This is the main function that will get called when you start using:
;; lein run
;; NOTE: The :main tag in project.clj determines what namespace/file to start in and will look for 
;; a -main function in here. The project.clj defines ":main repl_start" and so the -main below
;; is the startup function for us.
;;
(defn -main []
  ;; Start a simple terminal based UI
  (datarep/terminal-ui))

;; To test
(comment
  (printClassPath)
  ;; I had an issue with some "ln -s" files in my work directory. This shell command allowed me
  ;; to see inside the docker containers /app directory and allowed me to see the problem
  ;; I needed to use a hardlink rather than a softlink to get things working
  (sh/sh "ls" "-aul" "src/http") 
  (datarep/terminal-ui)
;;
)

