package interfaz_grafica.mijuego2;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author usuario
 */
public class Raqueta {
    int x,y,longitud,velocidad,incremento,altura = 15,vidas = 3,puntos = 0;
    boolean principio = true;
    private final Canvas canvas;

    public Raqueta(Canvas canvas,int x, int y, int longitud, int velocidad) {       
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.longitud = longitud;
        this.velocidad = velocidad;
    }
    public void update(){
        if(x + incremento > 0 && x +incremento < canvas.getWidth()-longitud){
            x = x + incremento;
        }            
    }
    
    public void KeyReleased(KeyEvent e){        
        incremento = 0;
    }
    
    public void keyPressed(KeyEvent e) {
         
       if(KeyEvent.getKeyText(e.getKeyCode()).equals("Espacio") && principio){
            canvas.pelota.direccionX = -4;
            canvas.pelota.direccionY = -4;
            principio = false;
       }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Derecha")){
            incremento = +velocidad;
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Izquierda")){
            incremento = -velocidad;
        }
    }
    public void draw(Graphics2D g){
        g.fillRect(x, y, longitud, altura);
        g.drawString("vidas: "+Integer.toString(vidas),canvas.getWidth()-70, 20);
        g.drawString("puntos: "+Integer.toString(puntos), 10, 20);
    }    
}
