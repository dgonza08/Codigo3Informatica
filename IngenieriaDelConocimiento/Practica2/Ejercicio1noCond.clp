;Hechos iniciales del programa
(deffacts hechos-iniciales
    (lista 3 2 27 1 31 10 9 42)
    (salida 1)
)

;Imprime la primera lista sin ordenar
(defrule imprimirInicial
    (lista $?todo)
    =>
    (printout t "La lista inicial es: " $?todo crlf)
    (assert(listaFinal $?todo))
)

;Parte encargada de toda la logica del programa
(defrule ordenarLista
    ?listaBorrar<-(listaFinal $?principio ?anterior ?numero $?final)
    (test (> ?anterior ?numero))
    =>
    (assert(listaFinal $?principio ?numero ?anterior $?final))
    (retract ?listaBorrar)
)

;Se imprime por pantalla la lista compoleta ordenada
(defrule imprimirFinal
    (listaFinal $?elementos)
    =>
    (printout t "La lista final es: " $?elementos crlf)
)