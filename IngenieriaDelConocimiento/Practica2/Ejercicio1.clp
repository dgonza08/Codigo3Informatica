(deffacts hechos-iniciales
    (lista 3 2 27 1 31 10 9 42)
    (auxiliar 0)
    (iteracion 0)
    (longitud 0) ;Al final se almacena en longitudFinal
)

;Prueba solamente, no incluye nada de logica del ejercicio
(defrule pruebaIncial
    (lista $?principio ?numero $?final)
    =>
    (printout t "Numero tiene un valor de "?numero crlf)
)

;Esta funciona bien
(deffunction cuentaElementos
    ($?argumentos)
    (length $?argumentos)
)

;Funciona perfectamente
(defrule longitud
    (lista $?argumentos)
    ?longitudModificar<-(longitud ?longitud)
    =>
    (assert(longitudFinal (cuentaElementos $?argumentos)))
    (retract ?longitudModificar)
)

;Con esta implementacion funciona bien
(deffunction comprobarMayor (?a ?b)
    (if(< ?a ?b) then
        (return ?b)
    )

    (if(> ?a ?b) then
        (return ?a)
    )
)


;(defrule ordenarLista
;    ?listaBorrar<-(lista $?principio ?numero $?final)
;    ?auxiliarBorrar<-(auxiliar ?aux)
;    ?iteracionModificar<-(iteracion ?iteracion)
;    (longitudFinal ?longitud)
;    (test(< ?iteracion ?longitud))
;    =>
;    (assert(listaFinal $?principio (comprobarMayor ?numero ?aux) $?final))
;    (bind ?iteracion(+ 1 ?iteracion))
;    (retract ?auxiliarBorrar)
;    (retract ?listaBorrar)
;)