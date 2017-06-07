(ns demo.core
  (:require
   [taoensso.sente :as sente]))


#?(:cljs (enable-console-print!))


(defn run
  "Initialization function"
  []
  (println "demo" #:ns{:k 1}))


(run)
