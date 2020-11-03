/*
 * 주인공을 정의한다.
 * */

package day1103.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Hero extends GameObject{

	public Hero(int x, int y, int width, int height, int velX, int velY) {
		super(x, y, width, height, velX, velY);
	}
	
	//물리량 변화(데이터의 변화)
	public void tick() {
		this.x += this.velX;
		this.y += this.velY;
	}
	
	//그래픽 처리(화면에 그려질 처리)
	//모든 게임 케릭터는 패널에 그려야 하므로, g2를 패널에 paint() 메서드의 지역변수를 받아오자
	/*
	 * 개인적인 이해: Hero객체가 갖고 있는 render()는 GamePanel객체의 setter와 비슷하다.
	 * 왜? GamePanel은 하나밖에 생성되지 않으므로 그곳에 칠해질 색, 크기 등을
	 * set하고 나면 다른 색, 크기 지정이 어렵다.
	 * 따라서 색, 크기를 set할 수 있는 객체가 따로 필요하다. set=repaint()=render();
	 * 
	 * 이 render()는 GamePanel이 갖고 있는 g2변수에 접근을 하여 repaint()를 해야한다.
	 * GamePanel을 생성자에서 매개변수로 받아와도 지역변수인 g2는 접근하기 어려우므로
	 * GamePanel에서 Hero객체를 만들어 맴버메소드에 접근하는 방법을 취한다.
	 * Hero에 있는 g2 매개변수는 null이지만 GamePanel-paint()에서 호출하는 순간 
	 * g2(Hero.render) = g2(GamePanel)이 성립이 되므로 접근할 수 있다. 
	 * 
	 */	
	public void render(Graphics2D g2 ) {
		//패널에 그려야한다.
		g2.setColor(Color.RED);
		g2.fillRect(x, y, 100, 45);
	}
	
}












