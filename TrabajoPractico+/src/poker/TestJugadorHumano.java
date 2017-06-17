package poker;


import org.junit.Assert;
import org.junit.Test;





public class TestJugadorHumano {

	




    @Test
    public void testSetteadorDePlata(){


        Juego juego = new Juego(50000, new JugadorHumano("Tamara",500), new JugadorHumano("John",900), new JugadorHumano("Albert",500), new JugadorHumano("Zak",800));
        JugadorHumano jugador = new JugadorHumano("Fede",0);

        jugador.setPlata(10000);


        
        Assert.assertEquals(jugador.getPlata(), 10000);



    }

    @Test
    public void testSetteadorDeCartas(){



        JugadorHumano jugador = new JugadorHumano("Fede",1000);
        jugador.setCartas(new Carta[]{new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_10), new Carta(Carta.PalosEnum.TREBOLES, Carta.RangoEnum.CARTA_9)});



        Assert.assertEquals(jugador.getCartas().size(), 2);



    }
}
