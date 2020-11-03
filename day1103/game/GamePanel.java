/*
 * 사실상 모든 게임의 그래픽 처리는 패널이 담당하게 됨
 * */

package day1103.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Thread loopThread;//게임 루프를 무한으로 실행할 쓰레드!
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 960;
	
	Hero hero;
	Bullet bullet;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		createHero();
		
		loopThread = new Thread() {
			public void run() {
				while(true) {
					gameLoop();
					try {
						Thread.sleep(10);// 10/1000초 호출
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		loopThread.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;//2D에 적합한 그래픽스 객체로 형변환!!
		
		g2.setColor(Color.WHITE);;
		g2.fillRect(0, 0, WIDTH, HEIGHT);//패널의 크기만큼 사각형이 채워진다.(화면을 깨끗이 닦는 효과가 남)
		
		//g2.setColor(Color.RED);
		//g2.fillRect(x, y, 100, 45);
		
		//히어로야 그려져라~
		render(g2);//1.this.멤버 메소드에 지정
	}
	
	public void createHero() {
		hero = new Hero(200, 200, 50, 50, 0, 0);
	}
	
	public void moveKey(int key) {
		switch(key) {
			case KeyEvent.VK_LEFT: hero.velX -= 2;break;
			case KeyEvent.VK_RIGHT:hero.velX += 2;break;
			case KeyEvent.VK_UP: hero.velY -= 2; break;
			case KeyEvent.VK_DOWN: hero.velY += 2;break;
			case KeyEvent.VK_SPACE: fire();break;//fire()현재 패널에 정의
		}
	}
	
	public void stopKey(int key) {
		switch(key) {
		case KeyEvent.VK_LEFT: hero.velX = 0;break;
		case KeyEvent.VK_RIGHT:hero.velX = 0;break;
		case KeyEvent.VK_UP: hero.velY = 0; break;
		case KeyEvent.VK_DOWN: hero.velY = 0;break;
		}
	}
	
	public void fire() {
		bullet = new Bullet(hero.x, hero.y, 50, 50, 10, 10);
	}
	
	public void tick() {
		hero.tick();
		if(bullet != null) bullet.tick();
	}
	
	public void render(Graphics2D g2) {
		hero.render(g2);//2.paint()에서 받은 g2를 hero.render의 g2에 대입! g2(GamePanel)=g2(hero.render)
		if(bullet != null) bullet.render(g2);
	}
	
	//모든 게임의 tick(), render()를 호출! 즉 게임 엔진
	public void gameLoop() {
		tick();
		this.repaint();//3.hero가 가지고 있는 색, 크기를 set한 상태에서 repaint()
//		System.out.println("gameLoop() called...");
	}
	
}







