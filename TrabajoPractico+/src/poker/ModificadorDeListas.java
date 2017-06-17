package poker;


import java.util.List;



/**
 *Modifica el objeto Lista que le pases
 */


public class ModificadorDeListas {

    public static int nextId(List<? extends Object> list, int index){
        return (index + 1)%list.size();
    }


}