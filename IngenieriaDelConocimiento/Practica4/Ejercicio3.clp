(deftemplate MAIN::valvula
    (slot nombre
        (type SYMBOL)
    )
    (slot temperatura
        (type NUMBER)
    )
)

(defmodule MAIN (export deftemplate valvula))
(defmodule LEER (import MAIN deftemplate valvula))
(defmodule ESCRIBIR (import MAIN deftemplate valvula))

(defrule LEER::input
    =>
    (open temperaturas.dat fichero)
    (bind ?valor (read fichero))
    (while (neq ?valor EOF) do
        (assert(valvula (nombre ?valor)(temperatura (read fichero))))
        (bind ?valor (read fichero))
    )
    (close fichero)
)

(defrule ESCRIBIR::abrir
    (declare (salience 3))
    =>
    (open alarmas.out alarmas "w")
)

(defrule ESCRIBIR::comprobar
    (declare (salience 2))
    (valvula (nombre ?nombre)(temperatura ?temp))
    =>
    (if (> ?temp 95) then
        (printout alarmas ?nombre " " ?temp " AlarmaActivada" crlf)
    else
        (printout alarmas ?nombre " " ?temp crlf)
    )
)

(defrule ESCRIBIR::cerrar
    (declare (salience 1))
    =>
    (close alarmas)
)

(defrule MAIN::run
    =>
    (focus ESCRIBIR)
    (focus LEER)
)