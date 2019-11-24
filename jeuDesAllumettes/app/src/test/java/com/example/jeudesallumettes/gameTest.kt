package com.example.jeudesallumettes

import org.junit.Test

import org.junit.Assert.*

class gameTest {

    @Test fun retirer() {
        val beuleu = game()
        assertEquals(true, beuleu.retirerAllumettes(10,15,"beuleu", "beul", "beuleu"))
        assertEquals(false, beuleu.retirerAllumettes(15,15,"beuleu", "beul", "beuleu"))

    }

}