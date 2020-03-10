package tests;

import framework.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    private Player joueur1;
    private Player joueur2;
    private Player joueur3;

    @Before
    public void faireAvant() {
        joueur1 = new Player(1);
        joueur2 = new Player(2);
        joueur3 = new Player(3);
        joueur1.setScore(10);
        joueur2.setScore(5);
        joueur3.setScore(10);
    }

    @Test
    public void joueurNameTest() {
        assertEquals(joueur1.getName(), "Player #1");
        assertEquals(joueur2.getName(), "Player #2");
        assertEquals(joueur3.getName(), "Player #3");
    }

    @Test
    public void compareJoueurTest() {
        assertEquals(joueur1.compareTo(joueur2), -1);
        assertEquals(0, joueur1.compareTo(joueur3));
        assertEquals(joueur2.compareTo(joueur3), joueur2.compareTo(joueur1));
        assertEquals(1, joueur2.compareTo(joueur3));
    }

    @Test
    public void toStringJoueurTest() {
        assertEquals("Player #1: 10 points", joueur1.toString());
        assertNotEquals("Player #2: 10 points", joueur2.toString());
        joueur2.setScore(10);
        assertEquals("Player #2: 10 points", joueur2.toString());
        assertEquals("Player #3: 10 points", joueur3.toString());
    }
}
