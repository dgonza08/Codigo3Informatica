(defrule leerNombres
    =>
    (open archivoEntrada1.txt fichero)
    (assert(persona(read fichero)))
    (close fichero)
)

(defrule imprimir
    (persona ?nombre)
    =>
    (printout t "Mi nombre es: "?nombre crlf)
)