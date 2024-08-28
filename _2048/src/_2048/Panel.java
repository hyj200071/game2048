package _2048;

import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

public class Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	private static Panel panel=new Panel();
	
	private Panel()
	{
		setBackground(Color.white);
	}
	public static Panel getInstance()
	{
		return panel;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
	
		for(int i=0;i<Game.row;i++)
		{
			for(int u=0;u<Game.col;u++)
			{
				int dx=Game.startX+Game.border*(u+1)+Game.length*u;
				int dy=Game.startY+Game.border*(i+1)+Game.length*i;
				Game.huaqiang(dx,dy,0,g);
			}
		}	
		
		for(int i=0;i<Game.row;i++)
		{
			for(int u=0;u<Game.col;u++)
			{
				if(Game.map[i][u]==0)
				{
					int dx=Game.startX+Game.border*(u+1)+Game.length*u+Game.transforX[i][u];
					int dy=Game.startY+Game.border*(i+1)+Game.length*i+Game.transforY[i][u];
					Game.huaqiang(dx,dy,Game.map[i][u],g);
				}		
			}
		}	
		
		for(int i=0;i<Game.row;i++)
		{
			for(int u=0;u<Game.col;u++)
			{
				if(Game.map[i][u]!=0)
				{
					int dx=Game.startX+Game.border*(u+1)+Game.length*u+Game.transforX[i][u];
					int dy=Game.startY+Game.border*(i+1)+Game.length*i+Game.transforY[i][u];
					Game.huaqiang(dx,dy,Game.map[i][u],g);
				}		
			}
		}	

	}

}
