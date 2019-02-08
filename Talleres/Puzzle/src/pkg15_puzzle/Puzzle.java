package pkg15_puzzle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.*;

import javax.swing.SwingUtilities;
/**
 *
 * @author Santiago
 */


public class Puzzle extends JPanel{

    private int size; //tamaño de la instancia del juego
    private int numTiles; //numero de cuadros
    private int dimension; //dimension de los cuadros
    private static final Color FOREGROUND_COLOR = new Color(152,255,80); // color
    private int[] tiles; // iniciar los cuadros en un array de enteros
    private int tileSize; //tamaño del cuadro en el UI
    private int blankPos; //posicion del cuadro blanco
    private int margin; //margen de la cuadricula del cuadro
    private int gridSize; //tamaño de la cuadricula del UI
    private boolean GameOver; // True si se acabó el juego.
    private Object RANDOM;
    
    public Puzzle(int size, int dim, int mar){
        this.size = size;
        dimension = dim;
        margin = mar;
        
        // inicialización de los cuadros
        numTiles = size*size - 1; // -1 para dar espacio al cuadro blanco
        tiles = new int[size*size];
        
        //calcular el tamaño de la cuadricula
        gridSize = (dim - 2 * margin); //
        tileSize = gridSize / size;
        
        setPreferredSize(new Dimension(dimension, dimension+margin));
        setBackground(Color.WHITE);
        setForeground(FOREGROUND_COLOR);
        setFont(new Font("SansSerif", Font.BOLD, 60));
        
        GameOver = true;
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                if(GameOver){
                    newGame();
                }else{
                   int ex = e.getX() - margin;
                   int ey = e.getY() - margin;
                   
                   if(ex < 0 || ex > gridSize || ey < 0 || ey > gridSize)
                       return;
                   
                   int c1 = ex / tileSize;
                   int r1 = ey / tileSize;
                   
                   
                   int c2 = blankPos % size;
                   int r2 = blankPos / size;
                   
                   int clickPos = r1*size+c1;
                   
                   int dir = 0;
                   
                   if(c1 == c2 && Math.abs(r1-r2)>0)
                       dir = (r1-r2)>0 ? size : -size;
                   else if(r1==r2 && Math.abs(c1-c2)>0)
                       dir = (c1-c2)>0 ? 1: -1;
                   
                   if(dir != 0){
                       do{
                           int newBlankPos = blankPos + dir;
                           tiles[blankPos] = tiles[newBlankPos];
                           blankPos = newBlankPos;
                       }while(blankPos != clickPos);
                       
                       tiles[blankPos]=0;
                   }
                  
                   GameOver = isSolved(); 
                }
                
                repaint();
            }
        });
        
        newGame();
    }
    
    private void newGame(){
        do{
            reset(); //reinicia el estado inicial
            shuffle(); //desorganiza el puzzle 
        }while(!isSolvable()); //hacer hasta que el puzzle rea resolvible
        
        GameOver = false;
    }
    
    private void reset(){
        for(int i=0;i<tiles.length;i++){
           tiles[i] = (i+1) % tiles.length;
        }
        
        blankPos = tiles.length - 1;
    }
    
    private void shuffle(){
        int n = numTiles;
        
        while(n>1){
            Random randomno = new Random();
            int r = randomno.nextInt(n--);
            int tmp = tiles[r];
            tiles[r] = tiles[n];
            tiles[n] = tmp;
        }
    }
    
    private boolean isSolvable(){
        int CountInversions = 0;
        
        for(int i=0; i< numTiles; i++){
            for(int j=0; j<i; j++){
                if(tiles[j]>tiles[i])
                    CountInversions++;
            }
        }
        //return CountInversions % 2 == 0;
        return true;
    }
    
    private boolean isSolved(){
        //si el cuadro blanco no está en la posicion de resolución
        if(tiles[tiles.length -1] != 0)
            return false;
                    
        for(int i=numTiles-1; i>=0;i--){
            if(tiles[i]!=i+1)
                return false;
        }
        
        return true;
    }
    
    private void drawGrid(Graphics2D g){
        for(int i=0;i<tiles.length;i++){
            int r = i/size;
            int c = i%size;
            
            int x = margin +c*tileSize;
            int y = margin +r*tileSize;
            
            if(tiles[i]==0){
                if(GameOver){
                    g.setColor(FOREGROUND_COLOR);
                    drawCenteredString(g, "✓",x,y);
                }
                
                continue;
            }
            
            g.setColor(getForeground());
            g.fillRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.WHITE);
            
            drawCenteredString(g, String.valueOf(tiles[i]), x, y);
    }
}
    private void drawStartMessage(Graphics2D g){
        if(GameOver){
            g.setFont(getFont().deriveFont(Font.BOLD,18));
            g.setColor(FOREGROUND_COLOR);
            String s = "Click to start new game";
            g.drawString(s,(getWidth()-g.getFontMetrics().stringWidth(s))/2, 
                    getHeight()-margin);
        }
    }
    
    private void drawCenteredString(Graphics2D g, String s, int x, int y){
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int desc = fm.getDescent();
        g.drawString(s, x+(tileSize -fm.stringWidth(s))/2, 
                y+(tileSize - (asc-desc)/2));
    }
   
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2D);
        drawStartMessage(g2D);   
    }
    
    public static void main(String[] ar){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("15 puzzle");
            frame.setResizable(false);
            frame.add(new Puzzle(4, 550, 30), BorderLayout.CENTER);
            frame.pack();
            
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}