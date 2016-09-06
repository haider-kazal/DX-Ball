package com.Kazal.dx_ball;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity implements OnKeyListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
        g= new GameCanvas(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        g.setOnKeyListener(this);
        g.setFocusableInTouchMode(true);
        g.requestFocus();
        
        setContentView(g);
	}


	public boolean onKey(View view, int keyCode, KeyEvent event) {
    	switch(event.getAction())
    	{
	    	case KeyEvent.ACTION_DOWN:
	    		if(keyCode==KeyEvent.KEYCODE_DPAD_LEFT||keyCode==KeyEvent.KEYCODE_DPAD_RIGHT)
	    		{
	    			g.bar.setBarValue(keyCode);
	    		}
	    		else if(keyCode==KeyEvent.KEYCODE_DPAD_DOWN||keyCode==KeyEvent.KEYCODE_DPAD_UP)
	    		{
	    			//g.chngOption();	    			    	
	    		}	  
	    		else if(keyCode == KeyEvent.KEYCODE_BACK)
	    		{
	    			this.finish();
	    			System.exit(0);	    			
	    		}
	    		break;
	    	case KeyEvent.ACTION_UP:	    	
	    		break;
    	}
    	return true;
	}
	
	@Override
	protected void onResume() 
    {
		super.onResume();
		thread = new Thread(g);
		thread.start();
	}
	
	private GameCanvas g;
	private Thread thread;
}
