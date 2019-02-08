
package puzzle2.pkg0;
import com.sun.javafx.scene.control.skin.ButtonSkin;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
/**
 *
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Puzzle20 extends JFrame{
    public static JPanel p = new JPanel();
    public static Pieza ps[][]= new Pieza[4][4];
    public static  int ConsolaPiezas[][] = new int[4][4];
     
    public static void main(String[] args) {
        int n = 0;
        
        new Puzzle20();
        
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(i*j != 9){
                    ps[i][j].setIcon(Pieza.iconos[n]);
                    ps[i][j].setIndice_actual(n);
                    ps[i][j].setIndice_permanente(n);
                    ConsolaPiezas[i][j]=n;
                    n++;
                }
                else{
                    ps[i][j].setIndice_actual(15);
                    ps[i][j].setIndice_permanente(15);
                    ConsolaPiezas[i][j]=-1;
                }
                
                ps[i][j].addActionListener((ActionListener) ps[i][j]);
            }
        }
        mostrar_por_consola();
    }
    
    public void actionperformed(ActionEvent e){
        System.out.println("ola");
    }
    
    public static void mostrar_por_consola() {
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(ConsolaPiezas[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    
    public Puzzle20(){
        super("rompecabezas");
        setSize(720,720);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(4,4));
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                ps[i][j]= new Pieza();
                p.add(ps[i][j]);
            }
        }
        add(p);
        setVisible(true);
    }

    
    
}
