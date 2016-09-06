/**
 * 
 */
package com.Kazal.dx_ball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.KeyEvent;

/**
 * @author HaiderAli
 *
 */
public class Bar extends DrawerAbstract {

	/* (non-Javadoc)
	 * @see com.Kazal.dx_ball.DrawerAbstract#draw(android.graphics.Canvas)
	 */
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub

	}
	
	public void draw(Canvas canvas, Paint paint)
	{
		this.maxWidth = canvas.getWidth();
		this.width = canvas.getWidth() / 5;
		this.height = (int) (canvas.getHeight() * 0.4 / 5);;
		
		if(firstTime)
		{
			firstTime=false;
			x = (int) 2 * canvas.getWidth() / 5; 
			x1 = (int) 4 * canvas.getWidth() / 5;
		}
		
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.FILL);
		canvas.drawRect(x, canvas.getHeight() - height, x1, canvas.getHeight(), paint);
	}
	
	public void setBarValue(int keyCode)
	{
		if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
		{
			Log.d("Left", "Here");
			int bl=10;
			if(x < bl)
				bl = x;
			x -= bl; 
			x1 -= bl;
		}
		else if(keyCode==KeyEvent.KEYCODE_DPAD_RIGHT)
		{
			Log.d("Right", "Here");
			int bl=10;
			if(x1 + bl > maxWidth)
				bl = maxWidth - x1;
			x += bl;
			x1 += bl;
		}
	}

	public int x, x1, height, width; 
	private int maxWidth;
	private boolean firstTime = true;
}
