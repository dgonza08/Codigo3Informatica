(deftemplate animal
    (slot tipo
        (type symbol)
        (default desconocido)
    )

    (slot edad
        (type integer)
        (default desconocido)
    )
)

(defrule leerFichero
    (initial-fact)
    =>
    (open entradaFichero.dat fichero)
    (bind ?valor (read fichero))
    (while (neq ?valor eof)
        (assert (animal (tipo ?valor) (edad (read fichero))))
        (bind ?valor (read fichero))
    )
    (close fichero)
)