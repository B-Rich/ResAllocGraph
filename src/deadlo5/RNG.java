/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlo5;

import java.util.Random;

/**
 *
 * @author Threadcount
 */
public class RNG {

   private Random rand;
   private double seedA;
   private double seedB;
   private long powSeed;
   private int rndmNum;
   private static int mod = 0;
   
   public RNG(double seedA, double seedB){;
       this.rand = new Random();
       this.seedA = seedA;
       this.seedB = seedB;
       this.powSeed = (long) (Math.abs((Math.pow(seedB, seedA) + 1 + (seedA - seedB)) + ((seedB*seedA)/2)));
       this.rndmNum =  rand.nextInt(Math.round(this.powSeed));
   }
   
   public int genNum(){
       mod++;
       return (mod + (this.rndmNum * mod));
   }
   
   public void getPowSeed(){
       //int rndmNum;
       //rndmNum = rand.nextInt(Math.round(this.powSeed));
        System.out.println(this.powSeed);
   }
   
   
}
