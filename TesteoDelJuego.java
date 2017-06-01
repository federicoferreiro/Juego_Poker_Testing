package Testing;


import org.junit.Assert;
import org.junit.Test;



public class TesteoDelJuego {


    @Test
    public void testInicilizacion()
    {
        Juego juego = new Juego(50000, new Maquina("Tamara"), new JugadorHumano("John", 646866556656l), new JugadorHumano("Albert", 53), new JugadorHumano("Zak", 79465));
        juego.iniciarJuego();

        Assert.assertNotEquals(juego.getJugadores(), null);
        Assert.assertNotEquals(juego.getJugadorComun(), null);

    }

}
