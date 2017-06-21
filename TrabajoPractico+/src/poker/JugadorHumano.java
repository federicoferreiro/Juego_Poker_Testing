package poker;



import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

import poker.JugadorHumano.Decision;



public class JugadorHumano {
    
	private String nombre;
    private ArrayList<Carta> cartas = new ArrayList<Carta>(2);
    private Carta cartaMasAlta = null;
    private ArrayList<Carta> listaDeRankings = null;
    private RankingDeCombinaciones rankingDeComboMaximo = null;
    long plata;
    protected long aumento;
	public long call;
	public long ciega;
	public long apuestaMaximaJugador;

    public enum Decision {
        CALL, RAISE, CHECK, FOLD
        
       
    }

    public JugadorHumano(String nombre, long plata) {
        this.nombre = nombre;
        this.plata = plata;
    }



    public ArrayList<Carta> getListaDeRankings() {
        return listaDeRankings;
    }

    public void setListaDeRankings(ArrayList<Carta> listaDeRankings) {
        this.listaDeRankings = listaDeRankings;
    }



    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Carta... cartas) {
        this.cartas = new ArrayList<>(Arrays.asList(cartas));
    }

    public Carta getCartaMasAlta() {
        return cartaMasAlta;
    }

    public void setCartaMasAlta(Carta cartaMasAlta) {
        this.cartaMasAlta = cartaMasAlta;
    }


    public RankingDeCombinaciones getComboMaximo() {
        return rankingDeComboMaximo;
    }

    public void setMaxCombo(RankingDeCombinaciones comboMaximo) {
        this.rankingDeComboMaximo = comboMaximo;
    }

    public long getPlata() {
        return plata;
    }

    public void setPlata(long plata) {
        this.plata = plata;
    }

    public long sacarPlata(long sum) {
        if (sum > plata)
            sum = plata;
        plata -= sum;
        return sum;
    }

    public void darPlata(long sum) {
        plata += sum;
    }

    public Decision tomarDecision(Juego juego) {
        Scanner sc = new Scanner(System.in);
        Decision d;

        
        
        System.out.println();
        if(!cartas.isEmpty())
        	System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Tus cartas son: "+Arrays.toString(cartas.toArray()));
            System.out.println("Cantidad de dinero: ["+plata+"]");
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            
        if(!juego.cartasDeMesa.isEmpty())
            System.out.println("Las cartas de la Meza son: "+Arrays.toString(juego.cartasDeMesa.toArray()));
        	System.out.println("");
        	System.out.println(nombre + " elegui tu accion a realizar:         ");
       

        ArrayList<Decision> decisiones = new ArrayList<>(Arrays.asList(Decision.values()));
       
        
        if(apuestaMaximaJugador==0){
          	decisiones.remove(Decision.CHECK);
    		  
          }
        if ( apuestaMaximaJugador == juego.apuestaMaximaRonda){
        	decisiones.remove(Decision.CALL);
        }

        if (apuestaMaximaJugador < juego.apuestaMaximaRonda && plata !=0){
        	decisiones.remove(Decision.CHECK);
        }     
        if(juego.apuestaMaximaRonda==0){
        	decisiones.remove(Decision.CALL);
        }
        
            
        if (plata == 0){
            decisiones.remove(Decision.RAISE);
        	decisiones.remove(Decision.FOLD);
        	decisiones.remove(Decision.CALL);
        }
        	
        if (plata < (juego.apuestaMaximaRonda-apuestaMaximaJugador)) {
            decisiones.remove(Decision.CALL);
        }

       
        for (int i = 0; i < decisiones.size(); i++) {
            System.out.println(i + 1 + ") " + decisiones.get(i));
        }
     

        while(true)
        try {
            d = decisiones.get(Integer.parseInt(sc.nextLine()) - 1);
            break;
        }catch (Exception e){
        	System.out.println("POR FAVOR INGRESAR NUMERO DE LA OPCION DESEADA");
            continue;
        }
        if (Decision.RAISE.equals(d)) {
        	String cantidad_aumento;
        	long apuesta = 0;
        	boolean buena_eleccion=false;
        	do{
        	do{

        		System.out.println("Cuanto aumentara?");;
				cantidad_aumento= sc.nextLine();	
				if(cantidad_aumento.length()<=5){
					try{
						apuesta=Integer.valueOf(cantidad_aumento);
					} catch (Exception aum){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO CORRESPONDE, NO INGRESAR ESPACIOS VACIOS. \n POR FAVOR INGRESAR UN VALOR PERMITIDO" );
						cantidad_aumento="aaaaaaaaaaaaaaaaaaa";
					}
				}
				else {
					System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
					System.out.println("LA OPCION INGRESADA NO CORRESPONDE, NO INGRESAR ESPACIOS VACIOS. \n POR FAVOR INGRESAR UN VALOR PERMITIDO \n");
					cantidad_aumento="aaaaaaaaaaaaa";
				}
			} while(cantidad_aumento.length()>=6);
        	

            if (apuesta > 0 && apuesta <= juego.apuestaMaximaRonda && apuesta!=plata){
                System.out.println("DEBE INGRESAR UN MONTO MAYOR A LO QUE SE APOSTO PREVIAMENTE");
            	buena_eleccion=false;
            	}
            	
            if (apuesta > plata){
            	System.out.println("NO PUEDE APOSTAR MAS DINERO DEL QUE POSEE");
            	buena_eleccion=false;
            	}
            
            if (apuesta <= 0){
            	System.out.println("NO PUEDE APOSTAR 0.... NI MONTOS NEGATIVOS");
            	buena_eleccion=false;
            	}
            if(apuesta==plata){
            	buena_eleccion=true;
            	
            	aumento=sacarPlata(apuesta);
            	juego.apuestaMaximaRonda=apuesta + apuestaMaximaJugador;
            
            }
            
            if (apuesta>juego.call && apuesta>0 && apuesta<=plata){
            	buena_eleccion=true;
            	
            	
            	aumento= apuesta-apuestaMaximaJugador;
            	juego.apuestaMaximaRonda=aumento + apuestaMaximaJugador;
       
            
            	
            	
            	
            }
        
        	}while(buena_eleccion==false);
        	
        }
        return d;
    }

    public long getApuestaAumento() {
        return aumento;
    }

    @Override
    public String toString() {
        return nombre;
    }



	public long getApuestaMaximaJugador() {
		return apuestaMaximaJugador;
	}



	public void setApuestaMaximaJugador(long apuestaMaximaJugador) {
		this.apuestaMaximaJugador = 0;
	}
}