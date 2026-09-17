/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sa6.tresenraya;

/**
 *
 * @author batoi
 */
public enum EstatCasella {
    FICHA_O,
    FICHA_X,
    VACIO;

    public String toString(){
        return switch (this){
            case FICHA_O->"0";
            case FICHA_X->"X";
            case VACIO->" ";
        };
    }
    
}
