/*
 * 진행상황을 직관적으로 알 수 있는 Progress Bar를 활용해보자
 * */

package day1103.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class ProgressApp extends JFrame{
	JLabel la;
	JProgressBar bar1, bar2, bar3;
	BarThread barThread1, barThread2, barThread3;//바를 증가시킬 Thread
	Thread labelThread;//label을 증가시킬 Thread
	
	public ProgressApp() {
		la = new JLabel("0", SwingConstants.CENTER);
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
	
		
		//스타일
		la.setPreferredSize(new Dimension(500, 150));
		la.setFont(new Font("Vernada", Font.BOLD|Font.ITALIC, 90));
		bar1.setPreferredSize(new Dimension(500, 70));
		bar2.setPreferredSize(new Dimension(500, 70));
		bar3.setPreferredSize(new Dimension(500, 70));
		
		
		add(la);
		add(bar1);
		add(bar2);
		add(bar3);
		
		setLayout(new FlowLayout());
	
		//Thread 3개 생성하여 runnable로 진입시키자
		
		barThread1 = new BarThread(bar1, 50);
		barThread2 = new BarThread(bar2, 25);
		barThread3 = new BarThread(bar3, 10);
		
		barThread1.start();//쓰레드 동작
		barThread2.start();//쓰레드 동작
		barThread3.start();//쓰레드 동작
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//labelThread.start();
	}
	
	public static void main(String[] args) {
		new ProgressApp();
		
	}
}











