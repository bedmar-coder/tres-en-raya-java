/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

/**
 *
 * @author batoi
 */
public class TresEnRaya {

    private Tablero tablero;
    private Jugador[] jugadores = new Jugador[2];
    private final int DIMENSION_MINIMA = 3;
    private final int DIMENSION_MAXIMA = 8;
    private final String CONFIRMACION_DIMENSION
            = "Vols donar una nova dimensió al tauler?(Per defecte 3)[S/n]";
    private final String PREGUNTA_DIMENSION = "Introdueix la dimension del tauler •[3-8]";
    private final String EMPATE = "Es un empate!";
    private static final String JUGAR_DE_NUEVO = "Voleu jugar de nou?[s/n]";
    private final static String DESPEDIDA = "Tancant joc...Fins la proxima!";

    public static void main(String[] args) {
        boolean jugarDeNuevo = false;
        do {
            TresEnRaya tresEnRaya = new TresEnRaya();
            tresEnRaya.jugar();
            jugarDeNuevo = GestorIO.solicitarConfirmacion(JUGAR_DE_NUEVO);
        } while (jugarDeNuevo);
        System.out.println(DESPEDIDA);
    }

    public TresEnRaya() {
        if (GestorIO.solicitarConfirmacion(CONFIRMACION_DIMENSION)) {
            int dimension = GestorIO.leerEntero(PREGUNTA_DIMENSION);
            this.tablero = new Tablero(dimension);

        } else {
            this.tablero = new Tablero(DIMENSION_MINIMA);
        }
        this.jugadores[0] = new Jugador(EstatCasella.FICHA_O);
        this.jugadores[1] = new Jugador(EstatCasella.FICHA_X);
    }

    public void jugar() {
        do {tablero.mostrar();
            this.jugadores[0].posarFicha(tablero);
            if (tablero.hiHaTresEnRatlla()) {
                this.jugadores[0].cantarVictoria();
                return;
            }
            tablero.mostrar();
            this.jugadores[1].posarFicha(tablero);
            if (tablero.hiHaTresEnRatlla()) {
                this.jugadores[1].cantarVictoria();
                return;
            }
        } while (!tablero.estaPle());
        System.out.println(EMPATE);
    }

}
