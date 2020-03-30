package systemapolipse;

/**
 *
 * @author Kevin Garcia
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class BolaPoder{
    
    boolean atacando = false;
    boolean choque = true;
    int dx = 5;
    int dy = 5;
    int x, y;
    int cont=0;
    Image image;
    int orientacion;
    Image sprites[][] = {{new ImageIcon(getClass().getResource("../Recursos/poder00.png")).getImage(),
        new ImageIcon(getClass().getResource("../Recursos/poder01.png")).getImage()},
        {new ImageIcon(getClass().getResource("../Recursos/poder02.png")).getImage(),
        new ImageIcon(getClass().getResource("../Recursos/poder03.png")).getImage()},
    {new ImageIcon(getClass().getResource("../Recursos/poder04.png")).getImage(),
        new ImageIcon(getClass().getResource("../Recursos/poder05.png")).getImage()},
    {new ImageIcon(getClass().getResource("../Recursos/poder06.png")).getImage(),
        new ImageIcon(getClass().getResource("../Recursos/poder06.png")).getImage()}};

    public void lanzar() {
        atacando = true;
        switch (orientacion){
            case 0 : 
                y = y + 60;
                x = x + 5;
                break;
            case 1 :
                x = x + 50;
                y = y + 5;
                break;
            case 2: 
                x = x - 30;
                y = y + 40;
            case 3: 
                x = x + 5;
                y = y - 30;
        }        
            image = sprites[orientacion][cont];                            
        
    }
    public void aumentar(){
        switch (orientacion){
            case 0 : 
                y += dy;
                break;
            case 1 :
                x += dx;
                break;
            case 2: 
                x -= dx;
                break;
            case 3: 
                y -= dy;
                break;
        }   
    }
    public void detener(){
        switch (orientacion){
            case 0 : 
                y = 900;
                x = 1400;
                break;
            case 1 :
                y = 900;
                x = 1400;
                break;
            case 2: 
                y = -30;
                x = -30;
                break;
            case 3: 
                y = -30;
                x = -30;
                break;
        } 
    }
    
    public void setXY(int x,int y,int orientacion) {
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
    }    

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isChoque() {
        return choque;
    }

    public void setChoque(boolean choque) {
        this.choque = choque;
    }
    
    
}

