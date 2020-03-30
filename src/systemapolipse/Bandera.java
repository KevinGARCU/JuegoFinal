/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemapolipse;

/**
 *
 * @author Kevin Garcia
 */
public class Bandera extends componenteGrafico {
    
    boolean Libre = true;

    public void setLibre(boolean atrapada) {
        this.Libre = atrapada;
    }

    public boolean isLibre() {
        return Libre;
    }
    
    public Bandera(String ubicacionImagen, int posX, int posY) {
        super(ubicacionImagen, posX, posY);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
}
