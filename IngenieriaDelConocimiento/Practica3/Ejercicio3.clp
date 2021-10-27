(deftemplate animal
    (slot sangre
        (type SYMBOL)
        (default nada)
        (allowed-symbols caliente fria nada)
    )
    (slot piel
        (type SYMBOL)
        (default nada)
        (allowed-symbols pelo plumas escamas porosa nada)
    )
    (slot desplazamiento
        (type SYMBOL)
        (default nada)
        (allowed-symbols tierra aire nada)
    )
)

(defrule input
    (initial-fact)
    =>
    (printout t "Introduce el tipo de sangre(caliente, fria o nada): " crlf)
    (bind ?sangre(read))
    (printout t "Introduce el tipo de piel(pelo, plumas, escamas, porosa o nada): " crlf)
    (bind ?piel(read))
    (printout t "Introduce el tipo de desplazamiento(tierra, aire o nada): " crlf)
    (bind ?despl(read))
    (assert(animal(sangre ?sangre)(piel ?piel)(desplazamiento ?despl)))
)

(defrule queAnimalEs
    (animal(sangre ?sangre)(piel ?piel)(desplazamiento ?desp))
    =>
    (if (and(eq ?sangre caliente)(eq ?piel pelo)) then
        (if (eq ?desp tierra) then
            (printout t "Mamifero" crlf)
        else
            (printout t "Murcielago" crlf)
        )
    )
    (if (and(eq ?sangre caliente)(eq ?piel plumas)) then
        (if (eq ?desp aire) then
            (printout t "Ave" crlf)
        else
            (printout t "Avestruz" crlf)
        )
    )
    (if (and(eq ?sangre fria)(eq ?piel escamas)) then
        (printout t "Reptil" crlf)
    )
    (if (and(eq ?sangre fria)(eq ?piel porosa)) then
        (printout t "Anfibio" crlf)
    )
)