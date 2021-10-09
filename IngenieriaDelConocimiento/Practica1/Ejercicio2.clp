(deffacts hechosIniciales
    (lista a b c d e f g)
)

(defrule mostrarPrimero
    (lista ?primerElemento $? ?ultimoElemento)
    =>
    (printout t "El primer elemento es: "?primerElemento crlf)
    (printout t "El ultimo elemento es: "?ultimoElemento crlf)
)

(defrule intercambiar
    ?indice<-(lista ?primerElemento $?medio ?ultimoElemento)
    =>
    (assert(listaResultado ?ultimoElemento $?medio ?primerElemento))
    (retract ?indice)
)