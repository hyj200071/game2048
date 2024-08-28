package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Timer;

public class Game {

	public static final int startX = 100;
	public static final int startY = 100;
	private static Panel mp;
	public static int row;
	public static int col;
	public static int length;
	public static int border;
	public static int map[][];
	public static int transforX[][];
	public static int transforY[][];
	private static boolean timerIsRunning = false;
	private static Timer timer;
	private static List<Message> msgs;
	public static boolean canCreate = false;
	public static int fontSize = 30;

	public Game() {
		Frame frame = new Frame();
		row = 4;
		col = 4;
		length = 100;
		border = 20;
		map = new int[row][col];
		transforX = new int[row][col];
		transforY = new int[row][col];
		msgs = new ArrayList<Message>();

		randomCreate();
		randomCreate();
		randomCreate();
		randomCreate();
		timer = new Timer(10, new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				boolean peekFlag = true;
				if (timerIsRunning) {
					Iterator<Message> ite = msgs.iterator();
					while (ite.hasNext()) {
						Message msg = ite.next();

						if (!msg.peek()) {
							peekFlag = false;
							break;
						}
					}
					if (!peekFlag || msgs.isEmpty()) {
						clearMsg();
						if (canCreate) {
							randomCreate();
						}
						canCreate = false;
						timerIsRunning = false;
					}
					mp.repaint();
				}
			}
		});
		mp = frame.getPanel();

		mp.repaint();
		timer.start();
	}

	protected void clearMsg() {
		Iterator<Message> ite = msgs.iterator();
		while (ite.hasNext()) {
			Message msg = ite.next();
			msg.clear();
			ite.remove();
		}
	}

	public static void main(String[] args) {
		new Game();
	}

	public static void huaqiang(int dx, int dy, int a, Graphics g) {
		int bol = Game.length * 1 / 10;

		g.setFont(new Font("Segoe print", Font.BOLD, fontSize));
		// for(int i=0;i<=bol;i++)
		// {
		// g.drawLine(dx+i, dy+i, dx + length-i, dy+i);
		//
		// g.drawLine(dx + i, dy + i+1, dx + i, dy + length-i);
		// }
		// g.setColor(new Color(105, 155, 255));
		//
		// for(int i=0;i<=bol;i++)
		// {
		// g.drawLine(dx+i+1, dy-i, dx + length-i, dy-i);
		//
		// g.drawLine(dx + length -i, dy + i+1, dx - i, dy + length-i-1);
		// }
		// g.drawLine(dx + 1*bol, dy + length, dx + length, dy + length);
		//
		// g.drawLine(dx + 2*bol, dy + length - 1*bol, dx + length - 1*bol, dy +
		// length - 1*bol);
		//
		// g.drawLine(dx + length, dy + length - 1*bol, dx + length, dy +
		// 1*bol);
		//
		// g.drawLine(dx + length - 1*bol, dy + 2*bol, dx + length - 1*bol, dy +
		// length - 1*bol);

		if (a == 0) {
			g.setColor(new Color(200, 200, 200));
			g.fillRect(dx + 2 * bol, dy + 2 * bol, length - 1 * bol, length - 1 * bol);
		} else if (a == 1) {
			g.setColor(new Color(26, 255, 255));
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("2", dx + length / 2 - fontSize / 4, dy + length / 2 + fontSize / 3);
		} else if (a == 2) {
			g.setColor(Color.green);
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("4", dx + length / 2 - fontSize / 4, dy + length / 2 + fontSize / 3);
		} else if (a == 3) {
			g.setColor(Color.magenta);
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("8", dx + length / 2 - fontSize / 4, dy + length / 2 + fontSize / 3);
		} else if (a == 4) {
			g.setColor(Color.orange);
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("16", dx + length / 2 - fontSize / 2, dy + length / 2 + fontSize / 3);
		} else if (a == 5) {
			g.setColor(Color.yellow);
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("32", dx + length / 2 - fontSize / 2, dy + length / 2 + fontSize / 3);
		} else if (a == 6) {
			g.setColor(Color.decode("#ca6924"));
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("64", dx + length / 2 - fontSize / 2, dy + length / 2 + fontSize / 3);
		} else if (a == 7) {
			g.setColor(Color.pink);
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("128", (int) (dx + length / 2 - fontSize), dy + length / 2 + fontSize / 3);
		} else if (a == 8) {
			g.setColor(Color.decode("#b0a4e3"));
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("256", (int) (dx + length / 2 - fontSize), dy + length / 2 + fontSize / 3);
		} else if (a == 9) {
			g.setColor(Color.decode("#4b5cc4"));
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("512", (int) (dx + length / 2 - fontSize), dy + length / 2 + fontSize / 3);
		} else if (a == 10) {
			g.setColor(Color.decode("#1bd1a5"));
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.black);

			g.drawString("1024", (int) (dx + length / 2 - fontSize * 1.4), dy + length / 2 + fontSize / 3);
		} else if (a == 11) {
			g.setColor(Color.decode("#eedeb0"));
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("2048", (int) (dx + length / 2 - fontSize * 1.4), dy + length / 2 + fontSize / 3);
		} else if (a == 12) {
			g.setColor(Color.decode("#75664d"));
			g.fillRect(dx + 2, dy + 2, length - 1, length - 1);
			g.setColor(Color.BLACK);

			g.drawString("4096", (int) (dx + length / 2 - fontSize * 1.4), dy + length / 2 + fontSize / 3);
		}
	}

	public static void randomCreate() {
		while (true) {
			int ranX = (int) (Math.random() * row);
			int ranY = (int) (Math.random() * col);

			if (map[ranX][ranY] == 0) {

				int ran = (int) (Math.random() * 5);
				switch (ran) {
				case 1:
					map[ranX][ranY] = 2;
					break;
				default:
					map[ranX][ranY] = 1;
				}

				break;
			}
		}
	}

	public static void moveUp() {
		if (timerIsRunning)
			return;

		timerIsRunning = true;
		int map2[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int u = 0; u < col; u++) {
				map2[i][u] = map[i][u];
			}
		}

		for (int i = 0; i < col; i++) {
			for (int u = 0; u < row; u++) {
				if (map2[u][i] != 0) {
					int temp = 0;
					for (int j = u; j >= 0; j--) {
						if (j == 0) {
							if (temp == 0)
								break;
							if (map2[j][i] == map2[u][i]) {
								msgs.add(new Message(u, i, KeyEvent.VK_UP, temp));
								map2[j][i] = -1;
								map2[u][i] = 0;
								break;
							}
							if (map2[j][i] == 0) {
								msgs.add(new Message(u, i, KeyEvent.VK_UP, temp));
								map2[j][i] = map2[u][i];
								map2[u][i] = 0;
								break;
							}
							if (temp != 1) {
								msgs.add(new Message(u, i, KeyEvent.VK_UP, temp - 1));

								map2[j + 1][i] = map2[u][i];
								map2[u][i] = 0;
								break;
							}
							break;
						}
						if (map2[j][i] != 0) {
							if (temp != 0) {
								if (map2[j][i] == map2[u][i]) {
									msgs.add(new Message(u, i, KeyEvent.VK_UP, temp));
									map2[j][i] = -1;
									map2[u][i] = 0;
								} else {
									if (temp != 1) {

										msgs.add(new Message(u, i, KeyEvent.VK_UP, temp - 1));
										map2[j + 1][i] = map2[u][i];
										map2[u][i] = 0;
									}
								}
								break;
							}
						}
						temp++;
					}
				}
			}
		}
	}

	public static void moveDown() {
		if (timerIsRunning)
			return;
		timerIsRunning = true;
		int map2[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int u = 0; u < col; u++) {
				map2[i][u] = map[i][u];
			}
		}

		for (int i = 0; i < col; i++) {
			for (int u = row - 1; u >= 0; u--) {
				if (map2[u][i] != 0) {
					int temp = 0;
					for (int j = u; j <= row - 1; j++) {
						if (j == row - 1) {
							if (temp == 0)
								break;
							if (map2[j][i] == map2[u][i]) {
								msgs.add(new Message(u, i, KeyEvent.VK_DOWN, temp));
								map2[j][i] = -1;
								map2[u][i] = 0;
								break;
							}
							if (map2[j][i] == 0) {
								msgs.add(new Message(u, i, KeyEvent.VK_DOWN, temp));
								map2[j][i] = map2[u][i];
								map2[u][i] = 0;
								break;
							}
							if (temp != 1) {
								msgs.add(new Message(u, i, KeyEvent.VK_DOWN, temp - 1));
								map2[j - 1][i] = map2[u][i];
								map2[u][i] = 0;
								break;
							}
							break;
						}
						if (map2[j][i] != 0) {
							if (temp != 0) {
								if (map2[j][i] == map2[u][i]) {
									msgs.add(new Message(u, i, KeyEvent.VK_DOWN, temp));
									map2[j][i] = -1;
									map2[u][i] = 0;
								} else {
									if (temp != 1) {
										msgs.add(new Message(u, i, KeyEvent.VK_DOWN, temp - 1));
										map2[j - 1][i] = map2[u][i];
										map2[u][i] = 0;
									}
								}
								break;
							}
						}
						temp++;
					}
				}
			}
		}

	}

	public static void moveLeft() {
		if (timerIsRunning)
			return;

		timerIsRunning = true;
		int map2[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int u = 0; u < col; u++) {
				map2[i][u] = map[i][u];
			}
		}

		for (int i = 0; i < row; i++) {
			for (int u = 0; u < col; u++) {
				if (map2[i][u] != 0) {
					int temp = 0;
					for (int j = u;; j--) {
						if (j == 0) {
							if (temp == 0)
								break;
							if (map2[i][j] == map2[i][u]) {
								msgs.add(new Message(i, u, KeyEvent.VK_LEFT, temp));
								map2[i][j] = -1;
								map2[i][u] = 0;

								break;
							}
							if (map2[i][j] == 0) {
								msgs.add(new Message(i, u, KeyEvent.VK_LEFT, temp));
								map2[i][j] = map2[i][u];
								map2[i][u] = 0;
								break;
							}
							if (temp != 1) {
								msgs.add(new Message(i, u, KeyEvent.VK_LEFT, temp - 1));
								map2[i][j + 1] = map2[i][u];
								map2[i][u] = 0;
								break;
							}
							break;
						}
						if (map2[i][j] != 0) {
							if (temp != 0) {
								if (map2[i][j] == map2[i][u]) {
									msgs.add(new Message(i, u, KeyEvent.VK_LEFT, temp));
									map2[i][j] = -1;
									map2[i][u] = 0;

								} else {
									if (temp != 1) {
										msgs.add(new Message(i, u, KeyEvent.VK_LEFT, temp - 1));
										map2[i][j + 1] = map2[i][u];
										map2[i][u] = 0;
									}
								}
								break;
							}
						}
						temp++;
					}
				}
			}
		}
	}

	public static void moveRigth() {
		if (timerIsRunning)
			return;

		timerIsRunning = true;
		int map2[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int u = 0; u < col; u++) {
				map2[i][u] = map[i][u];
			}
		}

		for (int i = 0; i < row; i++) {
			for (int u = col - 1; u >= 0; u--) {
				if (map2[i][u] != 0) {
					int temp = 0;
					for (int j = u;; j++) {
						if (j == col - 1) {
							if (temp == 0)
								break;
							if (map2[i][j] == map2[i][u]) {
								msgs.add(new Message(i, u, KeyEvent.VK_RIGHT, temp));
								map2[i][j] = -1;
								map2[i][u] = 0;
								break;
							}
							if (map2[i][j] == 0) {
								msgs.add(new Message(i, u, KeyEvent.VK_RIGHT, temp));
								map2[i][j] = map2[i][u];
								map2[i][u] = 0;
								break;
							}
							if (temp != 1) {
								msgs.add(new Message(i, u, KeyEvent.VK_RIGHT, temp - 1));
								map2[i][j - 1] = map2[i][u];
								map2[i][u] = 0;
								break;
							}
						}
						if (map2[i][j] != 0) {
							if (temp != 0) {
								if (map2[i][j] == map2[i][u]) {
									msgs.add(new Message(i, u, KeyEvent.VK_RIGHT, temp));
									map2[i][j] = -1;
									map2[i][u] = 0;
								} else {
									if (temp != 1) {
										msgs.add(new Message(i, u, KeyEvent.VK_RIGHT, temp - 1));
										map2[i][j - 1] = map2[i][u];
										map2[i][u] = 0;
									}
								}
								break;
							}
						}
						temp++;
					}
				}
			}
		}
	}

}

