package com.style.runtrackapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class ViewHome extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		setContentView(R.layout.activity_home_screen_view);
		
		Button m_ViewRunsBTN = (Button) this.findViewById(R.id.viewAllRunsBTN);
		m_ViewRunsBTN.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		    	
		    	Intent intent = new Intent(ViewHome.this, ViewAllRuns.class);
		        startActivity(intent);
		    }
		});
		
		Button m_ViewGraphBTN = (Button) this.findViewById(R.id.viewGraphBTN);
		m_ViewGraphBTN.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		    	
		    	Intent intent = new Intent(ViewHome.this, ViewRunGraph.class);
		        startActivity(intent);
		    }
		});
		
		Button m_AddRunBTN = (Button) this.findViewById(R.id.addRunBTN);
		m_AddRunBTN.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		    	
		    	Intent intent = new Intent(ViewHome.this, ViewAddRun.class);
		        startActivity(intent);
		    }
		});
		

		}
	
	/*
	 * Private method to confirm that permisions for File IO are set correctly
	 */
	private void checkExternalMedia(TextView tester){
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
                 // Can read and write the media
                 mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                 // Can only read the media
                 mExternalStorageAvailable = true;
                 mExternalStorageWriteable = false;
        } else {
                 // Can't read or write
                 mExternalStorageAvailable = mExternalStorageWriteable = false;
        }   
        tester.append("\n\nExternal Media: readable="
                       +mExternalStorageAvailable+" writable="+mExternalStorageWriteable);
}
	

}
