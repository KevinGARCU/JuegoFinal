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
public class Fondo {
    String UbicacionImagen;
    Image Imagen;
    
    public Fondo(String ruta){
        UbicacionImagen = ruta;
        Imagen = new ImageIcon(getClass().getResource(UbicacionImagen)).getImage();
        System.out.println("carga exitosa");
    }
    
    public Image getImagen() {
        return Imagen;
    }
}
