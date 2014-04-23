package com.style.runtrackapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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
		Runs testRuns = new Runs(test.getRunsAndroid(this));

		setContentView(R.layout.activity_all_runs_view);
		LinearLayout m_vwVerticalLayout = (LinearLayout) this.findViewById(R.id.verticalRunLayoutView);
        LinearLayout m_runSummaryLayout = (LinearLayout) this.findViewById(R.id.verticalRunsSummary);

        //set Runs Summary information.
        TextView runSummary = new TextView(this);
        runSummary.setText("Total Time Running: " +testRuns.getTotalTime() + "\n" +
                           "Total Distance Ran: " +testRuns.getTotalDistance().toString()+ "miles" + "\n"
        );
        m_runSummaryLayout.addView(runSummary);

        //Set each Button to view details of individual Runs.
		for (final Run run: testRuns.getRuns()) {
			LinearLayout ll = new LinearLayout(this);
            int paddingPixel = 5;
            float density = ViewAllRuns.this.getResources().getDisplayMetrics().density;
            int paddingDp = (int)(paddingPixel * density);
            ll.setPadding(0,0,0,paddingDp);
            ll.setGravity(Gravity.CENTER_VERTICAL);

			final TextView tv = new TextView(this);
            tv.setBackgroundResource(R.drawable.blank_btn);
			tv.setText(run.getTitle()+"\n");
            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
			tv.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	Intent intent = new Intent(ViewAllRuns.this, ViewRunDetails.class);
			    	intent.putExtra("run",run);
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
