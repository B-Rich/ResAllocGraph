/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlo5;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.Stack;
/**
 *
 * @author Threadcount
 */

public class Deadlo5{
    private int Need[][];
    private int Allocate[][];
    private int Max[][];       
    private int Available[][];
    private int numOfPros;
    private int numOfResrs;
    private Random rand;
    private RNG RNG_A;
    
    private void getProcessData(){
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter number of Processes : ");
    	numOfPros=sc.nextInt();  //no. of process
        System.out.print("Enter number of Resources : ");
    	numOfResrs=sc.nextInt();  //no. of resources
        RNG_A = new RNG(numOfPros,numOfResrs);
        rand = new Random();
        RNG_A.getPowSeed();
    	Need=new int[numOfPros][numOfResrs];  //initializing arrays
    	Max=new int[numOfPros][numOfResrs];
    	Allocate=new int[numOfPros][numOfResrs];
    	Available=new int[1][numOfResrs];
    	
    	System.out.println("\n" +"Matrices created successfully." +"\n");
        
    	for(int i=0;i<numOfPros;i++){
          for(int j=0;j<numOfResrs;j++){  
            int modRand = (int) Math.abs(Math.round(Math.pow(2,rand.nextInt(7))*RNG_A.genNum()));
            System.out.println(modRand);
    	    Allocate[i][j]= Math.abs(modRand * (i+j+1));  //Allocation matrix
          }
          System.out.println("\n" +"Resources succefully allocated for process P"+i + "\n");
        }	
    	System.out.println("\n" + "Allocation matrix set successfully." + "\n");
        
        
        for(int i=0;i<numOfPros;i++){
          for(int j=0;j<numOfResrs;j++){
              int modRand = (int) Math.abs(Math.round(Math.pow(2,rand.nextInt(7))*RNG_A.genNum())); 
    	    Max[i][j]= Math.abs(modRand * (i+j+1));  //Max matrix
          }
          System.out.println("\n" +"Maximum number of resources succefully set for process P"+i + "\n");
        }
        System.out.println("\n" + "Max matrix set successfully." + "\n");
        
        
        for(int j=0;j<numOfResrs;j++){
            int modRand;
            if(RNG_A.genNum() % 2 == 0){
               modRand =(int) Math.abs(RNG_A.genNum() - (2 * RNG_A.genNum()));  //Availableable matrix
            }else{
               modRand =(int) Math.abs(Math.round(Math.pow(2,rand.nextInt(7))*RNG_A.genNum()));
            }
             Available[0][j]= Math.abs(modRand * (j+1));
        }
        System.out.println("\n" +"Available number of resources succefully set." + "\n");
        
        sc.close();
    }
    
    private int[][] getNeed(){
       for(int i=0;i<numOfPros;i++)
         for(int j=0;j<numOfResrs;j++)  //calculating Need matrix
	         Need[i][j]=Max[i][j]-Allocate[i][j];
       
       return Need;
    }
	
    private boolean canAllocate(int i){
       //checking if all resources for ith process can be allocated
       for(int j=0;j<numOfResrs;j++)
	      if(Available[0][j]<Need[i][j])
	         return false;
		 
	   return true;
    }

    public void printBankMats(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < 0) {
                    System.out.print(a[i][j] * -1 + " ");
                } else {
                    System.out.print(a[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void isSafe() {
        getProcessData();
        getNeed();
        boolean procComp[] = new boolean[numOfPros];
        int j = 0;
        Stack<String> doneProcesses = new Stack();
        Stack<String> allProcesses = new Stack();
        while (j < numOfPros) {  //until all process Allocated
            boolean Allocated = false;
            for (int i = 0; i < numOfPros; i++) {
                if (!procComp[i] && canAllocate(i)) {  //trying to Allocate
                    String tmp = "P" + i;
                    allProcesses.push(tmp);
                    for (int k = 0; k < numOfResrs; k++) {
                        Available[0][k] = Available[0][k] - Need[i][k] + Max[i][k];
                    }
                    System.out.println("Allocated resources : ");
                    printBankMats(Allocate);
                    System.out.println();
                    System.out.println("Available resources : ");
                    printBankMats(Available);
                    System.out.println();
                    System.out.println("Maximum requested resources : ");
                    printBankMats(Max);
                    System.out.println();
                    System.out.println("Needed resources : ");
                    printBankMats(Need);
                    System.out.println();
                    System.out.println("Allocated process : P" + i);
                    System.out.println("-----------------------------" + "\n");
                    doneProcesses.push("P" + i);
                    String dlP = allProcesses.pop();
                    /*if(doneProcesses.contains(dlP)){
                        System.out.println("Process " + dlP + " cannot find sufficent resoruces");
                    }*/
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    Allocated = procComp[i] = true;
                    j++;
                }
            }

            if (!Allocated) {
                break;  //if no allocation
            }
        }
        if (j == numOfPros) {  //if all processes are Allocated
            System.out.println("\nSafely Allocated");
        } else {
            System.out.println("Insufficent resources for process execution");
            System.out.println("SYSTEM DEADLOCKED!!!");
        }
    }
    
    public static void main(String[] args) {
		new Deadlo5().isSafe();
	}
}
