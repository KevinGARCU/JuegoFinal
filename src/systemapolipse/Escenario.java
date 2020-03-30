package systemapolipse;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Escenario extends JPanel implements ActionListener {

    private final Phill phill;
    private final Steve steve;
    private componenteGrafico player1;
    private componenteGrafico player2;
    private componenteGrafico player1win;
    private componenteGrafico player2win;
    private componenteGrafico vidaPhill;
    private componenteGrafico vidaSteve;
    private Bandera banderaPhill;
    private Bandera banderaSteve;
    private final Timer timer;
    private JButton botonIniciar;  
    private JButton botonAceptar;
    private JButton botonRechazar;    
    private JButton botonInstrucciones;    
    private Image escena;
    private TAdapter tadapter;
    private Fondo portada, fondoJuego,fondoTyC,fondoInstrucciones;
    private boolean juegoActivo = false;
    private boolean terminosyCondiciones = false; //si la variable está en falso, no ha mostrado los terminos y condiciones ni las instrucciones
    private boolean instrucciones = false; //si es verdadero, asumimos que las instrucciones fueron mostradas
    private boolean ganaPhill = false;
    private boolean ganaSteve = false;   
    private AudioClip dolor;
    public Escenario() {       
        tadapter = new TAdapter();
        botonIniciar = new JButton(); 
        botonAceptar = new JButton();
        botonRechazar = new JButton();
        botonInstrucciones = new JButton();
        setFocusable(true);
        setDoubleBuffered(true);
        this.addKeyListener(tadapter);
        
        try {
            Image img = ImageIO.read(getClass().getResource("../Recursos/boton.png"));
            Image img1 = ImageIO.read(getClass().getResource("../Recursos/ok.png"));
            Image img2 = ImageIO.read(getClass().getResource("../Recursos/no.png"));
            Image img3 = ImageIO.read(getClass().getResource("../Recursos/instruccionesBoton.png"));
            botonIniciar.setIcon(new ImageIcon(img));
            botonAceptar.setIcon(new ImageIcon(img1));
            botonRechazar.setIcon(new ImageIcon(img2));     
            botonInstrucciones.setIcon(new ImageIcon(img3));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        portada = new Fondo("../Recursos/portada.png");
        fondoJuego = new Fondo("../Recursos/fondo.png");
        fondoTyC = new Fondo("../Recursos/Terminos y condiciones.png");   
        fondoInstrucciones = new Fondo("../Recursos/INSTRUCCIONES.png");
        phill = new Phill();
        steve = new Steve();

        player1 = new componenteGrafico("../Recursos/player1.png", 50, 20);        
        vidaPhill = new componenteGrafico("../Recursos/3vidas.png", 50, 70);
        player1win = new componenteGrafico("../Recursos/p1win.png", 390,350);
        player2 = new componenteGrafico("../Recursos/player2.png", 730, 20);
        player2win = new componenteGrafico("../Recursos/p2win.png", 390, 350);
        vidaSteve = new componenteGrafico("../Recursos/3vidas.png", 730, 70);

        banderaPhill = new Bandera("../Recursos/Bandera0.png", 130, 430);
        banderaSteve = new Bandera("../Recursos/Bandera1.png", 1115, 430);

        dolor = java.applet.Applet.newAudioClip(getClass().getResource("../Recursos/dolor.wav"));
        timer = new Timer(10, this);
        jugandoActualizarr();
        botonIniciar.addActionListener(tadapter);
        botonAceptar.addActionListener(tadapter);
        botonRechazar.addActionListener(tadapter);
        botonInstrucciones.addActionListener(tadapter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        phill.mover();
        steve.mover();
        colision();
        buscarGanador();
        repaint();
    }
    
    
    public void jugandoActualizarr() {
        if (juegoActivo) {
            remove(botonInstrucciones);
            remove(botonIniciar);   
            remove(botonAceptar);
            remove(botonRechazar);
            escena = fondoJuego.getImagen();            
            if (phill.getNumeroVidas() == 1) {
                vidaPhill.setImagen("../Recursos/1vida.png");
            }
            if (phill.getNumeroVidas() == 2) {
                vidaPhill.setImagen("../Recursos/2vidas.png");
            }
            if (phill.getNumeroVidas() == 3) {
                vidaPhill.setImagen("../Recursos/3vidas.png");
            }
            if (steve.getNumeroVidas() == 1) {
                vidaSteve.setImagen("../Recursos/1vida.png");
            }
            if (steve.getNumeroVidas() == 2) {
                vidaSteve.setImagen("../Recursos/2vidas.png");
            }
            if (steve.getNumeroVidas() == 3) {
                vidaSteve.setImagen("../Recursos/3vidas.png");
            }
        } else {
            if (terminosyCondiciones) {
                escena = portada.getImagen();
                remove(botonAceptar);
                remove(botonRechazar);
                add(botonInstrucciones);
                botonInstrucciones.setBounds(675, 635, botonInstrucciones.getIcon().getIconWidth(), botonInstrucciones.getIcon().getIconHeight());                
                botonInstrucciones.setEnabled(true);
                botonInstrucciones.setVisible(true);
                add(botonIniciar);
                botonIniciar.setBounds(375, 635, botonIniciar.getIcon().getIconWidth(), botonIniciar.getIcon().getIconHeight());                
                botonIniciar.setEnabled(true);
                botonIniciar.setVisible(true);
                if(instrucciones){
                    remove(botonInstrucciones);
                    escena = fondoInstrucciones.getImagen();                    
                }
            } 
            else{
                escena = fondoTyC.getImagen();
                add(botonAceptar);
                add(botonRechazar);
                botonAceptar.setBounds(375, 635, botonAceptar.getIcon().getIconWidth(), botonAceptar.getIcon().getIconHeight());
                botonAceptar.setEnabled(true);
                botonAceptar.setVisible(true);
                botonRechazar.setBounds(675, 635, botonRechazar.getIcon().getIconWidth(), botonRechazar.getIcon().getIconHeight());
                botonRechazar.setEnabled(true);
                botonRechazar.setVisible(true);
            }           
        }
    }

    @Override
    public void paint(Graphics g) {        
        jugandoActualizarr();
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (juegoActivo) {              
            g2d.drawImage(escena, 0, 0, this);
            if(ganaPhill){
                if(timer.getDelay()==3000){
                    juegoActivo = false;
                    timer.setDelay(5);
                }
                g2d.drawImage(player1win.getImagen(), player1win.getPosX(), player1win.getPosY(), this);
                timer.setDelay(3000);                
            }
            if(ganaSteve){
                if(timer.getDelay()==3000)juegoActivo = false;
                g2d.drawImage(player2win.getImagen(), player2win.getPosX(), player2win.getPosY(), this);
                timer.setDelay(3000);                
            }
            if (banderaSteve.isLibre()) {
                g2d.drawImage(banderaSteve.getImagen(), banderaSteve.getPosX(), banderaSteve.getPosY(), this);
            } else {
                banderaSteve.setPosX(300);
                banderaSteve.setPosY(15);
                g2d.drawImage(banderaSteve.getImagen(), banderaSteve.getPosX(), banderaSteve.getPosY(), this);
            }

            if (banderaPhill.isLibre()) {
                g2d.drawImage(banderaPhill.getImagen(), banderaPhill.getPosX(), banderaPhill.getPosY(), this);
            } else {
                banderaPhill.setPosX(950);
                banderaPhill.setPosY(15);
                g2d.drawImage(banderaPhill.getImagen(), banderaPhill.getPosX(), banderaPhill.getPosY(), this);
            }

            if (phill.bolaPoder.isChoque()) {
                g2d.drawImage(phill.bolaPoder.getImage(), phill.bolaPoder.getX(), phill.bolaPoder.getY(), this);
                phill.bolaPoder.aumentar();
            }
            phill.bolaPoder.setChoque(true);

            if (steve.bolaPoder.isChoque()) {
                g2d.drawImage(steve.bolaPoder.getImage(), steve.bolaPoder.getX(), steve.bolaPoder.getY(), this);
                steve.bolaPoder.aumentar();
            }
            steve.bolaPoder.setChoque(true);
            
            g2d.drawImage(phill.getImagen(), phill.getX(), phill.getY(), this);
            g2d.drawImage(steve.getImagen(), steve.getX(), steve.getY(), this);
            g2d.drawImage(player1.getImagen(), player1.getPosX(), player2.getPosY(), this);
            g2d.drawImage(vidaPhill.getImagen(), vidaPhill.getPosX(), vidaPhill.getPosY(), this);
            g2d.drawImage(player2.getImagen(), player2.getPosX(), player2.getPosY(), this);
            g2d.drawImage(vidaSteve.getImagen(), vidaSteve.getPosX(), vidaSteve.getPosY(), this);
            g2d.drawImage(steve.bolaPoder.getImage(), steve.bolaPoder.getX(), steve.bolaPoder.getY(), this);            
        } else {
            
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(escena, 0, 0, this);        
    }

    public void buscarGanador(){        
        if(banderaSteve.isLibre()==false){
            if(phill.getX()>=92 && phill.getX()<=150){
                if(phill.getY()>= 398 && phill.getY()<=444){                    
                    ganaPhill = true;
                }
            }
            else{
                ganaPhill = false;
            }
        }   
        else{
            ganaPhill = false;
        }
        if(banderaPhill.isLibre()==false){
            if(steve.getX()>=1092 && steve.getX()<=1174){
                if(steve.getY()>= 398 && steve.getY()<=444){
                    ganaSteve = true; 
                }
            }
            else{
                ganaSteve = false;
            }
        }   
        else{
            ganaSteve = false;
        }
        if(phill.numeroVidas==0)ganaSteve = true;            
        if(steve.numeroVidas==0)ganaPhill = true;
    }
    public void colision() {
        //bandera de Steve
        if (phill.getX() >= banderaSteve.getPosX() - 20 && phill.getX() <= banderaSteve.getPosX() + 20) {
            if (phill.getY() >= banderaSteve.getPosY() - 30 && phill.getY() <= banderaSteve.getPosY() + 30) {
                banderaSteve.setLibre(false);
            }
        }
        //bandera Phill
        if (steve.getX() >= banderaPhill.getPosX() - 20 && steve.getX() <= banderaPhill.getPosX() + 20) {
            if (steve.getY() >= banderaPhill.getPosY() - 30 && steve.getY() <= banderaPhill.getPosY() + 30) {
                banderaPhill.setLibre(false);
            }
        }
        //ataque Phill a Steve
        if (phill.bolaPoder.getX() >= steve.getX() - 30 && phill.bolaPoder.getX() <= steve.getX() + 30) {
            if (phill.bolaPoder.getY() >= steve.getY() - 40 && phill.bolaPoder.getY() <= steve.getY() + 40) {
                phill.bolaPoder.setChoque(false);
                steve.setNumeroVidas(steve.getNumeroVidas() - 1);
                dolor.play();
                phill.bolaPoder.detener();
            }
        }
        //ataque Steve a Phill
        if (steve.bolaPoder.getX() >= phill.getX() - 30 && steve.bolaPoder.getX() <= phill.getX() + 30) {
            if (steve.bolaPoder.getY() >= phill.getY() - 40 && steve.bolaPoder.getY() <= phill.getY() + 40) {
                steve.bolaPoder.setChoque(false);
                phill.setNumeroVidas(phill.getNumeroVidas() - 1);
                dolor.play();
                steve.bolaPoder.detener();
            }
        }
    }

    private class TAdapter extends KeyAdapter implements ActionListener {

        @Override
        public void keyReleased(KeyEvent e) {
            phill.keyReleased(e);
            steve.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            phill.keyPressed(e);
            steve.keyPressed(e);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonAceptar) {
                terminosyCondiciones = true;
                repaint();
            }
            if (e.getSource() == botonIniciar) {
                instrucciones = false;
                ganaSteve = false;
                ganaPhill = false;                
                phill.numeroVidas = 3;
                steve.numeroVidas = 3;
                banderaPhill.setLibre(true);
                banderaSteve.setLibre(true);
                banderaPhill.setPosX(130);
                banderaPhill.setPosY(430);
                banderaSteve.setPosX(1115);
                banderaSteve.setPosY(430);
                phill.x = 250;
                phill.y = 410;
                steve.x = 1000;
                steve.y = 410;
                phill.bolaPoder.atacando = false;
                steve.bolaPoder.atacando = false;
                juegoActivo = true;                
                timer.setDelay(5);
                timer.start();                
            }
            if(e.getSource() == botonRechazar){
                System.exit(0);
            }            
            if(e.getSource() == botonInstrucciones){
                instrucciones = true;
                repaint();
            }
        }
    }
}
