package interfaz_grafica.mijuego2;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class Canvas extends JPanel{
    Raqueta raqueta = new Raqueta(this,450/2-150/2,736-120,150,5);
    Pelota pelota = new Pelota(this,30);        
    ArrayList<Bloques> bloque = new ArrayList();
    boolean principio = true;
    
    public Canvas() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                raqueta.keyPressed(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                raqueta.KeyReleased(e);
            }
        });
        this.setFocusable(true);
    }
    public void Bloque(){
            Bloques bloque1 = new Bloques(this,0,100,75,15);
            Bloques bloque2 = new Bloques(this,76,100,75,15);
            Bloques bloque3 = new Bloques(this,152,100,75,15);
            Bloques bloque4 = new Bloques(this,228,100,75,15);
            Bloques bloque5 = new Bloques(this,304,100,75,15);
            Bloques bloque6 = new Bloques(this,380,100,75,15);
            Bloques bloque7 = new Bloques(this,0,116,75,15);
            Bloques bloque8 = new Bloques(this,76,116,75,15);
            Bloques bloque9 = new Bloques(this,152,116,75,15);
            Bloques bloque10 = new Bloques(this,228,116,75,15);
            Bloques bloque11 = new Bloques(this,304,116,75,15);
            Bloques bloque12 = new Bloques(this,380,116,75,15);
            Bloques bloque13 = new Bloques(this,0,132,75,15);
            Bloques bloque14 = new Bloques(this,76,132,75,15);
            Bloques bloque15 = new Bloques(this,152,132,75,15);
            Bloques bloque16 = new Bloques(this,228,132,75,15);
            Bloques bloque17 = new Bloques(this,304,132,75,15);
            Bloques bloque18 = new Bloques(this,380,132,75,15);
            Bloques bloque19 = new Bloques(this,0,148,75,15);
            Bloques bloque20 = new Bloques(this,76,148,75,15);
            Bloques bloque21 = new Bloques(this,152,148,75,15);
            Bloques bloque22 = new Bloques(this,228,148,75,15);
            Bloques bloque23 = new Bloques(this,304,148,75,15);
            Bloques bloque24 = new Bloques(this,380,148,75,15);
            
            bloque.add(bloque1);
            bloque.add(bloque2);
            bloque.add(bloque3);
            bloque.add(bloque4);
            bloque.add(bloque5);
            bloque.add(bloque6);
            bloque.add(bloque7);
            bloque.add(bloque8);            
            bloque.add(bloque9);            
            bloque.add(bloque10);            
            bloque.add(bloque11);            
            bloque.add(bloque12);
            bloque.add(bloque13);
            bloque.add(bloque14);
            bloque.add(bloque15);
            bloque.add(bloque16);
            bloque.add(bloque17);
            bloque.add(bloque18);
            bloque.add(bloque19);
            bloque.add(bloque20);            
            bloque.add(bloque21);            
            bloque.add(bloque22);            
            bloque.add(bloque23);            
            bloque.add(bloque24);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
        raqueta.draw(g2d);
        pelota.draw(g2d);        
        if(principio || raqueta.vidas == 0){
            this.Bloque();
            raqueta.vidas = 3;
            principio = false;            
        }
        for (int i = 0; i < bloque.size(); i++) {
            bloque.get(i).draw(g2d);
        }
        if(bloque.isEmpty()){
            g.setFont( new Font( "Tahoma", Font.BOLD, 30 ) );            
            pelota.ganado = false;
            pelota.direccionX = 0;
            pelota.direccionY = 0;            
            g.drawString("Has g2danado",125,350);
        }        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    }

    public void update(){
        raqueta.update();
        pelota.update();
    }

    public void pintar(Graphics2D g) {
        g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
        raqueta.draw(g);
        pelota.draw(g);        
        if(principio || raqueta.vidas == 0){
            this.Bloque();
            raqueta.vidas = 3;
            principio = false;            
        }
        for (int i = 0; i < bloque.size(); i++) {
            bloque.get(i).draw(g);
        }
        if(bloque.isEmpty()){
            g.setFont( new Font( "Tahoma", Font.BOLD, 30 ) );            
            pelota.ganado = false;
            pelota.direccionX = 0;
            pelota.direccionY = 0;            
            g.drawString("Has g2danado",125,350);
        }        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
