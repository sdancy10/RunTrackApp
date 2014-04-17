package com.style.runtrackapp;



import java.util.List;

import android.content.Context;

/**
 * 
 */

/**
 * @author Style
 *
 */
public interface IrunInterpreter {

	/**
	 * Retrieve a list of all runs that are stored in the log file.
	 * @param None
	 * @return List of all runs.
	 */
	public List<Run> getRuns();
	
	/**
	 * Retrieve a list of all runs that are stored in the log file.
	 * @param Context class to retrieve resources.
	 * @return List of all runs.
	 */
	public List<Run> getRunsAndroid(Context ctxt);
	
}
