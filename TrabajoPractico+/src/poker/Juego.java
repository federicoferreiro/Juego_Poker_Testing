package poker;

import java.util.*;


import poker.RankingDeCombinaciones.Combinaciones;


public class Juego {
	final long ciega;
	public Mazo mazo;
	public LinkedList<JugadorHumano> jugadores;
	public LinkedList<JugadorHumano> jugadoresComunes;
	public Iterator<JugadorHumano> iteradorDeJugadoresComunes;
	public ArrayList<Carta> cartasDeMesa;
	int buttonId;
	long call;
	int fondo;
	public long apuestaMaximaRonda;

	ArrayList<JugadorHumano> ultimosGanadores;
	EtapasDeJuego etapaActual;

	public enum EtapasDeJuego {
		INICIO, Preflop, Flop, Turn, River, FIN
	}

	public Juego(int ciega, JugadorHumano... jugadores) {
		this.ciega = ciega;
		this.jugadores = new LinkedList<>();
		for (JugadorHumano p : jugadores)
			this.jugadores.add(p);
		etapaActual = EtapasDeJuego.INICIO;
		buttonId = -1;
	}

	public void iniciarJuego() {
		if (buttonId == jugadores.size() - 1) {
			buttonId = 0;
		} else
			buttonId++;
		JugadorHumano button = jugadores.get(buttonId);
		mazo = new Mazo();
		mazo.mezclarMazo();
		call = this.ciega;
		fondo = 0;
		apuestaMaximaRonda=0;
		jugadores.removeIf(jugador -> {
			int index = jugadores.indexOf(jugador);
			if (jugador.getPlata() == 0) {
				if (buttonId == index) {
					buttonId = ModificadorDeListas.nextId(jugadores, buttonId);
				}
				return true;
			}
			if (buttonId == index) {
				return false;
			}
			if (ModificadorDeListas.nextId(jugadores, buttonId) == index) {
				return jugador.getPlata() < ciega / 2;
			}
			if (ModificadorDeListas.nextId(jugadores, buttonId + 1) == index) {
				return jugador.getPlata() < ciega;
			}
			return jugador.getPlata() < ciega;

		});
		if (jugadores.size() < 2) {
			etapaActual = EtapasDeJuego.FIN;
			return;
		}
		buttonId = jugadores.indexOf(button);
		jugadoresComunes = new LinkedList<>(jugadores);
		for (int i = 0; i < buttonId; i++) {
			jugadoresComunes.add(jugadoresComunes.removeFirst());
		}


		for (JugadorHumano p : jugadores){
			p.setApuestaMaximaJugador(0);
			System.out.println(p + " [FONDO: " + p.getPlata() + "]");
		System.out.println();
		}

		cartasDeMesa = new ArrayList<>();
		etapaActual = EtapasDeJuego.Preflop;
	}

	public EtapasDeJuego incioSiguienteEtapa() {
		switch (etapaActual) {
		case INICIO:
			iniciarJuego();
			break;
		case Preflop:
			preflop();
			break;
		case Flop:
			flop();
			break;
		case Turn:
			turn();
			break;
		case River:
			river();
			break;
		case FIN:
			definirGanador();
			break;
		default:
			break;
		}
		return etapaActual;
	}
	
	
	


	public void preflop() {
		
		
		apuestaMaximaRonda=10;


		
		

		System.out.println(jugadoresComunes.getFirst() + " es dealer");


		jugadoresComunes.add(jugadoresComunes.removeFirst());
		fondo += jugadoresComunes.getFirst().sacarPlata(ciega / 2);
		jugadoresComunes.getFirst().setApuestaMaximaJugador(5);





		System.out.println(jugadoresComunes.getFirst() + " PONE CIEGA CHICA " + ciega / 2);


		jugadoresComunes.add(jugadoresComunes.removeFirst());
		fondo += jugadoresComunes.getFirst().sacarPlata(ciega);
		jugadoresComunes.getFirst().setApuestaMaximaJugador(10);
	


		System.out.println(jugadoresComunes.getFirst() + " PONE CIEGA GRANDE " + ciega);


		for (JugadorHumano jugador : jugadoresComunes) {
		
				
			jugador.aumento=0;
			jugador.setCartas(mazo.tirarCarta(), mazo.tirarCarta());
		}
		jugadoresComunes.add(jugadoresComunes.removeFirst());
		iteradorDeJugadoresComunes = jugadoresComunes.iterator();
		while (iteradorDeJugadoresComunes.hasNext()) {
			decisionesDeJuego(iteradorDeJugadoresComunes.next());
			if (jugadoresComunes.size() < 2) {
				etapaActual = EtapasDeJuego.FIN;
				return;
			}
		}
		iteradorDeJugadoresComunes = null;
		for (JugadorHumano p : jugadores)
			System.out.println(p + " [FONDO: " + p.getPlata() + "]");
		System.out.println();
		etapaActual = EtapasDeJuego.Flop;
	}

