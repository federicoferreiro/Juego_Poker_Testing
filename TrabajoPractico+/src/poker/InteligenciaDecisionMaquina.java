package poker;

import java.util.ArrayList;


public class InteligenciaDecisionMaquina
{
        Juego juego;
        Maquina maq;
        double probabilidadDeGanar;
        double probabilidadDeObtenerLaCartaRequerida;

        public InteligenciaDecisionMaquina(Juego juego, Maquina maq)
        {
            this.juego=juego;
            this.maq=maq;
        }

        public JugadorHumano.Decision getDecision()
        {
            if(juego.etapaActual==Juego.EtapasDeJuego.Preflop )
            {
                return JugadorHumano.Decision.CALL;
            }
            else if(juego.etapaActual== Juego.EtapasDeJuego.Flop)
            {
                RankingDeCombinaciones combo = new RankingDeCombinaciones( maq.getCartas(), juego.cartasDeMesa);



                Mazo mazo =new Mazo();

                mazo.carta.removeAll(maq.getCartas());
                mazo.carta.removeAll(juego.cartasDeMesa);

                ArrayList<Carta> cartasAgregadas = new ArrayList<>(2);
                RankingDeCombinaciones.Combinaciones comTemp=null;
                RankingDeCombinaciones combTemp;
                int max=0;


                    this.probabilidadDeGanar = 0;

                    for(Carta c1 : mazo.carta)
                    {
                        cartasAgregadas.add(c1);


                        cartasAgregadas.addAll(juego.cartasDeMesa);
                        combTemp = new RankingDeCombinaciones(maq.getCartas(), cartasAgregadas);

                        comTemp = combTemp.mejorCombinacion();



                        if(comTemp.ordinal()>max)
                        {
                            max = comTemp.ordinal();
                            probabilidadDeGanar = max;
                            probabilidadDeObtenerLaCartaRequerida = 2/47;
                        }

                        for(Carta c2 : mazo.carta)
                        {
                            cartasAgregadas.add(c2);
                            cartasAgregadas.addAll(juego.cartasDeMesa);
                            comTemp = combo.mejorCombinacion();
                            if(comTemp.ordinal()>max)
                            {
                                max = comTemp.ordinal();
                                probabilidadDeObtenerLaCartaRequerida = 1/47;
                            }
                        }

                        cartasAgregadas.clear();
                    }

                    if(max > 2)
                    {
                        return JugadorHumano.Decision.CALL;
                    }
                    else
                    {
                        return JugadorHumano.Decision.FOLD;
                    }
                }

            else if(juego.etapaActual== Juego.EtapasDeJuego.Turn)
            {
                RankingDeCombinaciones combo = new RankingDeCombinaciones( maq.getCartas(), juego.cartasDeMesa);

           

                Mazo mazo =new Mazo();

                mazo.carta.removeAll(maq.getCartas());
                mazo.carta.removeAll(juego.cartasDeMesa);

                ArrayList<Carta> cartasAgregadas = new ArrayList<>(2);
                RankingDeCombinaciones.Combinaciones comTemp=null;
                RankingDeCombinaciones combTemp;
                int max=0;


                this.probabilidadDeGanar = 0;

                for(Carta c1 : mazo.carta)
                {
                    cartasAgregadas.add(c1);


                    cartasAgregadas.addAll(juego.cartasDeMesa);
                    combTemp = new RankingDeCombinaciones(maq.getCartas(), cartasAgregadas);

                    comTemp = combTemp.mejorCombinacion();



                    if(comTemp.ordinal()>max)
                    {
                        max = comTemp.ordinal();
                        probabilidadDeGanar = max;
                        probabilidadDeObtenerLaCartaRequerida = 2/47;
                    }

                    for(Carta c2 : mazo.carta)
                    {
                        cartasAgregadas.add(c2);
                        cartasAgregadas.addAll(juego.cartasDeMesa);
                        comTemp = combo.mejorCombinacion();
                        if(comTemp.ordinal()>max)
                        {
                            max = comTemp.ordinal();
                            probabilidadDeObtenerLaCartaRequerida = 1/47;
                        }
                    }

                    cartasAgregadas.clear();
                }

                if(max > 5 && max < 9)
                {
                    return JugadorHumano.Decision.CALL;
                }
                else if(max < 5)
                {
                    return JugadorHumano.Decision.CHECK;
                }
                else
                {
                    return JugadorHumano.Decision.RAISE;
                }
            }
            else if(juego.etapaActual== Juego.EtapasDeJuego.River)
            {
                RankingDeCombinaciones combo = new RankingDeCombinaciones( maq.getCartas(), juego.cartasDeMesa);

            

                Mazo mazo =new Mazo();

                mazo.carta.removeAll(maq.getCartas());
                mazo.carta.removeAll(juego.cartasDeMesa);

                ArrayList<Carta> cartasAgregaddas = new ArrayList<>(2);
                RankingDeCombinaciones.Combinaciones comTemp=null;
                RankingDeCombinaciones combTemp;
                int max=0;


                this.probabilidadDeGanar = 0;

                for(Carta c1 : mazo.carta)
                {
                    cartasAgregaddas.add(c1);


                    cartasAgregaddas.addAll(juego.cartasDeMesa);
                    combTemp = new RankingDeCombinaciones(maq.getCartas(), cartasAgregaddas);

                    comTemp = combTemp.mejorCombinacion();



                    if(comTemp.ordinal()>max)
                    {
                        max = comTemp.ordinal();
                        probabilidadDeGanar = max;
                        probabilidadDeObtenerLaCartaRequerida = 2/47;
                    }

                    for(Carta c2 : mazo.carta)
                    {
                        cartasAgregaddas.add(c2);
                        cartasAgregaddas.addAll(juego.cartasDeMesa);
                        comTemp = combo.mejorCombinacion();
                        if(comTemp.ordinal()>max)
                        {
                            max = comTemp.ordinal();
                            probabilidadDeObtenerLaCartaRequerida = 1/47;
                        }
                    }

                    cartasAgregaddas.clear();
                }

                if(comTemp.ordinal() > 5 && comTemp.ordinal() < 9)
                {
                    return JugadorHumano.Decision.CALL;
                }
                else if(comTemp.ordinal() < 5)
                {
                    return JugadorHumano.Decision.CHECK;
                }
                else if(comTemp.ordinal() >= 9)
                {
                    return JugadorHumano.Decision.RAISE;
                }
            }

                return JugadorHumano.Decision.CALL;
        }
}