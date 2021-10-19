(deftemplate menu
    (slot primerPlato
        (type SYMBOL)
        (default sopa)
    )
    
    (slot segundoPlato
        (type SYMBOL)
        (default pollo)
    )

    (slot postre
        (type SYMBOL)
        (default fruta)
    )
    
    (slot calorias
        (type NUMBER)
        (range ?VARIABLE ?VARIABLE)
        (default 123)
    )
)

(defrule descripcionMenus
    (menu(primerPlato ?primero)(segundoPlato ?segundo)(postre ?postre)(calorias ?calorias))
    =>
    (printout t "El menu contiene "?primero" de primero, "?segundo" de segundo y "?postre" de postre, con un total de "?calorias" calorias." crlf)
)