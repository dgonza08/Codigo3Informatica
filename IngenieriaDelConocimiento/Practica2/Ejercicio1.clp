(deffacts hechos-iniciales
    (lista 3 2 27 1 31 10 9 42)
    (auxiliar 0)
)

(defrule prueba
    (lista $?principio ?numero $?final)
    =>
    (printout t "Numero tiene un valor de "?numero crlf)
)

;ESTA MAL MIRAR LOGICA

(defrule condicion
    (lista $?principio ?numero $?final)
    ?auxiliarABorrar<-(auxiliar ?aux)
    (test(< ?numero ?aux))
    =>
    (assert auxiliar ?numero)
    (retract ?auxiliarABorrar)
)