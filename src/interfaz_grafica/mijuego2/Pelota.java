package interfaz_grafica.mijuego2;

import java.awt.Graphics2D;

/**
 *
 * @author usuario
 */
public class Pelota {
    private final Canvas canvas;
    int x = 450/2-10;
    int y = 736-160;
    int direccionX = 0;
    int direccionY = 0;
    int radio;
    boolean prueba = true;
    boolean ganado = true;    
    public Pelota(Canvas canvas,int radio) {
        this.canvas = canvas;
        this.radio = radio;
    }
    public void update(){
        if (x + direccionX <= 0)
            direccionX = 4;
        if (x + direccionX > canvas.getWidth() - radio)
            direccionX = -4;
        if(y+direccionY <= 40)
            direccionY =4;
        if ((y + direccionY >= canvas.raqueta.y-radio && y + direccionY <= canvas.raqueta.y-radio+canvas.raqueta.altura) && (x > canvas.raqueta.x && x < canvas.raqueta.x+canvas.raqueta.longitud+20)){ 
            direccionY = -4;
        }
        for (int i = 0; i < canvas.bloque.size(); i++) {            
            if(prueba){
                if((y + direccionY >= canvas.bloque.get(i).y && y + direccionY <= canvas.bloque.get(i).y+canvas.bloque.get(i).altura) && (x > canvas.bloque.get(i).x && x < canvas.bloque.get(i).x+canvas.bloque.get(i).longitud+20)){
                    canvas.bloque.remove(i);
                    canvas.raqueta.puntos += 100;
                    direccionY = 4;
                    prueba = false;
                }
            }
            if(prueba){            
                if ((y + direccionY <= canvas.bloque.get(i).y+canvas.bloque.get(i).altura-radio && y + direccionY >= canvas.bloque.get(i).y-radio) && (x > canvas.bloque.get(i).x && x < canvas.bloque.get(i).x+canvas.bloque.get(i).longitud+20)){ 
                    canvas.bloque.remove(i);
                    canvas.raqueta.puntos += 100;
                    direccionY = -4;
                    prueba = false;                    
                }
            }
            if(prueba){
                if((y+direccionY >=canvas.bloque.get(i).y && y+direccionY <=canvas.bloque.get(i).y+canvas.bloque.get(i).altura) && (x+direccionX>=canvas.bloque.get(i).x-radio && x+direccionX<=canvas.bloque.get(i).x+canvas.bloque.get(i).longitud)){
                    canvas.bloque.remove(i);
                    canvas.raqueta.puntos += 100;                
                    direccionX = -4;
                    prueba = false;                    
                }
            }  
            if(prueba){
                if((y+direccionY >=canvas.bloque.get(i).y && y+direccionY <=canvas.bloque.get(i).y+canvas.bloque.get(i).altura) && (x+direccionX<=canvas.bloque.get(i).x+canvas.bloque.get(i).longitud && x+direccionX>=canvas.bloque.get(i).x)){
                    canvas.bloque.remove(i);
                    canvas.raqueta.puntos += 100;                
                    direccionX = 4;
                    prueba = false;                    
                }
            }
            prueba = true;
        }
        if (y+direccionY >=canvas.getHeight()){
            canvas.raqueta.vidas--;
            x = 450/2-10;
            y = 736-160;
            direccionX = 0;
            direccionY = 0;
            canvas.raqueta.x = canvas.getWidth()/2-canvas.raqueta.longitud/2;
            canvas.raqueta.principio = true;
        }
            
        x = x + direccionX;
        y = y + direccionY;
    }
    public void draw(Graphics2D g){
        if(ganado){        
            g.fillOval(x, y, radio, radio);
        }
    }
    
    
}
