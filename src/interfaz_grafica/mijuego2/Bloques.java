package interfaz_grafica.mijuego2;

import java.awt.Graphics2D;

/**
 *
 * @author usuario
 */
public class Bloques {
    int x,y,longitud,altura;
    Canvas canvas;

    public Bloques(Canvas canvas,int x, int y, int longitud, int altura) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.longitud = longitud;
        this.altura = altura;
    }
    public void draw(Graphics2D g){       
            g.fillRect(x, y, longitud, altura);
    }
}
