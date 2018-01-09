/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperheuristic;

import AbstractClasses.ProblemDomain;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[]  args){
        ProblemDomain problem = new SearchProblem(0);
        //boolean satisfiability problem(satisfability)
		//creates an ExampleHyperHeuristic object with a seed for the random number generator
		SolveProblem hyper_heuristic_object = new SolveProblem(0);
		
		problem.loadInstance(2);

		//we must set the time limit for the hyper-heuristic in milliseconds, in this example we set the time limit to 1 minute
		hyper_heuristic_object.setTimeLimit(10000);

		//a key step is to assign the ProblemDomain object to the HyperHeuristic object. 
		//However, this should be done after the instance has been loaded, and after the time limit has been set
		hyper_heuristic_object.loadProblemDomain(problem);

		
		hyper_heuristic_object.run();
		
		
		
		
    }
    
}
