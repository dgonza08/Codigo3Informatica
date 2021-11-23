;(defglobal ?*nombrevariable* = valor) variables globales
;(random)
;(defmodule MODULO)
;65535
(deffacts hechos-iniciales
    (busqueda 0)
)

(defglobal ?*secret* = (+ 1 (mod (random) 100)))

(defrule input
    
)