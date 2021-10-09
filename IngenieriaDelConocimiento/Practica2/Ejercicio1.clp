(deffacts hechos-iniciales
    (lista 3 2 27 1 31 10 9 42)
    (numeroGuardado 0)
)

(defrule prueba
    (lista $?principio ?numero $?final)
    ?auxABorrar<-(numeroGuardado ?aux)
    =>
    (assert (numeroGuardado ?numero))
    (printout t "Numero tiene un valor de "?numero crlf)
    (retract ?auxABorrar)
)

(defrule comprobarSiMayorOMenor
    (lista $?principio ?numero $?final)
    ?auxABorrar<-(numeroGuardado ?aux)
    (test(< ?numero numeroGuardado))
    =>    
    
)