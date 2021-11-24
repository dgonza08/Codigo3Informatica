(deftemplate MAIN::animal
    (slot tipo
        (type SYMBOL)
    )
    (slot edad
        (type INTEGER)
    )
)

(defmodule MAIN (export deftemplate animal))
(defmodule LEER (import MAIN deftemplate animal))
(defmodule ESCRIBIR (import MAIN deftemplate animal))

(defrule LEER::leerFichero
    =>
    (open entradaFichero.dat fichero)
    (bind ?valor (read fichero))
    (while (neq ?valor EOF) do
        (assert(animal (tipo ?valor)(edad (read fichero))))
        (bind ?valor (read fichero))
    )
    (close fichero)
)

(defrule ESCRIBIR::abrirFichero
    (declare (salience 3))
    =>
    (open salidaFichero.out ficheroSalida "w")
)

(defrule ESCRIBIR::cerrarFichero
    (declare (salience 1))
    =>
    (close ficheroSalida)
)

(defrule ESCRIBIR::escribirFinal
    (declare (salience 2))
    (animal (tipo ?tipo)(edad ?edad))
    =>
    (printout ficheroSalida ?tipo " de " ?edad " años" crlf)
)

(defrule MAIN::run
    =>
    (focus ESCRIBIR)
    (focus LEER)
)