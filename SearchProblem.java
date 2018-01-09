package hyperheuristic;




import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class SearchProblem extends AbstractClasses.ProblemDomain {
  private int [] array;
  private int count=0;
  private int swapused=0;
  private int insertused=0;
  //private boolean sorted=false;
 solution[] s;
 boolean isswapgood=true;
 boolean isinsertgood=true;
 int memorysize;
	public SearchProblem(long seed) {
		
		super(seed);
		
	}
	public void applyheuristic0(int [] array) {
		
		
		Random r=new Random();
		int right=r.nextInt(array.length-1);
		int left=right+1;
		if(compareSolutions(right,left)) {
			isswapgood=true;
			isinsertgood=false;
			int temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			count++;
			s[0].setsoln(array);
			swapused++;
		

	}
		else{
			isswapgood=false;
			isinsertgood=true;
			}
		}
	public void applyheurstic1(int[] array) {
        
		Random r=new Random();
		int a=r.nextInt(array.length);
		
		int b=r.nextInt(array.length);
		
		if(b>a) {
			int temp=b;
			b=a;
			a=temp;
		}
		
		if(compareSolutions(b,a)) {
			count++;
			int temp=array[a];
			for(int i=a;i>b;i--) {
				array[i]=array[i-1];
			}
			array[b]=temp;
			isswapgood=false;
			isinsertgood=true;
			s[0].setsoln(array);
			insertused++;
			
		}
		else {
		isswapgood=true;
		isinsertgood=false;
		     }
		}
	

	@Override
	public double applyHeuristic(int heuristicid, int arg1, int arg2) {
	  if(isswapgood) {
		  applyheuristic0(array);
		  System.out.println("");
		  for(int i=0;i<array.length;i++) {
			  System.out.print(array[i]+"  ");
		  }
	  }
	  else if(isinsertgood) {
		  applyheurstic1(array);
		  for(int i=0;i<array.length;i++) {
			  System.out.print(array[i]+"  ");
		  }
	  }
	  return 1000;
	}
	

	@Override
	public double applyHeuristic(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String bestSolutionToString() {
		int [] bestsoln=s[0].getsoln();
		String s="";
		for(int i=0;i<bestsoln.length;i++) {
			s+=Integer.toString(bestsoln[i])+" ";
		}

		return s;
	}

	@Override
	public boolean compareSolutions(int i, int j) {
		// TODO Auto-generated method stub
		if(array[i]>array[j]) {
			return true;
		}
		return false;
	}

	@Override
	public void copySolution(int i, int j) {
		s[i]=s[j];
		
	}

	@Override
	public double getBestSolutionValue() {
		// forget this
		return Double.POSITIVE_INFINITY;
	}

	@Override
	public double getFunctionValue(int arg0) {
		// forget this
		return 0;
	}

	@Override
	public int[] getHeuristicsOfType(HeuristicType hType) {
	    
	    return null;
	  }
	

	@Override
	
	
	public int[] getHeuristicsThatUseDepthOfSearch() {
		// forget this
		return null;
	}

	@Override
	public int[] getHeuristicsThatUseIntensityOfMutation() {
		// forget this
		return null;
	}

	@Override
	
	
	
	public int getNumberOfHeuristics() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getNumberOfInstances() {
		
		return 4;
	}

	@Override
	public void initialiseSolution(int i) {
		setMemorySize(2);
		s = new solution[memorysize];
		s[0]=new solution(array);
		s[1]=new solution(array);
		if(i==0) {
			applyheuristic0(array);
			
		}
		else {
			applyheurstic1(array);
		}
		
		
	}

	@Override
	public void loadInstance(int instance) {
		File unsortednumbersfile=new File("C://random2");
		if(unsortednumbersfile.exists()) {
			//System.out.print("file is found");
		}
		
		try {
			
			Scanner unsortednumbers=new Scanner(unsortednumbersfile);
			array=new int[10];
			int i=0;
			System.out.println("initial file");
			while(unsortednumbers.hasNext()) {
				
				array[i]=unsortednumbers.nextInt();
				System.out.print(array[i]+" ");
				i++;
				if(i==10) {
					break;
				}
				
			}
                        System.out.println("");
			System.out.println("initial file");
			unsortednumbers.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public void whatweused() {
		System.out.println("swap used: "+swapused+"  times and "+"insert used: "+insertused+" times");
	}
	public File filereader(int instance) {
		File arrayfile;
		if(instance==0) {
			arrayfile=new File("random1");
					return arrayfile;}
		else if(instance==2) {
			arrayfile=new File("random2");
			return arrayfile;
		}
			else if(instance==3) {
				arrayfile=new File("random3");
				return arrayfile;
				
			}
			else {
				arrayfile=new File("random4");
				return arrayfile;
			}
	
		}
	
		
	

	@Override
	public void setMemorySize(int arg0) {
		memorysize=2;
		
	}

	@Override
	public String solutionToString(int arg0) {
		int solnarray[]=s[0].getsoln();
		String s="";
		for(int i=0;i<solnarray.length;i++) {
			s+=Integer.toString(solnarray[i])+" ";
		}
		
		return s;
		}
    public int returncount() {
    	return count;
    }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "search problem";
	}
	public String isSorted() {
		for(int i=0;i<s[0].getsolnsize()-1;i++) {
			if(s[0].getnumber(i)>s[0].getnumber(i+1)) {
			return "not sorted";
			}
			
		}
		return "sorted";
	}
	class solution{
	private int soln[];
	private int solnsize;
	public solution(int []array) {
		soln=new int[array.length];
		solnsize=array.length;
		for(int i=0;i<array.length;i++) {
			soln[i]=array[i];
			
		}
	}
	public int getsolnsize() {
		return solnsize;
	}
	public int []getsoln() {
		return soln;
		
	}
	
		
	
	public int getnumber(int i) {
		return soln[i];
	}
	public void setsoln(int [] newsoln) {
		for(int i=0;i<newsoln.length;i++) {
			soln[i]=newsoln[i];
		}
	}
		
	}
	

}
