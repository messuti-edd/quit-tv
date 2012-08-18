package com.edd.qtv;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quit_TVActivity extends Activity {
	
	private Handler hnd;
	private boolean watchingTv = false;
	private TimerTask tTask;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        hnd = new Handler() {
			public void handleMessage(Message msg) {
		        if ( msg.what == 1 ) { // Update counter
		        	TextView counter = (TextView) findViewById(R.id.txtCounter);
    				counter.setText(msg.obj.toString());
		        }
		    }
		};
		
        setContentView(R.layout.main);
    }
    
    public void watchTv(View view) {
    	
    	TextView mssg = (TextView) findViewById(R.id.txtWatchingTV);
    	Button wTv = (Button) findViewById(R.id.btnWatchTv);
    	
    	switch (view.getId()) {
    	case R.id.btnWatchTv:
    		
    		if (!watchingTv) { // NOT watching TV
    			watchingTv = true;
	    		
	    		mssg.setVisibility(View.VISIBLE);
	    		wTv.setText(R.string.quit_tv);
	    		
	    		
	    		tTask = new TimerTask() {
	    			private int secs = 0;
	    			private int mins = 0;
	    			private int hrs = 0;
	    			
	    			public void run() {
	    				if (secs < 60)
	    					secs += 1;
	    				else {
	    					secs = 0;
	    					
	    					if (mins < 60)
	    						mins += 1;
	    					else {
	    						mins = 0;
	    						hrs += 1;
	    					}
	    				}
	    				
	    				Message m = new Message();
	    				m.what = 1;
	    				
	    				String sHrs = String.format("%02d", hrs);
	    				String sMin = String.format("%02d", mins);
	    				String sSecs = String.format("%02d", secs);
	    				
	    				m.obj = sHrs+":"+sMin+":"+sSecs+"/2:00";
	    				
	    				hnd.sendMessage(m);
	    			}
	    		};
	    		
	    		Timer timer = new Timer();
	    	    timer.scheduleAtFixedRate(tTask, 1000, 1000);
    		}
    		else { // IS watching TV
    			watchingTv = false;
    			wTv.setText(R.string.watch_tv);
    			tTask.cancel();
    		}
    		
    		break;
    	}
    }

}