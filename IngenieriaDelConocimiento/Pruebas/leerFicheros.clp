(deftemplate animal
    (slot tipo
        (default desconocido)
    )

    (slot edad
        (default desconocido)
    )
)

(defrule leerFichero
    (declare (salience 1))
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
    (declare (salience 2))
    =>
    (open salidaFichero.out ficheroSalida "w")
)

(defrule cerrarFichero
    (declare (salience 4))
    =>
    (close ficheroSalida)
)

(defrule escribirFinal
    (declare (salience 3))
    (animal (tipo ?tipo)(edad ?edad))
    =>
    (printout ficheroSalida ?tipo " de " ?edad " años" crlf)
)