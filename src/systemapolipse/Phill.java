package systemapolipse;

import java.applet.AudioClip;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Phill extends Personaje {
    
    
    AudioClip disparo;
    AudioClip dolor;
    BolaPoder bolaPoder = new BolaPoder();
    
    Image[][] ataque = {{new ImageIcon(getClass().getResource("../Phill/Ataque0.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque1.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque2.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque3.png")).getImage()
        },
        {new ImageIcon(getClass().getResource("../Phill/Ataque4.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque5.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque6.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque7.png")).getImage()
        },
        {new ImageIcon(getClass().getResource("../Phill/Ataque8.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque9.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque10.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque11.png")).getImage()
        },
        {new ImageIcon(getClass().getResource("../Phill/Ataque12.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque13.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque14.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/Ataque15.png")).getImage(),}
        };
    
    Image[][] imagenes = {{new ImageIcon(getClass().getResource("../Phill/posicion0.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion1.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion2.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion3.png")).getImage()
        },
        {new ImageIcon(getClass().getResource("../Phill/posicion4.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion5.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion6.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion7.png")).getImage()
        },
        {new ImageIcon(getClass().getResource("../Phill/posicion8.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion9.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion10.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion11.png")).getImage()
        },
        {new ImageIcon(getClass().getResource("../Phill/posicion12.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion13.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion14.png")).getImage(),
            new ImageIcon(getClass().getResource("../Phill/posicion15.png")).getImage(),}
        };
    

    public Phill() {
        disparo = java.applet.Applet.newAudioClip(getClass().getResource("../Recursos/shoot1.wav"));
        x = 250;
        y = 410;   
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            orientacion =1;
            dx = 2;
            cont++;
            cont = cont % 4;
            Imagen = imagenes[2][cont];
        }
        
        if (key == KeyEvent.VK_LEFT) {
            orientacion =2;
            dx = -2;
            cont++;
            cont = cont % 4;
            Imagen = imagenes[1][cont];
        }
        if (key == KeyEvent.VK_UP) {
            orientacion =3;
            dy = -2;
            cont++;
            cont = cont % 4;
            Imagen = imagenes[3][cont];
        }
        if (key == KeyEvent.VK_DOWN) {
            orientacion =0;
            dy = 2;
            cont++;
            cont = cont % 4;
            Imagen = imagenes[0][cont];
        }
        
        if(key == KeyEvent.VK_ENTER){
            cont++;
            cont = cont % 4;            
            Imagen = ataque[orientacion][cont];
            bolaPoder.setXY(x,y,orientacion);
            disparo.play();
            bolaPoder.lanzar();
        }
        
    }
    
    public static Personaje getInstancia() {
        if (instance == null) {
            instance = new Phill();
        }
        return instance;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        
        if(key == KeyEvent.VK_ENTER){   
        }

    }
  
    private void getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
