/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlo5;

/**
 *
 * @author Threadcount
 */
public class Gimmiejester implements Runnable {
    int Available[] = new int [5];
    int Max[][] = new int[5][5];
    int Allocation [][] = new int [5][5];
    int Need[] = new int[5];
    int animationSpeed;
    int flagList[] = new int[5];
    int Processes;
    public Thread thread;
    
    public void run(){}
    
    Process processList[];
    
    public Gimmiejester(int[] avail, int[][] max, int[][] alloc, int[] need){
        this.Available = avail;
        this.Max = max;
        this.Allocation = alloc;
        this.Need = need;
        thread = new Thread(this,"Gimmiejester");
        thread.start();
    }
}
