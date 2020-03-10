package tests;

import bunco.FactoryBunco;
import framework.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {
    private Jeu maPartie1;
    private Jeu maPartie2;
    private Jeu maPartie3;
    private FactoryBunco fBunco;

    /**
     * On fait les tests pour un jeu de Bunco, étant donné qu'il s'agit du seul jeu implémenté
     */
    @Before
    public void faireAvant() {
        fBunco = new FactoryBunco();
        maPartie1 = fBunco.creerPartie(3, 3, 4);
        maPartie2 = fBunco.creerPartie(5, 4, 8);
        maPartie3 = fBunco.creerPartie(5, 3, 4);
    }

    @Test
    public void gamePlayersTest() {
        assertEquals(3, maPartie1.getPlayers().size());
        assertEquals(5, maPartie2.getPlayers().size());
        assertEquals(5, maPartie3.getPlayers().size());
        TabIterator iter = maPartie2.getPlayers().iterator();
        int i = 0;
        while (iter.hasNext()) {

            assertEquals("Player #" + i + ": 0 points", iter.next().toString());
            i++;
        }
    }

    @Test
    public void gameDiceTest() {
        assertEquals(3, maPartie1.getDes().size());
        assertEquals(3, maPartie2.getDes().size());
        assertEquals(3, maPartie3.getDes().size());
        TabIterator iter = maPartie2.getDes().iterator();

        while (iter.hasNext()) {
            assertEquals(((De) iter.next()).getNbFaces(), 6);
        }
    }

    @Test
    public void gameWinnerTest() {
        TabIterator iter = maPartie1.getPlayers().iterator();
        int i = 3;
        PlayerCollection players = new PlayerCollection();
        while (iter.hasNext()) {
            Player p = (Player) iter.next();
            p.setScore(i);
            players.add(p);
            i--;
        }
        assertArrayEquals(maPartie1.calculerLeVainqueur().toArray(), players.toArray());

    }

//    @Test(expected=IllegalArgumentException.class)
//    public void deNullTest(){
//     //  assertTrue(joueur1.compareTo(null));
//    }
}
