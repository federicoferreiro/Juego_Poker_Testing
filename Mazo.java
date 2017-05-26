package Testing;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;


public class Mazo {
    public ArrayList<Carta> carta;
    public Stack<Carta> PilaDeCartas;

    public Mazo()
    {
        carta = new ArrayList<>();
        PilaDeCartas = new Stack<>();

        for(Carta.RangoEnum rango : Carta.RangoEnum.values()) {
            for (Carta.PalosEnum palo : Carta.PalosEnum.values()) {
                carta.add(new Carta(palo, rango));
            }
        }
    }

    public void mezclarMazo()
    {
        long tardanza = System.nanoTime();
        Collections.shuffle(carta, new Random(tardanza));
        for(Carta c : carta)
        {
            PilaDeCartas.add(c);
        }
    }

    public Carta tirarCarta()
    {
        return PilaDeCartas.pop();
    }

    public ArrayList<Carta> getCartas()
    {
        return carta;
    }
}