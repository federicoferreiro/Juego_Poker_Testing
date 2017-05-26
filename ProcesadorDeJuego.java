package Testing;

import java.util.Scanner;

public class ProcesadorDeJuego {
	public static void main(String[] args) {

		Integer jugadores=1, dificultad=0,opcion=0;
		String jugadores_cantidad, nivel_dificultad,opcion_eleguida;
		boolean respuesta=true, difi=true;

		Scanner escaner = new Scanner(System.in);

		
		do{
			
		do{
			do{

				System.out.println("Cuantos jugadores seran? (minimo 2 / maximo 8)");
				jugadores_cantidad= escaner.nextLine();	
				if(jugadores_cantidad.length()<=1){
					try{
						jugadores=Integer.valueOf(jugadores_cantidad);
					} catch (Exception a){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO CORRESPONDE, NO INGRESAR ESPACIOS VACIOS, NI LETRAS NI CARACTERES. ELEGUIR NUMERO ENTRE 2-8. \n");
						jugadores_cantidad="aaaaaaaaaaaaaaaaaaa";
					}
				}
				else {
					System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
					System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR NUMERO ENTRE 2-8. \n");
					jugadores_cantidad="aaaaaaaaaaaaa";
				}
			} while(jugadores_cantidad.length()>2);

			if (jugadores<2 || jugadores>8){
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
				System.out.println("LA OPCION INGRESADA ESTA FUERA DE LOS LIMITES PERMITIDOS. ELEGUIR NUMERO ENTRE 2-8 \n");
				respuesta=true;
			}

			if (jugadores==8){
				respuesta=false;

				do{
					do{

						System.out.println("Que nivel de dificultad usara? (1-2-3)");
						nivel_dificultad= escaner.nextLine();
						if(nivel_dificultad.length()<=1){
							try{
								dificultad=Integer.valueOf(nivel_dificultad);
							} catch (Exception b){
								System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
								System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
								nivel_dificultad="aaaaaaaaaaaaaaaaaaa";
							}
						}
						else {
							System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
							System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
							nivel_dificultad="aaaaaaaaaaaaa";
						}
					} while(nivel_dificultad.length()>2);

					if (dificultad<1 || dificultad>3){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO ESTA ENTRE LOS NIVELES EXISTENTES. ELEGUIR ENTRE NUMEROS 1-2-3 \n");
						difi=true;
					}

					if(dificultad==3){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 500), new Maquina("John", 3), new Maquina("Zion", 3), new Maquina("Carbon", 3),new Maquina("Elena", 3),new Maquina("Matt", 3),new Maquina("Peter", 3),new Maquina("Brad", 3));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==2){
						difi=false;				
						Juego juego = new Juego(10, new JugadorHumano("User", 1000), new Maquina("John", 2), new Maquina("Zion", 2), new Maquina("Carbon", 2),new Maquina("Elena", 2),new Maquina("Matt", 2),new Maquina("Peter", 2),new Maquina("Brad", 2));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==1){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1500), new Maquina("John", 1), new Maquina("Zion", 1), new Maquina("Carbon", 1),new Maquina("Elena", 1),new Maquina("Matt", 1),new Maquina("Peter", 1),new Maquina("Brad", 1));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
				}while(difi==true);
			}
			if (jugadores==7){
				respuesta=false;
				do{
					do{

						System.out.println("Que nivel de dificultad usara? (1-2-3)");
						nivel_dificultad= escaner.nextLine();
						if(nivel_dificultad.length()<=1){
							try{
								dificultad=Integer.valueOf(nivel_dificultad);
							} catch (Exception b){
								System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
								System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
								nivel_dificultad="aaaaaaaaaaaaaaaaaaa";
							}
						}
						else {
							System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
							System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
							nivel_dificultad="aaaaaaaaaaaaa";
						}
					} while(nivel_dificultad.length()>=2);

					if (dificultad<1 || dificultad>3){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO ESTA ENTRE LOS NIVELES EXISTENTES. ELEGUIR ENTRE NUMEROS 1-2-3 \n");
						difi=true;
					}
					if(dificultad==3){
						difi=false;					
						Juego juego = new Juego(10, new JugadorHumano("User", 500), new Maquina("John", 3), new Maquina("Zion", 3), new Maquina("Carbon", 3),new Maquina("Elena", 3),new Maquina("Matt", 3),new Maquina("Peter", 3));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
					
					}
					if(dificultad==2){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1000), new Maquina("John", 2), new Maquina("Zion", 2), new Maquina("Carbon", 2),new Maquina("Elena", 2),new Maquina("Matt", 2),new Maquina("Peter", 2));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==1){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1500), new Maquina("John", 1), new Maquina("Zion", 1), new Maquina("Carbon", 1),new Maquina("Elena", 1),new Maquina("Matt", 1),new Maquina("Peter", 1));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
				}while(difi==true);
			}		
			if (jugadores==6){
				respuesta=false;
				do{
					do{

						System.out.println("Que nivel de dificultad usara? (1-2-3)");
						nivel_dificultad= escaner.nextLine();
						if(nivel_dificultad.length()<=1){
							try{
								dificultad=Integer.valueOf(nivel_dificultad);
							} catch (Exception b){
								System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
								System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
								nivel_dificultad="aaaaaaaaaaaaaaaaaaa";
							}
						}
						else {
							System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
							System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
							nivel_dificultad="aaaaaaaaaaaaa";
						}
					} while(nivel_dificultad.length()>=2);

					if (dificultad<1 || dificultad>3){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO ESTA ENTRE LOS NIVELES EXISTENTES. ELEGUIR ENTRE NUMEROS 1-2-3 \n");
						difi=true;
					}
					if(dificultad==3){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 500), new Maquina("John", 3), new Maquina("Zion", 3), new Maquina("Carbon", 3),new Maquina("Elena", 3),new Maquina("Matt", 3));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
					
					}
					if(dificultad==2){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1000), new Maquina("John", 2), new Maquina("Zion", 2), new Maquina("Carbon", 2),new Maquina("Elena", 2),new Maquina("Matt", 2));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==1){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1500), new Maquina("John", 1), new Maquina("Zion", 1), new Maquina("Carbon", 1),new Maquina("Elena", 1),new Maquina("Matt", 1));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
				}while(difi==true);
			}
			if (jugadores==5){
				respuesta=false;
				do{
					do{

						System.out.println("Que nivel de dificultad usara? (1-2-3)");
						nivel_dificultad= escaner.nextLine();
						if(nivel_dificultad.length()<=1){
							try{
								dificultad=Integer.valueOf(nivel_dificultad);
							} catch (Exception b){
								System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
								System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
								nivel_dificultad="aaaaaaaaaaaaaaaaaaa";
							}
						}
						else {
							System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
							System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
							nivel_dificultad="aaaaaaaaaaaaa";
						}
					} while(nivel_dificultad.length()>=2);

					if (dificultad<1 || dificultad>3){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO ESTA ENTRE LOS NIVELES EXISTENTES. ELEGUIR ENTRE NUMEROS 1-2-3 \n");
						difi=true;
					}
					if(dificultad==3){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 500), new Maquina("John", 3), new Maquina("Zion", 3), new Maquina("Carbon", 3),new Maquina("Elena", 3));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
					
					}
					if(dificultad==2){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1000), new Maquina("John", 2), new Maquina("Zion", 2), new Maquina("Carbon", 2),new Maquina("Elena", 2));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
					
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==1){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1500), new Maquina("John", 1), new Maquina("Zion", 1), new Maquina("Carbon", 11),new Maquina("Elena", 1));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
				}while(difi==true);
			}
			if (jugadores==4){
				respuesta=false;
				do{
					do{

						System.out.println("Que nivel de dificultad usara? (1-2-3)");
						nivel_dificultad= escaner.nextLine();
						if(nivel_dificultad.length()<=1){
							try{
								dificultad=Integer.valueOf(nivel_dificultad);
							} catch (Exception b){
								System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
								System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
								nivel_dificultad="aaaaaaaaaaaaaaaaaaa";
							}
						}
						else {
							System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
							System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
							nivel_dificultad="aaaaaaaaaaaaa";
						}
					} while(nivel_dificultad.length()>=2);

					if (dificultad<1 || dificultad>3){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO ESTA ENTRE LOS NIVELES EXISTENTES. ELEGUIR ENTRE NUMEROS 1-2-3 \n");
						difi=true;
					}
					if(dificultad==3){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 500), new Maquina("John", 3), new Maquina("Zion", 3), new Maquina("Carbon", 3));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==2){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1000), new Maquina("John", 2), new Maquina("Zion", 2), new Maquina("Carbon", 2));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==1){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1500), new Maquina("John", 1), new Maquina("Zion", 1), new Maquina("Carbon", 1));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
				}while(difi==true);
			}
			if (jugadores==3){
				respuesta=false;
				do{
					do{

						System.out.println("Que nivel de dificultad usara? (1-2-3)");
						nivel_dificultad= escaner.nextLine();
						if(nivel_dificultad.length()<=1){
							try{
								dificultad=Integer.valueOf(nivel_dificultad);
							} catch (Exception b){
								System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
								System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
								nivel_dificultad="aaaaaaaaaaaaaaaaaaa";
							}
						}
						else {
							System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
							System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
							nivel_dificultad="aaaaaaaaaaaaa";
						}
					} while(nivel_dificultad.length()>=2);

					if (dificultad<1 || dificultad>3){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO ESTA ENTRE LOS NIVELES EXISTENTES. ELEGUIR ENTRE NUMEROS 1-2-3 \n");
						difi=true;
					}
					if(dificultad==3){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 500), new Maquina("John", 3), new Maquina("Zion", 3));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==2){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1000), new Maquina("John", 2), new Maquina("Zion", 2));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
					
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==1){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1500), new Maquina("John", 1), new Maquina("Zion", 1));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
				}while(difi==true);
			}
			if (jugadores==2){
				respuesta=false;
				do{
					do{

						System.out.println("Que nivel de dificultad usara? (1-2-3)");
						nivel_dificultad= escaner.nextLine();
						if(nivel_dificultad.length()<=1){
							try{
								dificultad=Integer.valueOf(nivel_dificultad);
							} catch (Exception b){
								System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
								System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
								nivel_dificultad="aaaaaaaaaaaaaaaaaaa";
							}
						}
						else {
							System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
							System.out.println("LA OPCION INGRESADA NO CORRESPONDE. ELEGUIR ENTRE NUMEROS 1-2-3. \n");
							nivel_dificultad="aaaaaaaaaaaaa";
						}
					} while(nivel_dificultad.length()>=2);

					if (dificultad<1 || dificultad>3){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO ESTA ENTRE LOS NIVELES EXISTENTES. ELEGUIR ENTRE NUMEROS 1-2-3 \n");
						difi=true;
					}
					if(dificultad==3){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 500), new Maquina("John", 3));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==2){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1000), new Maquina("John", 2));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
					
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
					if(dificultad==1){
						difi=false;
						Juego juego = new Juego(10, new JugadorHumano("User", 1500), new Maquina("John", 1));
						juego.etapaActual = Juego.EtapasDeJuego.INICIO;

						while(true) {
							if(juego.incioSiguienteEtapa() == Juego.EtapasDeJuego.FIN)
								break;
							while(juego.incioSiguienteEtapa() != Juego.EtapasDeJuego.FIN);
							juego.incioSiguienteEtapa();
							juego.etapaActual = Juego.EtapasDeJuego.INICIO;
						}
						
						System.out.println();
						for (JugadorHumano p : juego.jugadores)
							System.out.println(p + " [fondo: " + p.getPlata() + "]");
						
					}
				}while(difi==true);


			}
		}while(respuesta==true);
		
		do{
			do{
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
				System.out.println("DESEA JUGAR DE NUEVO? (seleccione numero 1 o 2)");
				System.out.println("1. Si");
				System.out.println("2. No");
				opcion_eleguida=escaner.nextLine();
				if(opcion_eleguida.length()<=1){
					try{

						opcion=Integer.valueOf(opcion_eleguida);
					} catch (Exception a){
						System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
						System.out.println("LA OPCION INGRESADA NO CORRESPONDER. ELEGUIR 1 o 2. \n");
						opcion_eleguida="aaaaaaaaaaaaaaaaaaa";
					}
				}
				else {
					System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
					System.out.println("LA OPCION INGRESADA NO CORRESPONDER. ELEGUIR 1 o 2. \n");
					opcion_eleguida="aaaaaaaaaaaaa";
				}


			} while(opcion_eleguida.length()>=2);

			if (opcion<1 || opcion>2){
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
				System.out.println("LA OPCION INGRESADA NO CORRESPONDER. ELEGUIR 1 o 2. \n");
				opcion=0;
			}
			else if (opcion==1){
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
				System.out.println("GRACIAS POR QUERER JUGAR\n");
				opcion=1;
			}
			else{
				opcion=2;
			}

		}while (opcion!=1 && opcion!=2);



	}while (opcion==1);
	System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
	System.out.println("GRACIAS POR JUGAR :)");
	System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
	escaner.close();
	}
}

