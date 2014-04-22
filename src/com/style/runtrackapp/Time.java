package com.style.runtrackapp;



/**
 * 
 */

/**
 * @author Style
 *
 */
public class Time {
	public String addTimes(String time1, String time2) {
		String totalTime;
		int hour1 = 0, hour2 =0, min1 = 0, min2 = 0, sec1 = 0, sec2 = 0;
		String delimiter = ":";
		
		String[] intTime1 = time1.split(delimiter);
		String[] intTime2 = time2.split(delimiter);
		
		hour1 = Integer.parseInt(intTime1[0]);
		hour2 = Integer.parseInt(intTime2[0]);
		min1 = Integer.parseInt(intTime1[1]);
		min2 = Integer.parseInt(intTime2[1]);
		sec1 = Integer.parseInt(intTime1[2]);
		sec2 = Integer.parseInt(intTime2[2]);
		
		int totalsec = sec1 + sec2;
		int totalmin = min1 + min2;
		int totalhour = hour1 + hour2;
		
		if (totalsec % 60 < 60 && totalsec >= 60) { // dont need to add a minute
			totalmin++;	
			totalsec =  (totalsec % 60);
		}
		if (totalmin % 60 < 60 && totalmin >= 60) {
			totalhour++;
			totalmin = (totalmin % 60);
		}
		String sHour,sMin,sSec;
        if(totalhour < 10) {
            sHour = "0" + totalhour;
        }
        else {
            sHour = "" + totalhour;
        }
        if(totalmin < 10) {
            sMin = "0" + totalmin;
        }
        else {
            sMin = "" + totalmin;
        }
        if(totalsec < 10) {
            sSec = "0" + totalsec;
        }
        else {
            sSec = "" + totalsec;
        }
		totalTime = sHour+":"+sMin+":"+sSec;
		return totalTime;
	}

}
