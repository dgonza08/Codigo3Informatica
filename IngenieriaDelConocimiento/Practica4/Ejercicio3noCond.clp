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

;Esto se queda asi porque permite usar bucles para leer archivos
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

;Se queda igual
(defrule ESCRIBIR::abrir
    (declare (salience 3))
    =>
    (open alarmas.out alarmas "w") ;w de write
)

;Se comprueba a parte si es menor de 95 la temperatura 
(defrule ESCRIBIR::comprobacionTemperaturaMenor
    (declare (salience 2))
    (valvula (nombre ?nombre)(temperatura ?temp))
    (test(< ?temp 95))
    =>
    (printout alarmas ?nombre " " ?temp crlf)
)

;Se comprueba a parte si es mayor de 95 la temperatura y se imprime por pantalla que salta la alarma
(defrule ESCRIBIR::comprobacionTemperaturaMayor
    (declare (salience 2))
    (valvula (nombre ?nombre)(temperatura ?temp))
    (test(> ?temp 95))
    =>
    (printout alarmas ?nombre " " ?temp " AlarmaActivada" crlf)
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