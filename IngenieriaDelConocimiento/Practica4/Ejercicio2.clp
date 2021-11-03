(deftemplate MAIN::rectangulo
    (slot base
        (type NUMBER)
    )

    (slot altura
        (type NUMBER)
    )
)

(defmodule MAIN (export deftemplate rectangulo))
(defmodule PEDIR (import MAIN deftemplate rectangulo))
(defmodule AREA (import MAIN deftemplate rectangulo))
(defmodule PERIMETRO (import MAIN deftemplate rectangulo))

(defrule PEDIR::pedirDatos
    =>
    (printout t "Introduce la base" crlf)
    (bind ?base(read))
    (printout t "Introduce la altura" crlf)
    (bind ?altura(read))
    (assert(rectangulo(base ?base)(altura ?altura)))
)

(defrule AREA::calcularArea
    (rectangulo (base ?base)(altura ?altura))
    =>
    (printout t "El area del rectangulo es: " (* ?base ?altura) crlf)
)

(defrule PERIMETRO::calcularPerimetro
    (rectangulo (base ?base)(altura ?altura))
    =>
    (printout t "El perimetro del rectangulo es: " (+ (+ ?base ?base) (+ ?altura ?altura)) crlf)
)

(defrule MAIN::run
    =>
    (focus PERIMETRO)
    (focus AREA)
    (focus PEDIR)
)