/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

/**
 *
 * @author batoi
 */
public class Jugador {

    private EstatCasella fichaPropia;

    public Jugador(EstatCasella fichaPropia) {
        this.fichaPropia = fichaPropia;
    }

    public void posarFicha(Tablero tablero) {
        Coordenada coor;
       do{
          coor = obtenirCordenada(tablero);
          if(tablero.isOcupada(coor)){
              System.out.println("Esa posición ya está ocupada, elige otra");
          }
       } while(tablero.isOcupada(coor));
       tablero.posarFicha(coor, fichaPropia);

    }

    private Coordenada obtenirCordenada(Tablero tablero) {
        Coordenada eleCor=null;
        String eleccion;
        do {
            eleccion = GestorIO.leerLetraGuionNumero("\nJugador con " + fichaPropia);
            eleCor = new Coordenada(GestorIO.letraANumero(eleccion.substring(0, 1)),
                    (Integer.parseInt(eleccion.substring(2))-1));

        } while (!tablero.isCoordenadaValida(eleCor));
        return eleCor;
    }
    
    public void cantarVictoria(){
        GestorIO.mostrarMensaje("¡El jugador "+fichaPropia+" es el ganador!");
    }

}
