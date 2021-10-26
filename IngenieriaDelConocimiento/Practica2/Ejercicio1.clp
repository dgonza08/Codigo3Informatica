;Hechos iniciales del programa
(deffacts hechos-iniciales
    (lista 3 2 27 1 31 10 9 42)
    (salida 1)
)

;Imprime la primera lista sin ordenar
(defrule imprimirInicial
    (lista $?elementos)
    ?salidaBorrar<-(salida ?salida)
    =>
    (if (> ?salida 0) then
        (printout t "La lista inicial es: " $?elementos crlf)
        (retract ?salidaBorrar)
    )   
)

;Parte encargada de toda la logica del programa
(defrule ordenarLista
    ?listaBorrar<-(lista $?principio ?anterior ?numero $?final)
    =>
    (if (> ?anterior ?numero) then
        (assert(lista $?principio ?numero ?anterior $?final))
        (retract ?listaBorrar)
    )
)

;Se imprime por pantalla la lista compoleta ordenada
(defrule imprimirFinal
    (lista $?elementos)
    =>
    (printout t "La lista final es: " $?elementos crlf)
)