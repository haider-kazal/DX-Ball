/**
 * 
 */
package com.Kazal.dx_ball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

/**
 * @author HaiderAli
 *
 */
public class Ball extends DrawerAbstract {

	/* (non-Javadoc)
	 * @see com.Kazal.dx_ball.DrawerAbstract#draw(android.graphics.Canvas)
	 */
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub

	}

	int x=0,y=0;
	boolean firstTime=true,isRight=true,isDown=true;
	int dx=6,dy=6,ddx=0,r=10,gameState=0;
	Canvas canvas;
	GameCanvas gameCanvas;
	Paint paint;
			
	public int calculateNextPos()
	{
		x+=dx+ddx;
		y+=dy;
		if(x>canvas.getWidth()-r)
			x=canvas.getWidth()-r;
		else if(x<r)
			x=r;
		
		if(y<r)
			y=r;
		return gameState;
	}
	private void checkBound()
	{
		if(x+dx+ddx>canvas.getWidth()-r)
		{ 
			dx=-dx;
			ddx=-ddx;
			isRight=false;
		}
		else if(x+dx+ddx<r)
		{
			dx=-dx;
			ddx=-ddx;
			isRight=true;
		}
		
		if(y+dy<r)
		{
			dy=-dy;
			isDown=true;
		}
		else if(y+dy>canvas.getHeight()-r)
		{
			gameState=1;
		}		
	}
	private void checkBar()
	{
		if(y+dy>=canvas.getHeight()-r-gameCanvas.bar.height && y<canvas.getHeight())
		{
			 
			if(x>=gameCanvas.bar.x+(gameCanvas.bar.width / 3)&&x<=gameCanvas.bar.x1-(gameCanvas.bar.width/3))//mid
			{
				dy=-dy;
				ddx=0;
			}
			else if(x>=gameCanvas.bar.x+(2*gameCanvas.bar.width/3)&&x<=gameCanvas.bar.x1)//right
			{
				dy=-dy;
				ddx=2;
			}
			else if(x>=gameCanvas.bar.x&&x<=gameCanvas.bar.x1-(2*gameCanvas.bar.width/3))//left
			{
				dy=-dy;
				ddx=-2;
			}
			else if(x+r>=gameCanvas.bar.x&&x+r<=gameCanvas.bar.x1)//right side
			{
				dy=-dy;
				ddx=4;
			}
			else if(x+r>=gameCanvas.bar.x&&x+r<=gameCanvas.bar.x1)//left side
			{
				dy=-dy;
				ddx=-4;
			}
			isDown=false;
		}
		else if(y>=canvas.getHeight())
		{
			gameState=1;
		}
	}
	protected void checkBrick()
	{
		Boolean hitOnce=false;
		for(int i=0; i<25; i++)
		{
			/*if(gameCanvas.bricks[i]==null)
			{
				continue;
			}*/
			/*int closestX = this.x;
			int closestY = this.y;
			
			if(this.x > gameCanvas.bricks[i].getX1())
			{
				closestX=gameCanvas.bricks[i].getX1();
			}
			else if(this.x <gameCanvas.bricks[i].getX1()-gameCanvas.bricks[i].getWidth())
			{
				closestX=gameCanvas.bricks[i].getX1()-gameCanvas.bricks[i].getWidth();
			}
			
			if(y>gameCanvas.bricks[i].getY1())
			{
				closestY=gameCanvas.bricks[i].getY1();
			}
			else if(y<gameCanvas.bricks[i].getY1()-gameCanvas.bricks[i].getHeight())
			{
				closestY=gameCanvas.bricks[i].getY1()-gameCanvas.bricks[i].getHeight();
			}*/
			
			/*if((closestX-x)*(closestX-x)+(closestY-y)*(closestY-y)<=(r*r))
			{	
				if(gameCanvas.bricks[i].color == Color.parseColor("blue"))
				{
					gameCanvas.bricks[i] = new Brick(gameCanvas.bricks[i].getX(), gameCanvas.bricks[i].getY(), gameCanvas.bricks[i].getWidth(), gameCanvas.bricks[i].getHeight(), "black");
					if(!hitOnce)
					{
						//Fixed ball points
						if(x>=gameCanvas.bricks[i].getX()&&x<=gameCanvas.bricks[i].getX()+gameCanvas.bricks[i].getWidth())
						{
							if(isDown)
							{
								isDown=false;
								dy=-dy;
								y=closestY-r;
							}
							else
							{
								isDown=true;
								dy=-dy;
								y=closestY+r;
							}
						}
						else
						{
							if(y<gameCanvas.bricks[i].getY())
							{
								if(isDown)
								{
									isDown=false;
									dy=-dy;
									y=gameCanvas.bricks[i].getY()-r;
								}
								else
								{
									isDown=true;
									dy=-dy;
									y=gameCanvas.bricks[i].getY()-r;
								}
							}
							else if(y>gameCanvas.bricks[i].getY()+gameCanvas.bricks[i].getHeight())
							{
								if(isDown)
								{
									isDown=false;
									dy=-dy;
									y=gameCanvas.bricks[i].getY()+gameCanvas.bricks[i].getHeight()+r;
								}
								else
								{
									isDown=true;
									dy=-dy;
									y=gameCanvas.bricks[i].getY()+gameCanvas.bricks[i].getHeight()+r;
								}
							}
						}
						
						if(y>=gameCanvas.bricks[i].getY()&&y<=gameCanvas.bricks[i].getY()+gameCanvas.bricks[i].getHeight())
						{
							if(isRight)
							{
								isRight=false;
								dx=-dx;
								x=closestX-r;
							}
							else
							{
								isRight=true;
								dx=-dx;
								x=closestX+r;
							}
						}
						else
						{
							if(x<gameCanvas.bricks[i].getX())
							{
								if(isRight)
								{
									isRight=false;
									dx=-dx;
									x=gameCanvas.bricks[i].getX()-r;
								}
								else
								{
									isRight=true;
									dx=-dx;
									x=gameCanvas.bricks[i].getX()-r;
								}
							}
							else if(x>gameCanvas.bricks[i].getX()+gameCanvas.bricks[i].getWidth())
							{
								if(isRight)
								{
									isRight=false;
									dx=-dx;
									x=gameCanvas.bricks[i].getX()+gameCanvas.bricks[i].getWidth()+r;
								}
								else
								{
									isRight=true;
									dx=-dx;
									x=gameCanvas.bricks[i].getX()+gameCanvas.bricks[i].getWidth()+r;
								}
							}
						}
						hitOnce=true;
					}
				} 
				else
				{
					gameCanvas.bricks[i]=null;
				} 
			}*/
		}
	}
	public void draw(Canvas canvas,GameCanvas gameCanvas)
	{
		this.canvas=canvas;
		this.gameCanvas=gameCanvas;
		if(firstTime)
		{
			firstTime=false;
			x=canvas.getWidth() / 2;
			y=canvas.getHeight() / 2;
		}
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(x,y,r, paint);

		checkBar();
		checkBound();
		checkBrick();
		this.gameCanvas.state = calculateNextPos();
	}
	public Ball() 
	{
		paint= new Paint();
	}
}
