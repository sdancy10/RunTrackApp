package com.style.runtrackapp;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ViewRunDetails extends Activity {
	      
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			Run run = getIntent().getParcelableExtra("run");
						
			setContentView(R.layout.activity_run_details_view);
			
			TextView m_Title = (TextView) this.findViewById(R.id.RunTitle);
			TextView m_Distance = (TextView) this.findViewById(R.id.RunDistance);
			TextView m_Time = (TextView) this.findViewById(R.id.RunTime);
			TextView m_Date = (TextView) this.findViewById(R.id.RunDate);
			
			if(run != null){
				m_Title.setText(run.getTitle());
				m_Distance.setText(run.getDistance().toString()+" miles");
				m_Date.setText(run.getDate());
				m_Time.setText(run.getTime());
			}	
			
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
		
}
