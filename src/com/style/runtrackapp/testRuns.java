package com.style.runtrackapp;





/**
 * @author Style
 * Class to test the interpreter to make sure it is correctly grabbing information.
 */
public class testRuns {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IrunInterpreter test = new runInterpreter("runningLog.data");
		Runs testRuns = new Runs(test.getRuns());
		
		for (Run run : testRuns.getRuns()) {
			System.out.print(run.toString());
			System.out.print("\n\n");
		    }
		System.out.print("Total Time Ran: ");
		System.out.print(testRuns.getTotalTime()+"\n--------\n");
		System.out.print("Total Distance Ran: ");
		System.out.print(testRuns.getTotalDistance()+"\n--------\n");
		System.out.print("Longest Distance Ran: ");
		System.out.print(testRuns.getLongRun()+"\n--------\n");
		System.out.print("Fastest Run: ");
		System.out.print(testRuns.getFastRun()+"\n--------\n");
		//System.out.print(testRuns.getAverageTime()+"\n--------\n");
		/*for(Iterator<Run> i = testRuns.iterator(); i.hasNext(); ) {
			  Run item = i.next();
			  System.out.println("\n--------\n"+ item.getTitle());
			}*/
	}

}
