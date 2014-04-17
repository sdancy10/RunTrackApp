package com.style.runtrackapp;



import java.util.ArrayList;
import java.util.List;
import com.androidplot.LineRegion;
import com.androidplot.Plot;
import com.androidplot.ui.AnchorPosition;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.TextOrientationType;
import com.androidplot.ui.widget.TextLabelWidget;
import com.androidplot.util.PixelUtils;
import com.androidplot.xy.*;
import com.androidplot.ui.XLayoutStyle;
import com.androidplot.ui.YLayoutStyle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Style
 *
 */
public class Runs implements Parcelable {
	private List<Run> runs;
	
	/**
	 * creates empty list of Runs
	 */
	Runs () { this.runs = new ArrayList<Run>();}
	
	/**
	 * Fills Runs data structure with information of the runs.
	 * @param List of <Run> with the running data.
	 */
	public Runs (List<Run> runs) { this.runs = runs ;}
	
	/**
	 * Parcelable Constructor
	 */
	public Runs(Parcel in) {
        in.readTypedList(runs, Run.CREATOR);
    }
	/**
	 * 
	 * @return Returns the list of runs with their details.
	 */
	public List<Run> getRuns() { return this.runs; }
	
	/**
	 * @return Gives graphical display of Distance vs Time details of runs
	 */
	/**
	 * @return Gives graphical display of Date vs Time details of runs
	 */
	/**
	 * @return Gives graphical display of Distance vs Date details of runs
	 */
	
	/**
	 * Search's the iterable list of all runs for desired date (MM/DD/YY) and returns the details of the run on provided date.
	 * @param Date
	 * @return The run on desired date.
	 */
	public Run getRun(String date) {
		Run dateRun = new Run();
		for (Run run: runs) {
			if (run.getDate().compareTo(date) == 0){ dateRun = run; }
		}
		return dateRun;
	}
	
	/**
	 * @param List of runs to search through.
	 * @return Fastest run.
	 */
	public Run getFastRun() {
		Run fastRun = new Run();
		int shortHour = 99;
		int shortMin = 99;
		int shortSec = 99;
		String delimiter = ":";
		
		for (Run run: runs) {
			String[] lineTokens = run.getTime().split(delimiter);
			
			int hour = Integer.parseInt(lineTokens[0]);
			int min = Integer.parseInt(lineTokens[1]);
			int seconds = Integer.parseInt(lineTokens[2]);
			
			if (hour <= shortHour) {
				fastRun = run;
				shortHour = hour;
				shortMin = min;
				shortSec = seconds;
			}
			if (min <= shortMin) {
				fastRun = run;
				shortHour = hour;
				shortMin = min;
				shortSec = seconds;
			}
			if ( seconds <= shortSec) {
						fastRun = run;
						shortHour = hour;
						shortMin = min;
						shortSec = seconds;
			}
				
		}
		return fastRun;
	}
	
	/**
	 * @param List of runs to search through.
	 * @return Run with longest distance.
	 */
	public Run getLongRun() {
		Double longest = 0.00;
		Run longestRun = new Run();
		for (Run run : runs) {
			if (run.getDistance() > longest) {
				longest = run.getDistance();
				longestRun = run;				
			}			
		}
		return longestRun;
	}
	
	public Double getTotalDistance() {
		double totalDistance = 0;
		
		for (Run run: runs) {
			totalDistance += run.getDistance();
		}
		
		return (totalDistance*100)/100.0000;
	}
	
	public String getTotalTime() {
		String totalTime = "00:00:00";
		Time timeAdder = new Time();
		for (Run run : runs) {
			if (run.getTime().compareTo("99:99:99") != 0)
			{
			totalTime = timeAdder.addTimes(run.getTime(),totalTime);
			}
		}
		
		return totalTime;
	}
	
	/**
	 * 
	 * @return returns number of runs in log file
	 */
	public int getRunCount() {
		return runs.size();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeTypedList(runs);
		
	}
	public static final Parcelable.Creator<Runs> CREATOR =
            new Parcelable.Creator<Runs>() {

        @Override
        public Runs createFromParcel(Parcel in) {
            return new Runs(in);
        }

        @Override
        public Runs[] newArray(int size) {
            return new Runs[size];
        }
    };
}
