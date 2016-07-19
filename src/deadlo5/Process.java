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
public class Process {

    int processID;
    int Max[];
    int Allocation[];
    int Need [];
    boolean finish;


    Process(int ID, int[] max, int[] alloc){
        this.processID = ID;
        this.Max = max;
        this.Allocation = alloc;
        Need = new int [5];
        finish = false;
    }


    public void successAllocation(int request[]){
        for (int j=0; j<5;j++){
            Allocation[j] = Allocation[j] + request[j];
            Need[j] = Need[j] - request[j];
        }
    }

    public void failAllocation(int request[]){
        for (int j=0; j<5;j++){
            Allocation[j] = Allocation[j] - request[j];
            Need[j] = Need[j] + request[j];
        }
    }

    public void Finish(){
        boolean checkEnd = true;
        for (int i=0;i<5;i++){
           if (Need[i] != 0){ checkEnd = false;
        }

        if (checkEnd){
            for (i=0;i<4;i++){ 
                Allocation[i] = 0;
            finish = true;
            }

            System.out.println("******** Release ********");
            System.out.println("Release process" + processID);
            System.out.println("******** State ********");
        }
    }}

    public int[] returnNeed(){
        return Need;
    }

    public int[] returnAllocation(){
        return Allocation;
    }

    public boolean returnFinish(){
        return finish;
    }

    public void printNeedSet(){
        System.out.print("Process " + processID + " Need: ");
        for(int i=0; i < Max.length; i++){
           System.out.print(Need[i] + " ");
        }
        System.out.println();
    }

    public void printAllocationSet(){
        System.out.print("Process " + processID + " Alloc: ");
        for (int i=0; i < Max.length; i++) {
           System.out.print(Allocation[i] + " ");
        }
        System.out.println();
    }
}

