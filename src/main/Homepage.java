package main;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private String email;
	
	//ส่งนี่ไปหน้าที่จะใช้คิดตังด้วย
    private boolean coupon;

    //------------------[ ส่งไปคลาสสุดท้ายที่จะใช้เช็กว่าคนนี้ได้รับส่วนลดหรือไม่ (cc.getcoupon)  ]--------------------------//
    private Account acc = new Account();

    public void setEmail(String EMAIL) {
        email = EMAIL.toLowerCase();
        setData();
        setCoupon(email);
    }

    public void setCoupon(String EMAIL) {
        coupon = acc.chkCoupon(EMAIL);
    }
    //--------------------------------------------------------------------------------------------//

    public void setData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("E:\\eclipse\\workspace\\Myproject\\src\\file\\register.txt"));
            String s;
            while((s = br.readLine()) != null) {
                String[] data = s.split(",");
                if(email.equals(data[4])) {
                    acc.setFName(data[0]);
                    acc.setLName(data[1]);
                    acc.setId(data[2]);
                    acc.setDriverLicense(data[3]);
                }
            }
            br.close();
        }catch(Exception e) {
            return;
        }
    }
    
	/**
	 * Create the frame.
	 */
	public Homepage() {
		setTitle("DD Rental Car");				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/logo.png")));
		setBounds(10, 11,500, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(251, 234, 235));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 484, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 461, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		
	
		
		
		
		

	}
}
