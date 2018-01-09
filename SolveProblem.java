package hyperheuristic;




import AbstractClasses.HyperHeuristic;
import AbstractClasses.ProblemDomain;

public class SolveProblem extends HyperHeuristic {

	public SolveProblem(long seed) {
	 super(seed);
	}
	@SuppressWarnings("unused")
	@Override
	protected void solve(ProblemDomain problem) {
		int number_of_heuristics = problem.getNumberOfHeuristics();
		problem.loadInstance(0);
		problem.initialiseSolution(0);
		
		
		while(!hasTimeExpired()) {
			//apply the chosen heuristic to the solution at index 0 in the memory
			//the new solution is then stored at index 1 of the solution memory while we decide whether to accept it
			
			
			int heuristic_to_apply = rng.nextInt(2);
		    problem.applyHeuristic(0, 0, 1);
		    
		    
		    //String bestsoln=problem.bestSolutionToString();
			//System.out.print(bestsoln);
			

			
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "finiding best solution to search";
	}
   
}
