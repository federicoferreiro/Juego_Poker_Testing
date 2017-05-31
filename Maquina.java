package Testing;

import java.util.Random;


public class Maquina extends JugadorHumano {
    public int dificultad; 
 // 1 - facil, 2 - medio, 3 - dificil
    
    
    public Maquina(String nombreMaquina) {
        super(nombreMaquina, 1500);
    }

    public Maquina(String nombreMaquina, int dificultad) {
        super(nombreMaquina, 1500);
        this.dificultad = dificultad;
    }
    

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public Decision tomarDecision(Juego juego) {
        Decision decision;
        long apuesta=0;
        
        if (this.dificultad == 2) {

            decision = nivelMedio();
        }
        else if (this.dificultad == 3)
        {
            decision = nivelDificil(juego);
        }
        else
        {
            decision = Decision.values()[new Random().nextInt(Decision.values().length)];
        }
        
        if (Decision.RAISE.equals(decision)) {
        	
			if (getPlata() < juego.apuestaMaximaRonda){
                decision = Decision.CALL;
				
        	}
            else{
            	do{
            	
                apuesta = new Random().nextInt((int) (getPlata() - juego.call)) + juego.call + 1;
       
                
                
            	}while(apuesta==0 && apuesta< juego.apuestaMaximaRonda);
            	
            	
            	}
        	
        
        	
        	
        	aumento= apuesta-apuestaMaximaJugador;
        
        	apuestaMaximaJugador=apuesta;
        
        	juego.apuestaMaximaRonda=apuesta;
			
			
			
        }
        return decision;
    }


    public Decision nivelMedio() {

        return Decision.values()[new Random().nextInt(Decision.values().length - 1)];
    }

    public Decision nivelDificil(Juego juego) {
        InteligenciaDecisionMaquina maq = new InteligenciaDecisionMaquina(juego, this);

        return maq.getDecision();

    }

}