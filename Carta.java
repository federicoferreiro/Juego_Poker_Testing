package Testing;



public class Carta {

    private PalosEnum palo;
    private RangoEnum rango;

    public Carta() {

    }

    public Carta(PalosEnum palo, RangoEnum rango) {


        this.palo = palo;
        this.rango = rango;
    }

    public PalosEnum getPalo() {
        return palo;
    }

    public RangoEnum getRango() {
        return rango;
    }

    public enum RangoEnum {
        CARTA_2,
        CARTA_3,
        CARTA_4,
        CARTA_5,
        CARTA_6,
        CARTA_7,
        CARTA_8,
        CARTA_9,
        CARTA_10,
        CABALLO,
        REINA,
        REY,
        AS
    }

    public enum PalosEnum {
        PICAS,
        DIAMANTES,
        CORAZONES,
        TREBOLES
    }

    @Override
    public String toString() {
        return rango+" de "+palo;
    }
}