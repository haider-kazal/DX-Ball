/**
 * 
 */
package com.Kazal.dx_ball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

/**
 * @author HaiderAli
 *
 */
public class Brick extends DrawerAbstract {

	/* (non-Javadoc)
	 * @see com.Kazal.dx_ball.DrawerAbstract#draw(android.graphics.Canvas)
	 */
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		//Log.d("Brick", "Draw");
		canvas.drawRect(x, y, x1, y1, paint);
	}
	
	public Brick(int x, int y, int width, int height, String colorString)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.x1 = x + width;
		this.y1 = y + height;
		this.color = Color.parseColor(colorString);
		paint = new Paint();
		paint.setColor(this.color);
		paint.setStyle(Style.FILL_AND_STROKE);
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getX1()
	{
		return x1;
	}
	public int getY1()
	{
		return y1;
	}
	public int getWidth()
	{
		return height;
	}
	public int getHeight()
	{
		return width;
	}
	
	private int x = 0, y = 0;
	private int x1 = 0, y1 = 0;
	private int height = 0, width = 0;
	private Paint paint;
	public int color;
}
