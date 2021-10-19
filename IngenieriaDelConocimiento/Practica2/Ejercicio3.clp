(deftemplate menu
    (slot primerPlato
        (type SYMBOL)
        (default ?NONE)
    )
    
    (slot segundoPlato
        (type SYMBOL)
        (default ?NONE)
    )

    (slot postre
        (type SYMBOL)
        (default ?NONE)
    )
    
    (slot calorias
        (type NUMBER)
        (range ?VARIABLE ?VARIABLE)
        (default ?NONE)
    )
)

