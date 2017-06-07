;; #!/usr/bin/env boot

(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies
 '[
   ;; Boot setup
   [adzerk/boot-cljs "2.0.0"]
   [adzerk/boot-cljs-repl   "0.3.3"] ;; latest release
   [com.cemerick/piggieback "0.2.1"  :scope "test"]
   [weasel                  "0.7.0"  :scope "test"]
   [org.clojure/tools.nrepl "0.2.12" :scope "test"]
   [adzerk/boot-reload "0.5.1" :scope "test"]
   [pandeiro/boot-http "0.8.0" :scope "test"]

   ;; App dependencies
   [com.taoensso/sente "1.11.0"]
   [org.clojure/clojure "1.9.0-alpha17"]
   [org.clojure/clojurescript "1.9.562"]
   [org.clojure/core.async "0.3.443"]
   ])

(load-data-readers!)

(task-options!
 pom {:project 'sente-demo
      :version "0.1.0-SNAPSHOT"})

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl cljs-repl-env start-repl]]
 '[adzerk.boot-reload :refer [reload]]
 '[pandeiro.boot-http :refer [serve]]
 )

(deftask run-dev
  []
  (comp
   (watch)
   (notify :title "Demo build"
           :visual true
           :audible true
           )
   (cljs :source-map true
         :optimizations :none
         )
   (serve :reload true
          :httpkit true
          )))
