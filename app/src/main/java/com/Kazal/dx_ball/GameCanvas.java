/**
 * 
 */
package com.Kazal.dx_ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

/**
 * @author HaiderAli
 *
 */
public class GameCanvas extends SurfaceView implements Runnable {

	public GameCanvas(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		surfaceHolder = getHolder();
		paint = new Paint();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running) 
		{
			if(!surfaceHolder.getSurface().isValid())
			{
				continue;
			}
			//break;
			Canvas canvas = surfaceHolder.lockCanvas();
			draw(canvas);
			surfaceHolder.unlockCanvasAndPost(canvas);
			if(state != 0)
			{
				return;
			}
		}
		
	}
	
	public void draw(Canvas canvas) 
	{
		canvas.drawRGB(255, 255, 255);
		//Toast.makeText(getContext(), "A", Toast.LENGTH_SHORT).show();

		if(state==1)
		{
			paint.setColor(Color.RED);
			paint.setStyle(Style.FILL);
			canvas.drawText("Game Over", 3 * this.getWidth() / 2, 3 * this.getHeight()/2, paint);
		}
		else if(checkWin())
		{
			paint.setColor(Color.GREEN);
			paint.setStyle(Style.FILL);
			canvas.drawText("You Win", 3 * this.getWidth() / 2, 3 * this.getHeight()/2, paint);
			state=3;
		}
		
		ball.draw(canvas, this);
		bar.draw(canvas, paint);
		bricks = new Brick[25];
		
		int factorWidth = canvas.getWidth() / 5;
		int factorHeight = (int) (canvas.getHeight() * 0.4 / 5);
		//Log.d("FW FH", factorWidth + " " + factorHeight);
		
		int y = 2;
		//if(firstTime)
		//{
			for(int row = 0; row < 5; row++)
			{
				int x = 2;
				for(int column = 0; column < 5; column++)
				{
					bricks[(row * 5) + column] = new Brick(x, y, factorWidth-5, factorHeight-5, "black");
					//Log.d("x y", x +	 " " + y);
					x+=factorWidth;
				}
				y+=factorHeight;
			}
			firstTime = false;
		//}
		
		for(int counter = 0; counter < 25; counter++)
		{
			if(bricks[counter] != null)
				bricks[counter].draw(canvas);
		}		
		
		
	}
	
	public Boolean checkWin()
	{
		/*for(int counter = 0; counter < 25; counter++)
		{
			if(bricks[counter] != null)
			{
				return false;
			}
		}
		/*for(int i=0; i <= 24; i++)
		{
			if(bricks[i] != null)
				return false;
		}*/
		return true;
	}
	
	private SurfaceHolder surfaceHolder;
	private Paint paint;
	
	public Brick[] bricks;
	public Bar bar = new Bar();
	private Ball ball = new Ball();
	
	private volatile boolean running = true;
	private boolean firstTime = true; 
	public int state = 0;
}
