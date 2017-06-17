package poker;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class TestMaquina {

	
	    @Test
	    public void testSetDificultad() {
	        Maquina maquina1 = new Maquina("Bart", 1);
	        Maquina maquina2 = new Maquina("Homer", 2);
	        Maquina maquina3 = new Maquina("Mardge", 3);
	        Maquina maquina4 = new Maquina("Mard", 0);

	        Assert.assertEquals(maquina1.dificultad, 1);
	        Assert.assertEquals(maquina2.dificultad, 2);
	        Assert.assertEquals(maquina3.dificultad, 3);
	        Assert.assertNotEquals(maquina4.dificultad, maquina4.dificultad != 1 && maquina4.dificultad != 2 && maquina4.dificultad != 3);

	    }

	    @Test
	    public void testTomarDecision() {
	        Maquina maquina1 = new Maquina("Bart", 2);

	        Juego juego = new Juego(50000, new Maquina("Tamara"), new JugadorHumano("John", 646866556656l), new JugadorHumano("Albert", 53), new JugadorHumano("Zak", 79465));




	        Assert.assertNotEquals(maquina1.nivelMedio(), JugadorHumano.Decision.FOLD);

	    }
	    
	    @Test
	    public void testSetDificultadTodasFalsas() {
	        Maquina maquina1 = new Maquina("Bart", 6);
	        Maquina maquina2 = new Maquina("Homer", 10);
	        Maquina maquina3 = new Maquina("Mardge", -1);
	        Maquina maquina4 = new Maquina("Mard", 0);

	        Assert.assertNotEquals(maquina1.dificultad, maquina1.dificultad != 1 && maquina1.dificultad != 2 && maquina1.dificultad != 3);
	        Assert.assertNotEquals(maquina2.dificultad, maquina2.dificultad != 1 && maquina2.dificultad != 2 && maquina2.dificultad != 3);
	        Assert.assertNotEquals(maquina3.dificultad, maquina3.dificultad != 1 && maquina3.dificultad != 2 && maquina3.dificultad != 3);
	        Assert.assertNotEquals(maquina4.dificultad, maquina4.dificultad != 1 && maquina4.dificultad != 2 && maquina4.dificultad != 3);

	    }
	}

