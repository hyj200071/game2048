package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int width = 750;
	public static int height = 750;

	public Frame() {
		setBounds(500, 200, width, height);

		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(Panel.getInstance());
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
		
			}
			
			@Override
			public void keyPressed(KeyEvent key) {
				if(key.getKeyCode()==KeyEvent.VK_UP)
				{
					Game.moveUp();
				}
				if(key.getKeyCode()==KeyEvent.VK_DOWN)
				{
					Game.moveDown();
				}
				if(key.getKeyCode()==KeyEvent.VK_LEFT)
				{
					Game.moveLeft();
				}
				if(key.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					Game.moveRigth();
				}
			}
		});
	}
	
	public Panel getPanel()
	{
		return Panel.getInstance();
	}
}
