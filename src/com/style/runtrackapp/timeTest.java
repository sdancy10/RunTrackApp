package com.style.runtrackapp;




public class timeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time calc = new Time();
		String result = new String("");
		result = calc.addTimes("01:30:00", "01:30:00");
		//result = calc.addTimes("00:26:14", "00:21:30");
		//result = calc.addTimes(result, "00:37:22");
		//result = calc.addTimes(result, "00:15:00");
		System.out.print(result);

	}

}
