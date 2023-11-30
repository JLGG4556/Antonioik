package interfaz_grafica.mijuego2;


import javax.swing.JFrame;

public class Arkanoid {        
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame("Arkanoid");
        Canvas canvas = new Canvas();
        frame.add(canvas);
        frame.setSize(450, 736);      
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true){
            canvas.update();
            canvas.repaint();
            Thread.sleep(10);
        }  
        
    }
    
    
}
