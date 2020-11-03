package day1103.game;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	GamePanel gamePanel;//실제 게임이 그려질 패널
	
	public GameWindow() {
		gamePanel = new GamePanel();
		
		setLayout(new FlowLayout());
		add(gamePanel);	
		pack();//윈도우 안에 있는 내용물까지 줄어듦
		setLocationRelativeTo(null);
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				gamePanel.moveKey(e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				gamePanel.stopKey(e.getKeyCode());

			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}

}









