package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class Announce {
	
	static Timer timer ;
	static int second;
	
	public static void main(String[] args)throws IOException {
		
		second = 0;
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(second);
				second++;
				
			}
		});
		timer.start();

	}

}
