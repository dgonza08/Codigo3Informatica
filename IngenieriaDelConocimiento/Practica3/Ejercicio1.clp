(defrule leerNombres
    =>
        (open archivoEntrada1.txt fichero)
        (bind ?valor (read fichero))
        (while (neq ?valor EOF) do
            (assert(persona ?valor (read fichero)(read fichero)))
            (bind ?valor (read fichero))
        )
        (close fichero)
)

(defrule imprimir
    (persona $?nombre)
    =>
    (printout t "Mi nombre es: "$?nombre crlf)
)