	public void flop() {
		cartasDeMesa.add(mazo.tirarCarta());
		cartasDeMesa.add(mazo.tirarCarta());
		cartasDeMesa.add(mazo.tirarCarta());
		for (int i = buttonId + 1; i < (jugadores.size() + buttonId - 1) % jugadores.size(); i = (i + 1) % jugadores.size())
			if (jugadoresComunes.contains(jugadores.get(i))) {
				while (!jugadoresComunes.getFirst().equals(jugadores.get(i))) {
					jugadoresComunes.add(jugadoresComunes.removeFirst());
				}
			}

		jugadoresComunes.add(jugadoresComunes.removeFirst());
		iteradorDeJugadoresComunes = jugadoresComunes.iterator();
		while (iteradorDeJugadoresComunes.hasNext())

		{
			decisionesDeJuego(iteradorDeJugadoresComunes.next());
			if (jugadoresComunes.size() < 2) {
				etapaActual = EtapasDeJuego.FIN;
				return;
			}
		}

		iteradorDeJugadoresComunes = null;
		for (JugadorHumano p : jugadores)
			System.out.println(p + " [FONDO: " + p.getPlata() + "]");
		System.out.println();
		etapaActual = EtapasDeJuego.Turn;
	}

	public void turn() {
		cartasDeMesa.add(mazo.tirarCarta());
		iteradorDeJugadoresComunes = jugadoresComunes.iterator();
		while (iteradorDeJugadoresComunes.hasNext()) {
			decisionesDeJuego(iteradorDeJugadoresComunes.next());
			if (jugadoresComunes.size() < 2) {
				etapaActual = EtapasDeJuego.FIN;
				return;
			}
		}
		iteradorDeJugadoresComunes = null;
		for (JugadorHumano p : jugadores)
			System.out.println(p + " [FONDO: " + p.getPlata() + "]");
		System.out.println();
		etapaActual = EtapasDeJuego.River;
	}

	public void river() {
		cartasDeMesa.add(mazo.tirarCarta());
		iteradorDeJugadoresComunes = jugadoresComunes.iterator();
		while (iteradorDeJugadoresComunes.hasNext()) {
			decisionesDeJuego(iteradorDeJugadoresComunes.next());
			if (jugadoresComunes.size() < 2) {
				etapaActual = EtapasDeJuego.FIN;
				return;
			}
		}
		iteradorDeJugadoresComunes = null;
		for (JugadorHumano p : jugadores)
			System.out.println(p + " [FONDO: " + p.getPlata() + "]");
		System.out.println();
		etapaActual = EtapasDeJuego.FIN;
	}

