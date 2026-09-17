/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

/**
 *
 * @author batoi
 */
public class Tablero {

    private int dimension;
    private EstatCasella[][] casillas;
    private String separador = "|";
    private char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Tablero(int dimension) {
        this.dimension = dimension;
        this.casillas = new EstatCasella[dimension][dimension];
        vaciar();
    }

    public void vaciar() {
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                this.casillas[i][j] = EstatCasella.VACIO;
            }
        }
    }

    public boolean isCoordenadaValida(Coordenada coordenada) {
        return coordenada.isValida(dimension);
    }

    public void mostrar() {
        System.out.print(separador + " " + separador);
        for (int i = 0; i < dimension; i++) {
            System.out.print((i + 1) + separador);
        }
        for (int i = 0; i < dimension; i++) {
            System.out.print("\n" + separador + letras[i] + separador);
            for (EstatCasella elem : this.casillas[i]) {
                System.out.print(elem + separador);

            }
           
        }
    }

    public void posarFicha(Coordenada coordenada, EstatCasella tipoFicha) {
        this.casillas[coordenada.getFila()][coordenada.getColumna()] = tipoFicha;
    }

    public boolean isOcupada(Coordenada coordenada) {
        return !this.casillas[coordenada.getFila()][coordenada.getColumna()].equals(EstatCasella.VACIO);
    }

    public boolean estaPle() {

        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                Coordenada coor = new Coordenada(i + 1, j + 1);
                if (!isOcupada(coor)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hiHaTresEnRatlla() {
        if (hiHaTresEnRatlla(EstatCasella.FICHA_O) || hiHaTresEnRatlla(EstatCasella.FICHA_X)) {
            return true;
        }
        return false;

    }

    private boolean hiHaTresEnRatlla(EstatCasella tipoFicha) {
        if (hayTresEnColumnaRecta(tipoFicha) || hayTresEnDiagonal(tipoFicha)
                || hayTresEnFilaRecta(tipoFicha) || hayTresEnOtroDiagonal(tipoFicha)) {
            return true;
        }
        return false;

    }

    private boolean hayTresEnFilaRecta(EstatCasella tipoFicha) {
        for (int i = 0; i < this.casillas.length; i++) {
            int cont = 0;
            for (int j = 0; j < this.casillas[i].length; j++) {
                if (this.casillas[i][j].equals(tipoFicha)) {
                    cont++;
                    if (cont == this.dimension) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hayTresEnColumnaRecta(EstatCasella tipoFicha) {
        for (int i = 0; i < this.casillas.length; i++) {
            int cont = 0;
            for (int j = 0; j < this.casillas.length; j++) {
                if (this.casillas[j][i].equals(tipoFicha)) {
                    cont++;
                    if (cont == this.dimension) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hayTresEnDiagonal(EstatCasella tipoFicha) {
        int auxColum = 0;
        for (int i = 0; i < this.dimension; i++) {
            if (!this.casillas[i][auxColum].equals(tipoFicha)) {
                return false;
            }
            auxColum++;
        }
        return true;
    }

    private boolean hayTresEnOtroDiagonal(EstatCasella tipoFicha) {
        int auxColum = 0;
        for (int i = (this.dimension - 1); i >= 0; i--) {
            if (!this.casillas[i][auxColum].equals(tipoFicha)) {
                return false;
            }
        }
        return true;

    }

}
