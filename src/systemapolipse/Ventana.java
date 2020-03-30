package systemapolipse;

import java.applet.AudioClip;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    AudioClip sonido;
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        add(new Escenario());
        setTitle("System Apocalipse");
        setSize(1295, 820);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("../Recursos/music.wav"));        
        sonido.play();
        //cargar el icono
        try {
            Image img = ImageIO.read(getClass().getResource("../Recursos/Logo2.png"));
            this.setIconImage(img);            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}