	public void decisionesDeJuego(JugadorHumano jugador) {
	if (iteradorDeJugadoresComunes == null)
			throw new NullPointerException();
		switch (jugador.tomarDecision(this)) {
		case FOLD:

			System.out.println(jugador + " ABANDONA LA MANO");


			iteradorDeJugadoresComunes.remove();
			if (jugadoresComunes.size() < 2) {
				etapaActual = EtapasDeJuego.FIN;
				return;
			}
			break;
		case CALL:

			if(jugador.plata<= (apuestaMaximaRonda - jugador.apuestaMaximaJugador)){
				call= jugador.plata;
				fondo+=jugador.sacarPlata(call);
				
				
				System.out.println(jugador + " HACE ALL-IN COLOCANDO"+" " + call);
				System.out.println("La apuesta Maxima es de"+" "+apuestaMaximaRonda);
				System.out.println("El pozo total es de $" + fondo);
				
				
				jugador.apuestaMaximaJugador=apuestaMaximaRonda;
			
			}
		
			else{
			
			call=apuestaMaximaRonda-jugador.apuestaMaximaJugador;
			fondo+=jugador.sacarPlata(call);
			
			
	
			System.out.println(jugador + " EMPATA LA APUESTA DE "+" "+ apuestaMaximaRonda+" " + "COLOCANDO"+" " + call);
			System.out.println("El pozo total es de $" + fondo);

		
			jugador.apuestaMaximaJugador=apuestaMaximaRonda;
			   
			}
			break;
		case RAISE:
			
					if(jugador.plata<=jugador.aumento){
						call=jugador.aumento;
						fondo+=jugador.aumento;
						
						
						System.out.println(jugador + " HACE ALL-IN COLOCANDO"+" " + call + " " + "PONIENDO EL TOTAL A" + " " + apuestaMaximaRonda );
						System.out.println("El pozo total es de $" + fondo);
						
						
						jugador.apuestaMaximaJugador=apuestaMaximaRonda;
					
					}
					else{
			call = jugador.aumento;
			fondo+=jugador.sacarPlata(call);



			System.out.println(jugador + " AUMENTA LA APUESTA POR $" + call + "SUBIENDO EL TOTAL A" + apuestaMaximaRonda);
			System.out.println("El pozo total es de $" + fondo);
			
			jugador.apuestaMaximaJugador=apuestaMaximaRonda;
					}

			break;

		case CHECK:

			System.out.println(jugador + " PASA");
			etapaActual=EtapasDeJuego.Turn;

			break;
		default:
			System.out.println("NO HACES NADA........ " + jugador);
		}
	}

	public boolean definirGanador() {
		if (jugadoresComunes.size() < 2) {

			System.out.println(jugadoresComunes.get(0).toString() + " es el ganador!");

			jugadoresComunes.get(0).darPlata(fondo);
		} else {
			HashMap<JugadorHumano, Combinaciones> jug1Comb = new HashMap<>();
			for (JugadorHumano p : jugadoresComunes) {
				jug1Comb.put(p, new RankingDeCombinaciones(new ArrayList<Carta>(p.getCartas()), cartasDeMesa).mejorCombinacion());
			}


			for (JugadorHumano hum : jugadoresComunes) {
				System.out.print(hum.toString() + " : " + hum.getCartas() + " , ");
				System.out.println(cartasDeMesa.toString());
			}


			Combinaciones mejorComb = Collections.max(jug1Comb.entrySet(), (o1, o2) -> o1.getValue().compareTo(o2.getValue())).getValue();
			ultimosGanadores = new ArrayList<>();
			for (Map.Entry<JugadorHumano, Combinaciones> ingresar : jug1Comb.entrySet()) {
				if (mejorComb.equals(ingresar.getValue())) {
					ultimosGanadores.add(ingresar.getKey());
				}
			}


			System.out.println(mejorComb);
			System.out.print(ultimosGanadores.get(0).toString() + " [" + jug1Comb.get(ultimosGanadores.get(0)) + "]");


			ultimosGanadores.get(0).darPlata(fondo / ultimosGanadores.size());
			for (int i = 1; i < ultimosGanadores.size(); i++) {

				System.out.print(", " + ultimosGanadores.get(i).toString() + " [" + jug1Comb.get(ultimosGanadores.get(i)) + "]");

				ultimosGanadores.get(i).darPlata(fondo / ultimosGanadores.size());
			}

			if (ultimosGanadores.size() == 1)
				System.out.println(" es el ganador!");
			else
				System.out.println(" son los ganadores!");

		}

		System.out.println("El monto total que se lleva el ganador es $" + fondo );
		return true;
	
	}

	public LinkedList<JugadorHumano> getJugadoresComunes() {
		return jugadoresComunes;
	}

	public LinkedList<JugadorHumano> getJugadores() {
		return jugadores;
	}

	public JugadorHumano getJugadorComun() {
		return jugadoresComunes.getFirst();
	}

	public long getApuestaMaximaRonda() {
		return apuestaMaximaRonda;
	}

	public void setApuestaMaximaRonda(long apuestaMaximaRonda) {
		this.apuestaMaximaRonda = apuestaMaximaRonda;
	}


}