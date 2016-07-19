package deadlo5;

/**
 *
 * @author Threadcount
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Tiles {


    private static final int pos = 480;
    private static final int w = 60;
    private static final int h = 10;
    private double x;
    private double y;
    private BufferedImage b;
    private boolean shouldRemove = false;
    private static int tlCnt = 0;

    
    public Tiles(double x, double y) {
        this.x = x;
        this.y = y;
        tlCnt++;
    }
    



    public void drawa(Graphics2D grphcs, int i, int j) {
        try {
            b = ImageIO.read(getClass().getResourceAsStream("/Resources/Tiles1.png"));
        } catch (Exception excptn) {
            excptn.printStackTrace();
        }
        if(this.shouldRemove == false)
        grphcs.drawImage(b, i, j, null);
    }

    public void drawProcess(Graphics2D grphcs, int i, int j) {
        grphcs.drawRect(300, 300, 40, 40);
    }

    public void drawc(Graphics2D grphcs, int i, int j) {
        try {
            b = ImageIO.read(getClass().getResourceAsStream("/Resources/Tiles3.png"));
        } catch (Exception excptn) {
            excptn.printStackTrace();
        }
        if(this.shouldRemove == false)
        grphcs.drawImage(b, i, j, null);
    }

    public void drawd(Graphics2D grphcs, int i, int j) {
        try {
            b = ImageIO.read(getClass().getResourceAsStream("/Resources/Tiles4.png"));
        } catch (Exception excptn) {
            excptn.printStackTrace();
        }
        if(this.shouldRemove == false)
        grphcs.drawImage(b, i, j, null);
    }

    public void drawe(Graphics2D grphcs, int i, int j) {
        try {
            b = ImageIO.read(getClass().getResourceAsStream("/Resources/Tiles5.png"));
        } catch (Exception excptn) {
            excptn.printStackTrace();
        }
        if(this.shouldRemove == false)
        grphcs.drawImage(b, i, j, null);
    }

    public void drawf(Graphics2D grphcs, int i, int j) {
        try {
            b = ImageIO.read(getClass().getResourceAsStream("/Resources/Tiles6.png"));
        } catch (Exception excptn) {
            excptn.printStackTrace();
        }
        if(this.shouldRemove == false)
        grphcs.drawImage(b, i, j, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)this.getX(),(int)this.getY(), w, h);
    }

    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void shouldRemove(){
        this.shouldRemove = true;
        tlCnt--;
    }
    
    public static int getTileCount(){
        return tlCnt;
    }
}
    
