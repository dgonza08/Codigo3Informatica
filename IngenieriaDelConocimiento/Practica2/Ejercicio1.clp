(deffacts hechos-iniciales
    (lista 3 2 27 1 31 10 9 42)
)

(defrule prueba
    (lista $?principio ?numero $?final)
    =>
    (printout t "Numero tiene un valor de "?numero crlf)
)