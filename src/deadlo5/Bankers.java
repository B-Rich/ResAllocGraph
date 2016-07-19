import deadlo5.RNG;
import java.util.Scanner;

public class Bankers{
    private int Need[][];
    private int Allocate[][];
    private int Max[][];       
    private int Available[][];
    private int numOfPros;
    private int numOfResrs;
    private int cntr = 0;
    
    private void getProcessData(){
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter number of Processes : ");
    	numOfPros=sc.nextInt();  //no. of process
        System.out.print("Enter number of Resources : ");
    	numOfResrs=sc.nextInt();  //no. of resources
    	Need=new int[numOfPros][numOfResrs];  //initializing arrays
    	Max=new int[numOfPros][numOfResrs];
    	Allocate=new int[numOfPros][numOfResrs];
    	Available=new int[1][numOfResrs];
    	
    	System.out.println("\n" +"Matrices created successfully." +"\n");
        
    	for(int i=0;i<numOfPros;i++){
          for(int j=0;j<numOfResrs;j++){
            System.out.println("For the Process P"+i+ ", Enter the allocated value of the Resource R"+j);
    	    Allocate[i][j]=sc.nextInt();  //Allocation matrix
          }
          System.out.println("\n" +"Resources succefully allocated for process P"+i + "\n");
        }
    		
    	System.out.println("\n" + "Allocation matrix set successfully." + "\n");
        
        for(int i=0;i<numOfPros;i++){
          for(int j=0;j<numOfResrs;j++){
            System.out.println("For the Process P"+i+ ", Enter the maximum value of the Resource R"+j +" that is needed");
    	    Max[i][j]=sc.nextInt();  //Max matrix
          }
          System.out.println("\n" +"Maximum number of resources succefully set for process P"+i + "\n");
        }

        System.out.println("\n" + "Max matrix set successfully." + "\n");
        
        for(int j=0;j<numOfResrs;j++){
            System.out.println("For the Resource R"+j+ ", Enter the available value");
    	    Available[0][j]=sc.nextInt();  //Availableable matrix
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

    public void isSafe(){
       getProcessData();
       getNeed();
       boolean procComp[]=new boolean[numOfPros];
       int j=0;

       while(j<numOfPros){  //until all process Allocated
	      boolean Allocated=false;
    	  for(int i=0;i<numOfPros;i++)
     		 if(!procComp[i] && canAllocate(i)){  //trying to Allocate
	           for(int k=0;k<numOfResrs;k++)
		          Available[0][k]=Available[0][k]-Need[i][k]+Max[i][k];
		       System.out.println("Allocated process : "+i);
		       Allocated=procComp[i]=true;
               j++;
             }
          if(!Allocated) break;  //if no allocation
	   }
       if(j==numOfPros)  //if all processes are Allocated
	       System.out.println("\nSafely Allocated");
       else
    	   System.out.println("All proceess cant be Allocated safely");
    }
    
    public static void main(String[] args) {
		new Bankers().isSafe();
	}
}