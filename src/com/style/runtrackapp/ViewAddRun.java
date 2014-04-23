package com.style.runtrackapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

                EditText m_title = (EditText) ViewAddRun.this.findViewById(R.id.titleINPUT);
                EditText m_date = (EditText) ViewAddRun.this.findViewById(R.id.dateINPUT);
                EditText m_distance = (EditText) ViewAddRun.this.findViewById(R.id.distanceINPUT);
                EditText m_time = (EditText) ViewAddRun.this.findViewById(R.id.timeINPUT);

                try {
                    String fileName = "runninglog";
		        	fos = openFileOutput(fileName, Context.MODE_APPEND);

		        	out = new PrintWriter(new BufferedWriter(
		                              new OutputStreamWriter(fos, "UTF-8")),true);
		            out.println(m_title.getText() +" - " + m_date.getText() + " - "+ m_distance.getText() + " - " + m_time.getText());

                    Toast.makeText(ViewAddRun.this,"Run: " + m_title.getText() + " Added",Toast.LENGTH_SHORT).show();
                    out.flush();
		            out.close();
		        }
		        catch (final Exception e) {
                    Toast.makeText(ViewAddRun.this,"Exception",Toast.LENGTH_LONG).show();
		        	System.err.println("Exception: Unable to write log to file.");
		        	e.printStackTrace();
		        }
		        finally {
		        	if (fos != null) {
		        		try {
		        			fos.close();
		        		}
		        		catch (final IOException e) {
                            Toast.makeText(ViewAddRun.this,"IOException",Toast.LENGTH_LONG).show();
		        			System.err.println("IOException: Unable to write log to file.");
		        			e.printStackTrace();
		        		}
		        	}
		        }
		    }
		});
	}

}