class Message {
	private int x;
	private int y;
	private int row;
	private int col;
	private int direction;
	private int step;

	public Message(int row, int col, int direction, int step) {
		super();
		this.row = row;
		this.col = col;
		this.direction = direction;
		this.step = step;

		x = Game.startX + Game.border * (col + 1) + Game.length * col;
		y = Game.startY + Game.border * (row + 1) + Game.length * row;

		Game.canCreate = true;
	}

	public void clear() {
		switch (direction) {
		case KeyEvent.VK_UP:
			if (Game.map[row - step][col] == Game.map[row][col]) {
				Game.map[row - step][col]++;
			} else {
				Game.map[row - step][col] = Game.map[row][col];
			}
			Game.map[row][col] = 0;
			Game.transforX[row][col] = 0;
			Game.transforY[row][col] = 0;
			return;
		case KeyEvent.VK_DOWN:
			if (Game.map[row + step][col] == Game.map[row][col]) {
				Game.map[row + step][col]++;
			} else {
				Game.map[row + step][col] = Game.map[row][col];
			}
			Game.map[row][col] = 0;
			Game.transforX[row][col] = 0;
			Game.transforY[row][col] = 0;
			return;
		case KeyEvent.VK_LEFT:
			if (Game.map[row][col - step] == Game.map[row][col]) {
				Game.map[row][col - step]++;
			} else {
				Game.map[row][col - step] = Game.map[row][col];
			}
			Game.map[row][col] = 0;
			Game.transforX[row][col] = 0;
			Game.transforY[row][col] = 0;
			return;
		case KeyEvent.VK_RIGHT:
			if (Game.map[row][col + step] == Game.map[row][col]) {
				Game.map[row][col + step]++;
			} else {
				Game.map[row][col + step] = Game.map[row][col];
			}
			Game.map[row][col] = 0;
			Game.transforX[row][col] = 0;
			Game.transforY[row][col] = 0;
			return;
		}
	}

	public boolean peek() {

		int speed = 10;
		switch (direction) {
		case KeyEvent.VK_UP:
			if (y > Game.startY + Game.border * (row - step + 1) + Game.length * (row - step)) {
				y -= step * speed;
				Game.transforY[row][col] -= step * speed;
				return true;
			} else {
				return false;
			}
		case KeyEvent.VK_DOWN:
			if (y < Game.startY + Game.border * (row + step + 1) + Game.length * (row + step)) {
				y += step * speed;
				Game.transforY[row][col] += step * speed;
				return true;
			} else {
				return false;
			}
		case KeyEvent.VK_LEFT:
			if (x > Game.startX + Game.border * (col - step + 1) + Game.length * (col - step)) {
				x -= step * speed;
				Game.transforX[row][col] -= step * speed;
				return true;
			} else {
				return false;
			}
		case KeyEvent.VK_RIGHT:
			if (x < Game.startX + Game.border * (col + step + 1) + Game.length * (col + step)) {
				x += step * speed;
				Game.transforX[row][col] += step * speed;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}