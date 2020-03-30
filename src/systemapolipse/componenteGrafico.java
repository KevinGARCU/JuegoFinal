/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemapolipse;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author nicol
 */
public class componenteGrafico {
    /*esta clase sirve para añadir comoponentes a la pantalla, como las imagenes
    de los players, barra de vida, objetos, etc*/
    int posX,posY;
    Image imagen; 
    String ubicacionImagen;
    public componenteGrafico(String ubicacionImagen, int posX,int posY){
        this.posX = posX;
        this.posY = posY;
        this.ubicacionImagen = ubicacionImagen;
        ImageIcon img = new ImageIcon(this.getClass().getResource(this.ubicacionImagen));
        this.imagen = img.getImage();
    }

    public Image getImagen() {
        return imagen;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setImagen(String ubicacionImagen) {
        this.ubicacionImagen = ubicacionImagen;
        ImageIcon img = new ImageIcon(this.getClass().getResource(ubicacionImagen));
        this.imagen = img.getImage();
    }
    
}
