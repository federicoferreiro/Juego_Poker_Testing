package poker;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

public class TestMazo {

    @Test
    public void testShuffler(){
        StringBuffer sb = new StringBuffer();
        System.setOut(new PrintStream(System.out) {
            public void println(String s) {
                sb.append(s);
                super.println(s);
            }
        });
        Mazo mazo = new Mazo();
        ArrayList<Carta> era = mazo.getCartas();
        mazo.mezclarMazo();
        ArrayList<Carta> seVolvio = mazo.getCartas();



        Assert.assertEquals(era, seVolvio);


    }

    @Test
    public void testTamaño(){

        Mazo mazo = new Mazo();
        ArrayList<Carta> era = mazo.getCartas();
        mazo.mezclarMazo();
        ArrayList<Carta> seVolvio= mazo.getCartas();



        Assert.assertEquals(era.size(), seVolvio.size());


    }
}
