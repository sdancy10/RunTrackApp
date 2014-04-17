package com.style.runtrackapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewAllRuns extends Activity {
	Context m_context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IrunInterpreter test = new runInterpreter("runninglog");		
		final Runs testRuns = new Runs(test.getRunsAndroid(this));
		
		LayoutParams lparams = new LayoutParams(
				   LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		setContentView(R.layout.activity_all_runs_view);
		LinearLayout m_vwVerticalLayout = (LinearLayout) this.findViewById(R.id.verticalRunLayoutView);
			
		for (final Run run: testRuns.getRuns()) {
			LinearLayout ll = new LinearLayout(this);
			final TextView tv = new TextView(this);
			tv.setLayoutParams(lparams);
			tv.setText(run.getTitle()+"\n");
			tv.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	
			    	Intent intent = new Intent(ViewAllRuns.this, ViewRunDetails.class);
			    	intent.putExtra("run",run);
			        tv.setText("clicked");
			        startActivity(intent);
			    }
			});
			ll.addView(tv);
			m_vwVerticalLayout.addView(ll);
		}		
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
