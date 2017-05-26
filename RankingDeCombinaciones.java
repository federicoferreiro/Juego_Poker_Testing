package Testing;

import java.util.*;

public class RankingDeCombinaciones {

    public ArrayList<Carta> resumenDeCartas;

    public enum Combinaciones {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH
    }

    public RankingDeCombinaciones(ArrayList<Carta> cartasDelJugador, ArrayList<Carta> cartasDeLaMesa) {
        resumenDeCartas = new ArrayList<>();
        resumenDeCartas.addAll(cartasDelJugador);
        resumenDeCartas.addAll(cartasDeLaMesa);

       

        resumenDeCartas.sort(new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                return -o1.getRango().compareTo(o2.getRango());
            }
        });

        resumenDeCartas.sort(new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.getRango().equals(o2.getRango()) && o1.getPalo().compareTo(o2.getPalo()) < 0) {
                    return -1;
                } else if (o1.getRango().equals(o2.getRango()) && o1.getPalo().compareTo(o2.getPalo()) > 0) {
                    return 1;
                } else return 0;
            }
        });
    }

    public Combinaciones mejorCombinacion() {

        if (esRoyalFlush(resumenDeCartas)) {
            return Combinaciones.ROYAL_FLUSH;
        } else if (esStraightFlush(resumenDeCartas)) {
            return Combinaciones.STRAIGHT_FLUSH;
        } else if (esFourOfKind(resumenDeCartas)) {
            return Combinaciones.FOUR_OF_A_KIND;
        } else if (esFullHouse(resumenDeCartas)) {
            return Combinaciones.FULL_HOUSE;
        } else if (esFlush(resumenDeCartas)) {
            return Combinaciones.FLUSH;
        } else if (esStraight(resumenDeCartas)) {
            return Combinaciones.STRAIGHT;
        } else if (esThreeOfKind(resumenDeCartas)) {
            return Combinaciones.THREE_OF_A_KIND;
        } else if (esTwoPair(resumenDeCartas)) {
            return Combinaciones.TWO_PAIR;
        } else if (esOnePair(resumenDeCartas)) {
            return Combinaciones.ONE_PAIR;
        } else
            return Combinaciones.HIGH_CARD;
    }

    public boolean esRoyalFlush(ArrayList<Carta> resumenDeCartas) {

        boolean t = true;
        for (int i = 1; i < 5; ++i) {
            if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                t = false;
            }
            if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                t = false;
            }
        }
        if (!resumenDeCartas.get(0).getRango().equals(Carta.RangoEnum.AS)) {
            t = false;
        }
        if (!t && resumenDeCartas.size() == 6) {
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                    t = false;
                }
                if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                    t = false;
                }
            }
            if (!resumenDeCartas.get(1).getRango().equals(Carta.RangoEnum.AS)) {
                t = false;
            }
        }
        if (!t && resumenDeCartas.size() == 7) {
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                    t = false;
                }
                if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                    t = false;
                }
            }
            if (!resumenDeCartas.get(2).getRango().equals(Carta.RangoEnum.AS)) {
                t = false;
            }
        }
        return t;
    }

    public boolean esStraightFlush(ArrayList<Carta> resumenDeCartas) {

        boolean t = true;
        for (int i = 1; i < 5; ++i) {
            if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                t = false;
            }
            if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                t = false;
            }
        }
        if (!t && resumenDeCartas.size() == 6) {
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                    t = false;
                }
                if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                    t = false;
                }
            }
        }
        if (!t && resumenDeCartas.size() == 7) {
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                    t = false;
                }
                if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                    t = false;
                }
            }
        }
        if (t) {
            return true;
        }
        else {
            int cantidadAses = 0;
            for (Carta c : resumenDeCartas) {
                if (c.getRango().equals(Carta.RangoEnum.AS)) {
                    cantidadAses++;
                }
            }
            if (cantidadAses > 3 || cantidadAses <= 0) {
                return false;
            }
            t = true;
            for (int i = cantidadAses + 1; i < 5; ++i) {
                if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                    t = false;
                }
                if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                    t = false;
                }
            }
            if (!resumenDeCartas.get(cantidadAses).getRango().equals(Carta.RangoEnum.CARTA_5)) {
                t = false;
            }
            t = false;
            for (int i = 0; i < cantidadAses; ++i) {
                if (resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(4).getPalo())) {
                    t = true;
                }
            }
            if (!t && resumenDeCartas.size() == 6) {
                t = true;
                for (int i = cantidadAses + 2; i < 6; ++i) {
                    if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                        t = false;
                    }
                    if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                        t = false;
                    }
                }
                if (!resumenDeCartas.get(cantidadAses + 1).getRango().equals(Carta.RangoEnum.CARTA_5)) {
                    t = false;
                }
                t = false;
                for (int i = 1; i < cantidadAses; ++i) {
                    if (resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(4).getPalo())) {
                        t = true;
                    }
                }
            }
            if (!t && resumenDeCartas.size() == 7) {
                t = true;
                for (int i = cantidadAses + 3; i < 7; ++i) {
                    if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                        t = false;
                    }
                    if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                        t = false;
                    }
                }
                if (!resumenDeCartas.get(cantidadAses + 2).getRango().equals(Carta.RangoEnum.CARTA_5)) {
                    t = false;
                }
                t = false;
                for (int i = 2; i < cantidadAses; ++i) {
                    if (resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(4).getPalo())) {
                        t = true;
                    }
                }
            }
        }
        return t;
    }

    public boolean esFourOfKind(ArrayList<Carta> resumenDeCartas) {
        int acumulador = 0;
        Carta.RangoEnum rango = resumenDeCartas.get(3).getRango();
        for (Carta carta : resumenDeCartas) {
            if (carta.getRango().equals(rango)) {
                acumulador++;
            }
        }
        if (acumulador >= 4) {
            return true;
        }
        return false;
    }

    public boolean esFullHouse(ArrayList<Carta> resumenDeCartas) {
        boolean acumulador = false;
        int carta1 = 0, carta2 = 0, carta3 = 0;
        for (int i = 0; i < resumenDeCartas.size(); ++i) {
            for (int j = 0; j < resumenDeCartas.size(); ++j) {
                for (int k = 0; k < resumenDeCartas.size(); ++k) {
                    if (i != j && j != k && i != k &&
                            resumenDeCartas.get(i).getRango().equals(resumenDeCartas.get(j).getRango()) &&
                            resumenDeCartas.get(j).getRango().equals(resumenDeCartas.get(k).getRango())) {
                        acumulador = true;
                        carta1 = i;
                        carta2 = j;
                        carta3 = k;
                    }
                }
            }
        }
        if (acumulador) {
            acumulador = false;
            for (int i = 0; i < resumenDeCartas.size(); ++i) {
                for (int j = 0; j < resumenDeCartas.size(); ++j) {
                    if (i != j && carta1 != i && carta2 != j && carta1 != j && carta2 != i && carta3 != i && carta3 != j &&
                            resumenDeCartas.get(i).getRango().equals(resumenDeCartas.get(j).getRango())) {
                        acumulador = true;
                    }
                }
            }
            return acumulador;
        } else return false;
    }

    public boolean esFlush(ArrayList<Carta> resumenDeCartas) {
        boolean t = true;
        for (int i = 1; i < 5; ++i) {
            if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                t = false;
            }
        }
        if (!t && resumenDeCartas.size() == 6) {
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                    t = false;
                }
            }
        }
        if (!t && resumenDeCartas.size() == 7) {
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (!resumenDeCartas.get(i).getPalo().equals(resumenDeCartas.get(i - 1).getPalo())) {
                    t = false;
                }
            }
        }
        return t;
    }

    public boolean esStraight(ArrayList<Carta> resumenDeCartas) {
        boolean t = true;
        for (int i = 1; i < 5; ++i) {
            if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                t = false;
            }
        }
        if (!t && resumenDeCartas.size() == 6) {
            t = true;
            for (int i = 2; i < 6; ++i) {
                if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                    t = false;
                }
            }
        }
        if (!t && resumenDeCartas.size() == 7) {
            t = true;
            for (int i = 3; i < 7; ++i) {
                if (resumenDeCartas.get(i).getRango().ordinal() + 1 != resumenDeCartas.get(i - 1).getRango().ordinal()) {
                    t = false;
                }
            }
        }
        if (t) {
            return true;
        } else {
            if (resumenDeCartas.contains(Carta.RangoEnum.AS) && resumenDeCartas.contains(Carta.RangoEnum.CARTA_2)
                    && resumenDeCartas.contains(Carta.RangoEnum.CARTA_3) && resumenDeCartas.contains(Carta.RangoEnum.CARTA_4)
                    && resumenDeCartas.contains(Carta.RangoEnum.CARTA_5)) {
                t = true;
            }
        }
        return t;
    }

    public boolean esThreeOfKind(ArrayList<Carta> resumenDeCartas) {
        int acumulador = 0;
        Carta.RangoEnum rango = resumenDeCartas.get(2).getRango();
        for (Carta carta : resumenDeCartas) {
            if (carta.getRango().equals(rango)) {
                acumulador++;
            }
        }
        if (acumulador >= 3) {
            return true;
        }

        acumulador = 0;
        rango = resumenDeCartas.get(4).getRango();
        for (Carta card : resumenDeCartas) {
            if (card.getRango().equals(rango)) {
                acumulador++;
            }
        }
        if (acumulador >= 3) {
            return true;
        }

        return false;
    }

    public boolean esTwoPair(ArrayList<Carta> resumenDeCartas) {
        boolean acumulador = false;
        int carta1 = 0, carta2 = 0;
        for (int i = 0; i < resumenDeCartas.size(); ++i) {
            for (int j = 0; j < resumenDeCartas.size(); ++j) {
                if (i != j && resumenDeCartas.get(i).getRango().equals(resumenDeCartas.get(j).getRango())) {
                    acumulador = true;
                    carta1 = i;
                    carta2 = j;
                }
            }
        }
        if (acumulador) {
            acumulador = false;
            for (int i = 0; i < resumenDeCartas.size(); ++i) {
                for (int j = 0; j < resumenDeCartas.size(); ++j) {
                    if (i != j && carta1 != i && carta2 != j && carta1 != j && carta2 != i && resumenDeCartas.get(i).getRango().equals(resumenDeCartas.get(j).getRango())) {
                        acumulador = true;
                    }
                }
            }
            return acumulador;
        } else return false;
    }

    public boolean esOnePair(ArrayList<Carta> resumenDeCartas) {
        boolean acumulador = false;
        for (int i = 0; i < resumenDeCartas.size(); ++i) {
            for (int j = 0; j < resumenDeCartas.size(); ++j) {
                if (i != j && resumenDeCartas.get(i).getRango().equals(resumenDeCartas.get(j).getRango())) {
                    acumulador = true;
                }
            }
        }
        return acumulador;
    }
}