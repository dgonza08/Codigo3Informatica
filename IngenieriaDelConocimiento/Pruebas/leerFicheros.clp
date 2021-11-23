(deftemplate animal
    (slot tipo
        (default desconocido)
    )

    (slot edad
        (default desconocido)
    )
)

(defrule leerFichero
    =>
    (open entradaFichero.dat fichero)
    (bind ?valor (read fichero))
    (while (neq ?valor EOF) do
        (assert(animal (tipo ?valor)(edad (read fichero))))
        (bind ?valor (read fichero))
    )
    (close fichero)
)

(defrule escribirFichero

    =>
    (open salidaFichero.out ficheroSalida "w")
)

(defrule escribirFinal
    (animal (tipo ?tipo)(edad ?edad))
    =>
    (printout ficheroSalida ?tipo " de " ?edad " años" crlf)
)