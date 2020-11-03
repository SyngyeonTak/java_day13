package day1103.thread;

import javax.swing.JProgressBar;

public class BarThread extends Thread{
	int n;
	int interval;
	JProgressBar bar;
	
	//이 쓰레드를 이용하고자 하는 자는 bar를 넘기시오
	public BarThread(JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval = interval;
	}
	
	public void run() {
		while (true) {
			n++;
			bar.setValue(n);
			if (n >=100) break;
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
/*
 * 내부익명클래스를 쓸 경우와 안 쓸 경우를 구분하자!!
 * 재사용성이 크면 따로 클래스를 만들고, 재사용성이 없으면 내부 익명클래스를 써라
 * */








