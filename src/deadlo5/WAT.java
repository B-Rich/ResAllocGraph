/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlo5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Threadcount
 */
public class WAT extends JPanel{
   private JButton ResBttn;
   private JButton ProcBttn;
   private Graphics2D grphc;
   ArrayList <Rectangle> process;
   ArrayList <Rectangle> resources;
   
   public WAT(){
        ResBttn = new JButton();
        ResBttn.setText("Resource");
        ResBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resources.add(new Rectangle(300,300,40,40));
                repaint();
            }
        });
        ResBttn.setVisible(true);
        
        ProcBttn = new JButton();
        ProcBttn.setText("Process");
        ProcBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                process.add(new Rectangle(300,300,40,40));
                repaint();
            }
        });
        ProcBttn.setVisible(true);

       addMouseListener(new MouseAdapter(){
       });
   }
   
   public void paint(Graphics g){
       Graphics2D grphcs = (Graphics2D) g;
       drawProcess(grphcs, WIDTH, WIDTH);
       drawResources(grphcs, WIDTH, WIDTH);
       drawConnector(grphcs, WIDTH, WIDTH);
   }
   
   public void drawProcess(Graphics2D grphcs, int i, int j) {
        grphcs.drawRect(300, 300, 40, 40);
    }
   
   public void drawResources(Graphics2D grphcs, int i, int j) {
        grphcs.drawOval(300, 300, 40, 40);
    }
   
   public void drawConnector(Graphics2D grphcs, int i, int j) {
        grphcs.drawLine(300, 300, 40, 40);
    }
   
   public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Bricks and Balls");
        WAT wat = new WAT();
        frame.add(wat);
        frame.setBackground(Color.BLACK);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        //AePlayWave aw = new AePlayWave("E:\\mario_01.wav");
        //aw.start();

        while (true) {
//            game.draw();
            wat.repaint();
            Thread.sleep(10);
        }
    }
    
}


