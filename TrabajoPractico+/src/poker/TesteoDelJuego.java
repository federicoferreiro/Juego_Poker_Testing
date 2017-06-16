package Testing;


import org.junit.Assert;
import org.junit.Test;



public class TesteoDelJuego {

	
    @Test
    public void testInicilizacionNoJugadoresMinimos()
    {
        Juego juego = new Juego(50000, new Maquina("Tamara"));
        juego.iniciarJuego();

        
        
        Assert.assertNotEquals(juego.getJugadores(), null);
     

    }

    @Test
    public void testInicilizacion()
    {
        Juego juego = new Juego(50000, new Maquina("Tamara"), new JugadorHumano("John", 646866556656l), new JugadorHumano("Albert", 53), new JugadorHumano("Zak", 79465));
        juego.iniciarJuego();

        Assert.assertNotEquals(juego.getJugadores(), null);
        Assert.assertNotEquals(juego.getJugadorComun(), null);

    }
    
    @Test
    public void testInicilizacionNoJugadoresMaximosPermitidos()
    {
        Juego juego = new Juego(50000, new Maquina("Tamara"),new Maquina("Tamara"),new Maquina("Tamara"),new Maquina("Tamara"),new Maquina("Tamara"),new Maquina("Tamara"),new Maquina("Tamara"),new Maquina("Tamara"),new Maquina("Tamara"));
        juego.iniciarJuego();

        
        
        Assert.assertNotEquals(juego.getJugadores(), null);
     

    }
    


}
