package systemapolipse;

import java.awt.Image;
import java.awt.event.KeyEvent;

public abstract class  Personaje {
    
    public static Personaje instance;

    int dx;
    int dy;
    int x;
    int y;
    String UbicacionImagen;
    Image Imagen;
    int cont = 0;
    int numeroVidas = 3;
    int orientacion;
    
    public void mover(){
        if (dx > 0 && x <= 1210) {
            x += dx;
        } else if (dx < 0 && x >= 40) {
            x += dx;
        }

        if (dy > 0 && y <= 780) {
            y += dy;
        } else if (dy < 0 && y >= 40) {
            y += dy;
        }
    }
    
    abstract public void keyPressed(KeyEvent e);
    
    abstract public void keyReleased(KeyEvent e);
            
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagen() {
        return Imagen;
    }

    public int getNumeroVidas() {
        return numeroVidas;
    }

    public void setNumeroVidas(int numeroVidas) {
        this.numeroVidas = numeroVidas;
    }
    
}
