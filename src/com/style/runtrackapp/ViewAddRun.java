package com.style.runtrackapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewAddRun extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context m_ctxt = ViewAddRun.this;
		setContentView(R.layout.activity_add_run_view);
		TextView m_AddRunsBTN = (TextView) this.findViewById(R.id.addRunDetailBTN);
		m_AddRunsBTN.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {	
		    	PrintWriter out = null;
                File file = null;
		        FileOutputStream fos = null;
		        try {
		        	
		        	fos = openFileOutput("runningLog", Context.MODE_APPEND);

		        	out = new PrintWriter(new BufferedWriter(
		                              new OutputStreamWriter(fos, "UTF-8")));        
		            out.println("Run 999 - 09/09/09 - 4.589 - 00:00:00/n");

		            out.flush();
		            out.close();
		        }
		        catch (final Exception e) {
		        	System.err.println("Exception: Unable to write log to file.");
		        	e.printStackTrace();
		        }
		        finally {
		        	if (fos != null) {
		        		try {
		        			fos.close();
		        		}
		        		catch (final IOException e) {
		        			System.err.println("IOException: Unable to write log to file.");
		        			e.printStackTrace();
		        		}
		        	}
		        }
		    }
		});
	}

}
