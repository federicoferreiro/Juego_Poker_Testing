package poker;


import org.junit.Assert;

import org.junit.Test;
import java.util.ArrayList;



public class TestDeRankingCombinaciones {
	
    @Test
    public void testRoyalFlush() {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CABALLO));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REINA));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_10));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esRoyalFlush(combo.resumenDeCartas), false);


    }
    @Test
    public void testEsOnePair() {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CABALLO));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esOnePair(combo.resumenDeCartas), true);


    }

    @Test
    public void testEsTwoPair() {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CABALLO));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esTwoPair(combo.resumenDeCartas), false);


    }

    @Test
    public void testEsThreeOfKind() {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_10));
        cartasJugadores.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CABALLO));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_10));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CABALLO));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esThreeOfKind(combo.resumenDeCartas), false);


    }

    @Test
    public void testMejorCombinacion()
    {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CABALLO));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REINA));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

       RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.mejorCombinacion(), RankingDeCombinaciones.Combinaciones.ROYAL_FLUSH);


    }

    @Test
    public void testFourOfKind()
    {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_10));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.DIAMANTES, Carta.RangoEnum.CARTA_10));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.CORAZONES, Carta.RangoEnum.CARTA_10));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esFourOfKind(combo.resumenDeCartas), true);


    }

    @Test
    public void testThreeOfKind()
    {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_10));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.DIAMANTES, Carta.RangoEnum.CARTA_10));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.CORAZONES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esThreeOfKind(combo.resumenDeCartas), true);


    }

    @Test
    public void testFullHouse()
    {
        ArrayList<Carta> cartasJugadoes = new ArrayList<>();
        cartasJugadoes.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_10));
        cartasJugadoes.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.DIAMANTES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.CORAZONES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REY));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadoes, cartasDeLaMesa);

        Assert.assertEquals(combo.esFullHouse(combo.resumenDeCartas), true);
    }

    @Test
    public void testFlush()
    {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_2));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_3));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_4));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.REY));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS)
        		);

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esFlush(combo.resumenDeCartas), true);


    }

    @Test
    public void testStraight()
    {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_2));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_3));
        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_4));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_5));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esStraight(combo.resumenDeCartas), false);
    }

    @Test
    public void testStraightFlush()
    {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES,Carta.RangoEnum.AS));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_3));

        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_2));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_4));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_5));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_5));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esStraightFlush(combo.resumenDeCartas), true);
    }

    @Test
    public void testRoyalFlush2()
    {
        ArrayList<Carta> cartasJugadores = new ArrayList<>();
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES,Carta.RangoEnum.AS));
        cartasJugadores.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_3));

        ArrayList<Carta> cartasDeLaMesa = new ArrayList<>();
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_2));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_4));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_5));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.CARTA_5));
        cartasDeLaMesa.add(new Carta(Carta.PalosEnum.PICAS, Carta.RangoEnum.AS));

        RankingDeCombinaciones combo = new RankingDeCombinaciones(cartasJugadores, cartasDeLaMesa);

        Assert.assertEquals(combo.esStraightFlush(combo.resumenDeCartas), true);
    }

}
