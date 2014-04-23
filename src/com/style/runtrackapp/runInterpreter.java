package com.style.runtrackapp;



import java.util.ArrayList;
import java.util.List;
import java.io.*;
import android.widget.Toast;
import android.util.Log;
import android.content.Context;

/**
 * 
 */

/**
 * @author Style
 *
 */
public class runInterpreter implements IrunInterpreter {

	private String fileName;
	/**
	 * @param Sets the name of the log file to "runLog.data" by default
	 */
	runInterpreter() { this.fileName = "runLog.data"; }
	
	/**
	 * @param String that contains the name of the run log file
	 */
	public runInterpreter(String fileName) { this.fileName = fileName; }
	
	@Override
	public List<Run> getRuns() {
		List<Run> runs = new ArrayList<Run>();
		try {
			BufferedReader data = new BufferedReader (new FileReader(fileName));
			
			String runData;
			while ((runData = data.readLine()) != null){
			String delimiter = " - ";
			//Line Tokens should contain 0 - Title, 1 - Date, 2 - distance, 3 - time
			String[] lineTokens = runData.split(delimiter);
			
			Run run = new Run();
			run.setTitle(lineTokens[0]);
			run.setDate(lineTokens[1]);
			run.setDistance(Double.parseDouble(lineTokens[2]));
			run.setTime(lineTokens[3]);
			
			runs.add(run);
			}
			data.close();
			
		} catch (IOException e) {
			System.out.print("Sorry but, '" + fileName + "' could not be found.");
			e.printStackTrace();
		}
		
		return runs;
	}
	public List<Run> getRunsAndroid(Context ctxt){
        List<Run> runs = new ArrayList<Run>();

        File f = ctxt.getFileStreamPath(this.fileName);
        boolean exists = f.exists();

        if (!exists) { //IF no load file
            Log.w("fileExistance", "No File named " + this.fileName + " Now Creating...");
            try {
                InputStream is = ctxt.getResources().openRawResource(R.raw.runninglog);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader data = new BufferedReader(isr, 8192);

                FileOutputStream fos = ctxt.openFileOutput(this.fileName, Context.MODE_APPEND);
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(fos, "UTF-8")),true);

                String runLine;
                while ((runLine = data.readLine()) != null)
                {
                    String temp = runLine;
                    out.println(runLine);

                    String delimiter = " - ";
                    //Line Tokens should contain 0 - Title, 1 - Date, 2 - distance, 3 - time
                    String[] lineTokens = temp.split(delimiter);

                    Run run = new Run();
                    run.setTitle(lineTokens[0]);
                    run.setDate(lineTokens[1]);
                    run.setDistance(Double.parseDouble(lineTokens[2]));
                    run.setTime(lineTokens[3]);

                    runs.add(run);
                }
                isr.close();
                is.close();
                data.close();
                fos.close();
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.w("RunsSize",""+runs.size());
            return runs;
        }
        else { //Open File & Begin populating runs.
            Log.w("fileExistance", "File Found Named: " + this.fileName);
            runs = addDataToRuns(ctxt);
            return runs;
        }
}
	
private List<Run> addDataToRuns(Context ctxt){
    List<Run> runs = new ArrayList<Run>();
    try {
        FileInputStream fis = ctxt.openFileInput(this.fileName);
        InputStreamReader isr1 = new InputStreamReader(fis);
        BufferedReader br1 = new BufferedReader(isr1,8192);

        String runData;
        while ((runData = br1.readLine()) != null){
            String delimiter = " - ";
            //Line Tokens should contain 0 - Title, 1 - Date, 2 - distance, 3 - time
            String[] lineTokens = runData.split(delimiter);

            Run run = new Run();
            run.setTitle(lineTokens[0]);
            run.setDate(lineTokens[1]);
            run.setDistance(Double.parseDouble(lineTokens[2]));
            run.setTime(lineTokens[3]);

            runs.add(run);
        }
        fis.close();
        isr1.close();
        br1.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return runs;
}
}
