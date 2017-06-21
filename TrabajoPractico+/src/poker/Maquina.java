package poker;

import java.util.Random;


public class Maquina extends JugadorHumano {
    public int dificultad; 
 // 1 - facil, 2 - medio, 3 - dificil
    public long apuestaMaximaJugador=0;
    
    public Maquina(String nombreMaquina) {
        super(nombreMaquina, 1000);
    }

    public Maquina(String nombreMaquina, int dificultad) {
        super(nombreMaquina, 1000);
        this.dificultad = dificultad;
    }
    

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public Decision tomarDecision(Juego juego) {
        Decision decision;
        long apuesta = 0;

        
        if (this.dificultad == 2) {

            decision = nivelMedio();
        }
        if (this.dificultad == 3)
        {
            decision = nivelDificil(juego);
        }
        else
        {
            decision = Decision.values()[new Random().nextInt(Decision.values().length)];
            
        }
        
        
        if(apuestaMaximaJugador==0 ){
          	decision = Decision.CALL;
    		  
          }
        
        
        if (Decision.CHECK.equals(decision)){
        	
        	if (apuestaMaximaJugador == juego.apuestaMaximaRonda){
        		decision = Decision.CHECK;
        	}
        	else if(apuestaMaximaJugador < juego.apuestaMaximaRonda){
        		decision = Decision.values()[new Random().nextInt(Decision.values().length)];
        	}
        	else{
        		decision = Decision.values()[new Random().nextInt(Decision.values().length)];
        	}
        }
        
        
        
        if (Decision.CALL.equals(decision)){
        	
        	if((apuestaMaximaJugador - juego.apuestaMaximaRonda) == 0){
        		decision=Decision.CHECK;
        	}
        	else if (apuestaMaximaJugador < juego.apuestaMaximaRonda){
        		
        		decision = Decision.CALL;
        	}
        	
        	
        	else if (plata == 0){
        		decision = Decision.CHECK;
        	}
        	else if((juego.apuestaMaximaRonda - apuestaMaximaJugador)<0){
        		decision = Decision.values()[new Random().nextInt(Decision.values().length)];
        	}
        	else{
        		decision = Decision.values()[new Random().nextInt(Decision.values().length)];
        	}
        	
        }
        
        
    
        if (Decision.RAISE.equals(decision)) {
        	
        	
        	
        	if (getPlata() < juego.apuestaMaximaRonda){
                decision = Decision.CALL;
				
        	}
        	else if (plata == 0){
        		decision = Decision.CHECK;
        	}
        	else{
        	  
        		
   
            	do{
            	
                apuesta = new Random().nextInt( (int) (getPlata() - juego.call)) + juego.call + 1;
       
                
                
            	}while(apuesta<= juego.apuestaMaximaRonda);

        	}
        
        	
        	
        	aumento= apuesta-apuestaMaximaJugador;
        	juego.apuestaMaximaRonda= aumento + apuestaMaximaJugador;
			
			
			
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