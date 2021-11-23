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

(defrule esMamifero
    (animal(sangre ?sangre)(piel ?piel)(desplazamiento ?desp))
    (test(and(eq ?sangre caliente)(eq ?piel pelo)(eq ?desp tierra)))
    =>
    (printout t "Mamifero" crlf)
)

(defrule esMurcielago
    (animal(sangre ?sangre)(piel ?piel)(desplazamiento ?desp))
    (test(and(eq ?sangre caliente)(eq ?piel pelo)(eq ?desp aire)))
    =>
    (printout t "Murcielago" crlf)
)

(defrule esAve
    (animal(sangre ?sangre)(piel ?piel)(desplazamiento ?desp))
    (test(and(eq ?sangre caliente)(eq ?piel plumas)(eq ?desp aire)))
    =>
    (printout t "Ave" crlf)
)

(defrule esAvestruz
    (animal(sangre ?sangre)(piel ?piel)(desplazamiento ?desp))
    (test(and(eq ?sangre caliente)(eq ?piel plumas)(eq ?desp tierra)))
    =>
    (printout t "Avestruz" crlf)
)

(defrule esReptil
    (animal(sangre ?sangre)(piel ?piel)(desplazamiento ?desp))
    (test(and(eq ?sangre fria)(eq ?piel escamas)))
    =>
    (printout t "Reptil" crlf)
)

(defrule esAnfibio
    (animal(sangre ?sangre)(piel ?piel)(desplazamiento ?desp))
    (test(and(eq ?sangre fria)(eq ?piel porosa)))
    =>
    (printout t "Anfibio" crlf)
)