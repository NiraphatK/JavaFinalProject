package main;

import java.awt.EventQueue;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * Launch the application.
 */

public class Launcher {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel( new FlatLightLaf() );
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (Exception ex) {
						//ignore Exception
					}
				}

			}
		});
	}
}
