package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.event.MouseWheelListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseWheelEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.CardLayout;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

public class Homepage extends JFrame {

	private String[] announce = {
			"สำหรับลูกค้าใหม่หรือยังไม่เคยใช้บริการของ DD Rental Car เมื่อได้ทำการเช่ารถ ตอนชำระเงินจะได้รับส่วนลด 10% ไปเลย !!!",
			"สามารถติดตามข่าวสารของพวกเราได้ที่ www.dd-rentalcar.com อย่าพลาดข่าวสารดีๆจากพวกเรา",
			"บริการเช่ารถของเรามีให้เลือกเช่ามากมายไม่ว่าจะเป็นรุ่น Toyota Honda Susuki Nissan BNW Mercedes-Benz และรุ่นอื่นๆอีกมากมาย", };
	private JPanel contentPane;
	private String email;
	private int DAYS;
	SimpleDateFormat datefor;
	int xx;
	int xy;
	Timer timer;
	int second, i;
	JLabel dateLabel;
	Boolean chkCarSelect = false;
	int chkCar=0;

	private Account acc = new Account();
	private JTextField textField;

	public void setEmail(String email) {
		this.email = email;
	}

	public Homepage() {

		getContentPane().setBackground(new Color(249, 251, 252));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(10, 11, 1350, 850);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});

		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				Homepage.this.setLocation(x - xx, y - xy);
			}

		});
		panel.setBackground(new Color(99, 156, 217));
		panel.setBounds(0, 0, 1363, 28);
		getContentPane().add(panel);

		JPanel funtionPanel = new JPanel();
		funtionPanel.setBackground(new Color(99, 156, 217));
		funtionPanel.setBounds(0, 0, 214, 870);
		getContentPane().add(funtionPanel);
		funtionPanel.setLayout(null);

		JLabel logoutLabel = new JLabel("Log out :");
		logoutLabel.setForeground(new Color(0, 0, 0));
		logoutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutLabel.setForeground(new Color(255, 128, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				logoutLabel.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Logout",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (ans == 0) {
					Main nextMain = new Main();
					dispose();
					nextMain.setVisible(true);
				}
			}
		});
		logoutLabel.setIcon(new ImageIcon(Homepage.class.getResource("/icon/logout.png")));
		logoutLabel.setBounds(10, 816, 190, 24);
		funtionPanel.add(logoutLabel);

		JLabel showEmail = new JLabel("");
		showEmail.setText(email);
		showEmail.setBounds(80, 821, 120, 14);
		funtionPanel.add(showEmail);
		

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(10, 20, 200, 200);
		funtionPanel.add(logoLabel);
		logoLabel.setIcon(new ImageIcon(Homepage.class.getResource("/icon/logomini.png")));

		JLabel txtDDcar = new JLabel("DD Rental Car");
		txtDDcar.setHorizontalAlignment(SwingConstants.CENTER);
		txtDDcar.setForeground(new Color(251, 234, 235));
		txtDDcar.setFont(new Font("Impact", Font.PLAIN, 26));
		txtDDcar.setBounds(38, 215, 143, 33);
		funtionPanel.add(txtDDcar);

		JLabel txt_number = new JLabel("Tel.012-345-6789");
		txt_number.setHorizontalAlignment(SwingConstants.CENTER);
		txt_number.setForeground(new Color(251, 234, 235));
		txt_number.setFont(new Font("Impact", Font.PLAIN, 14));
		txt_number.setBounds(54, 247, 106, 18);
		funtionPanel.add(txt_number);
				
				RoundPanel Deccorate = new RoundPanel(100, new Color(119, 173, 231));
				Deccorate.setLayout(null);
				Deccorate.setOpaque(false);
				Deccorate.setBounds(3, 302, 207, 486);
				funtionPanel.add(Deccorate);
				
				JLabel lblNewLabel = new JLabel("Total Cost");
				lblNewLabel.setBounds(55, 13, 97, 21);
				Deccorate.add(lblNewLabel);
				lblNewLabel.setFont(new Font("UD Digi Kyokasho NK-B", Font.PLAIN, 18));
				
				JLabel car1Text_1 = new JLabel("วันรับรถ :            วันส่งรถ :");
				car1Text_1.setBounds(8, 49, 200, 32);
				Deccorate.add(car1Text_1);
				car1Text_1.setForeground(Color.BLACK);
				car1Text_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
						JDateChooser dateChooser = new JDateChooser();
						dateChooser.setBounds(4, 82, 94, 20);
						Deccorate.add(dateChooser);
						dateChooser.setOpaque(false);
						
						JDateChooser dateChooser_1 = new JDateChooser();
						dateChooser_1.setBounds(108, 81, 94, 20);
						Deccorate.add(dateChooser_1);
						dateChooser_1.setOpaque(false);
						
						JLabel car1Text2 = new JLabel("สถานที่รับรถ / ส่งรถ :");
						car1Text2.setForeground(Color.BLACK);
						car1Text2.setFont(new Font("Tahoma", Font.PLAIN, 14));
						car1Text2.setBounds(8, 113, 200, 32);
						Deccorate.add(car1Text2);
						
						textField = new JTextField();
						textField.setBounds(4, 146, 198, 32);
						Deccorate.add(textField);
						textField.setColumns(10);
						
						JLabel car1Text3 = new JLabel("ตัวเลือกเพิ่มเติม Add On :");
						car1Text3.setForeground(Color.BLACK);
						car1Text3.setFont(new Font("Tahoma", Font.PLAIN, 14));
						car1Text3.setBounds(8, 189, 200, 32);
						Deccorate.add(car1Text3);
						
						JCheckBox babyseat = new JCheckBox("Baby seat              ( 1,999.- )");
						babyseat.setBounds(8, 228, 165, 23);
						Deccorate.add(babyseat);
						
						JCheckBox carInsur = new JCheckBox("Car insurance       ( 3,999.- )");
						carInsur.setBounds(8, 261, 176, 23);
						Deccorate.add(carInsur);
						
						JCheckBox GPSselect = new JCheckBox("GPS                        ( 599.- )");
						GPSselect.setBounds(8, 295, 165, 23);
						Deccorate.add(GPSselect);
		panel.setLayout(null);

		JLabel icon_exit = new JLabel("");
		icon_exit.setIcon(new ImageIcon(Main.class.getResource("/icon/close_16px.png")));
		icon_exit.setBounds(1327, 5, 16, 16);
		icon_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the application?",
						"DD Car Rental", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (ans == 0)
					dispose();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				icon_exit.setIcon(new ImageIcon(Main.class.getResource("/icon/close3_16px.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_exit.setIcon(new ImageIcon(Main.class.getResource("/icon/close_16px.png")));
			}
		});
		panel.add(icon_exit);
		icon_exit.setHorizontalAlignment(SwingConstants.CENTER);
		icon_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		icon_exit.setForeground(Color.DARK_GRAY);
		icon_exit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		icon_exit.setBackground(Color.WHITE);

		JLabel icon_mini = new JLabel("");
		icon_mini.setIcon(new ImageIcon(Main.class.getResource("/icon/subtract_16px.png")));
		icon_mini.setBounds(1300, 7, 16, 16);
		panel.add(icon_mini);
		icon_mini.setHorizontalAlignment(SwingConstants.CENTER);
		icon_mini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		icon_mini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Main.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				icon_mini.setIcon(new ImageIcon(Main.class.getResource("/icon/subtract2_16px.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_mini.setIcon(new ImageIcon(Main.class.getResource("/icon/subtract_16px.png")));
			}
		});
		icon_mini.setForeground(Color.DARK_GRAY);
		icon_mini.setFont(new Font("Tahoma", Font.PLAIN, 25));
		icon_mini.setBackground(Color.WHITE);

		JPanel CarPanel = new JPanel();
		CarPanel.setBackground(new Color(255, 255, 255));
		CarPanel.setBounds(194, 22, 1183, 828);
		getContentPane().add(CarPanel);
		CarPanel.setLayout(null);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1139, 6, 17, 822);
		CarPanel.add(scrollBar);

		JLabel megaphoneLabel = new JLabel("");
		megaphoneLabel.setIcon(new ImageIcon(Homepage.class.getResource("/icon/Megaph.png")));
		megaphoneLabel.setBounds(51, 23, 30, 30);
		CarPanel.add(megaphoneLabel);

		RoundPanel Board = new RoundPanel(20, new Color(220, 224, 229));
		Board.setBounds(91, 23, 1008, 30);
		CarPanel.add(Board);
		Board.setLayout(null);
		Board.setOpaque(false);

		JLabel AnnounceLabel = new JLabel("Announce : ");
		AnnounceLabel.setFont(new Font("Super Mario 256", Font.PLAIN, 13));
		AnnounceLabel.setBounds(25, 9, 105, 14);
		AnnounceLabel.setForeground(new Color(229, 64, 64));
		Board.add(AnnounceLabel);

		JLabel TextLabel = new JLabel(
				"บริการเช่ารถของเรามีให้เลือกเช่ามากมายไม่ว่าจะเป็นรุ่น Toyota Honda Susuki Nissan BNW Mercedes-Benz และรุ่นอื่นๆอีกมากมาย");
		TextLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TextLabel.setForeground(new Color(255, 92, 11));
		TextLabel.setBounds(117, 7, 969, 14);
		Board.add(TextLabel);

		second = 0;
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				if (second % 10 == 0) {
					if (i > announce.length - 1) {
						i = 0;
						TextLabel.setText(announce[i]);
						i++;
					} else {
						TextLabel.setText(announce[i]);
						i++;
					}
				}
			}
		});
		timer.start();

		RoundPanel car1Panel_1 = new RoundPanel(40, new Color(220, 224, 229));
		car1Panel_1.setLayout(null);
		car1Panel_1.setOpaque(false);
		car1Panel_1.setBounds(75, 472, 288, 317);
		CarPanel.add(car1Panel_1);
		
		RoundPanel car1Panel_2 = new RoundPanel(40, new Color(220, 224, 229));
		car1Panel_2.setLayout(null);
		car1Panel_2.setOpaque(false);
		car1Panel_2.setBounds(444, 111, 288, 317);
		CarPanel.add(car1Panel_2);
		
		RoundPanel car1Panel = new RoundPanel(40, new Color(220, 224, 229));
		car1Panel.setOpaque(false);
		car1Panel.setBounds(75, 111, 288, 317);
		CarPanel.add(car1Panel);
		car1Panel.setLayout(null);

		JLabel car1Label = new JLabel("Toyota Altis");
		car1Label.setBounds(97, 13, 84, 18);
		car1Label.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		car1Panel.add(car1Label);

		JLabel car1Text = new JLabel("ราคาเช่า : 1,000 /  วัน");
		car1Text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		car1Text.setForeground(new Color(0, 0, 0));
		car1Text.setBounds(60, 180, 171, 22);
		car1Panel.add(car1Text);

		JLabel car1Picture = new JLabel("");
		car1Picture.setBounds(41, 13, 200, 200);
		car1Picture.setIcon(new ImageIcon(Homepage.class.getResource("/icon/car1.png")));
		car1Panel.add(car1Picture);
		
		JLabel StarLabel = new JLabel("");
		StarLabel.setIcon(new ImageIcon(Homepage.class.getResource("/icon/star.png")));
		StarLabel.setBounds(250, 6, 30, 30);
		car1Panel.add(StarLabel);
		
		JRadioButton radio1 = new JRadioButton("คลิกเพื่อเลือกเช่า");
		radio1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radio1.setBounds(41, 281, 137, 21);
		car1Panel.add(radio1);

		JLabel car2Label = new JLabel("Nissan GT-R35");
		car2Label.setBounds(80, 11, 115, 18);
		car1Panel_1.add(car2Label);
		car2Label.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		JLabel StarLabel_1 = new JLabel("");
		StarLabel_1.setIcon(new ImageIcon(Homepage.class.getResource("/icon/star.png")));
		StarLabel_1.setBounds(251, 7, 30, 30);
		car1Panel_1.add(StarLabel_1);
		
		JLabel car1Text_2 = new JLabel("ราคาเช่า : 5,000 /  วัน");
		car1Text_2.setForeground(Color.BLACK);
		car1Text_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		car1Text_2.setBounds(55, 188, 171, 22);
		car1Panel_1.add(car1Text_2);
		
		JRadioButton radio4 = new JRadioButton("คลิกเพื่อเลือกเช่า");
		radio4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radio4.setBounds(39, 280, 134, 23);
		car1Panel_1.add(radio4);
		
		JButton ConfirmBottonc4 = new JButton("Confirm");
		ConfirmBottonc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfirmBottonc4.setBounds(175, 280, 89, 23);
		car1Panel_1.add(ConfirmBottonc4);
		
				JLabel car2Picture = new JLabel("");
				car2Picture.setBounds(39, 22, 200, 200);
				car1Panel_1.add(car2Picture);
				car2Picture.setIcon(new ImageIcon(Homepage.class.getResource("/icon/car2.png")));

		JLabel car3Label = new JLabel("Honda Civic");
		car3Label.setBounds(94, 11, 91, 18);
		car1Panel_2.add(car3Label);
		car3Label.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		JLabel car1Text_5 = new JLabel("ราคาเช่า : 1,500 /  วัน");
		car1Text_5.setForeground(Color.BLACK);
		car1Text_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		car1Text_5.setBounds(58, 185, 171, 22);
		car1Panel_2.add(car1Text_5);
		
		JRadioButton radio2 = new JRadioButton("คลิกเพื่อเลือกเช่า");
		radio2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radio2.setBounds(38, 281, 137, 23);
		car1Panel_2.add(radio2);
		
		JButton ConfirmBottonc2 = new JButton("Confirm");
		ConfirmBottonc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfirmBottonc2.setBounds(177, 281, 89, 23);
		car1Panel_2.add(ConfirmBottonc2);
		
				JLabel car3Picture = new JLabel("");
				car3Picture.setBounds(44, 20, 200, 200);
				car1Panel_2.add(car3Picture);
				car3Picture.setIcon(new ImageIcon(Homepage.class.getResource("/icon/car3.png")));
				

		RoundPanel car1Panel_4 = new RoundPanel(40, new Color(220, 224, 229));
		car1Panel_4.setLayout(null);
		car1Panel_4.setOpaque(false);
		car1Panel_4.setBounds(444, 472, 288, 317);
		CarPanel.add(car1Panel_4);

		JLabel car4Label = new JLabel("BMW 5 Series Sedan");
		car4Label.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		car4Label.setBounds(74, 11, 142, 18);
		car1Panel_4.add(car4Label);

		JLabel car4Picture = new JLabel("");
		car4Picture.setIcon(new ImageIcon(Homepage.class.getResource("/icon/car4.png")));
		car4Picture.setBounds(46, 37, 200, 160);
		car1Panel_4.add(car4Picture);
		
		JLabel car1Text_3 = new JLabel("ราคาเช่า : 2,000 /  วัน");
		car1Text_3.setForeground(Color.BLACK);
		car1Text_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		car1Text_3.setBounds(64, 192, 171, 22);
		car1Panel_4.add(car1Text_3);
		
		JRadioButton radio5 = new JRadioButton("คลิกเพื่อเลือกเช่า");
		radio5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radio5.setBounds(39, 282, 137, 23);
		car1Panel_4.add(radio5);
		
		JButton ConfirmBottonc5 = new JButton("Confirm");
		ConfirmBottonc5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfirmBottonc5.setBounds(179, 282, 89, 23);
		car1Panel_4.add(ConfirmBottonc5);

		RoundPanel car1Panel_3 = new RoundPanel(40, new Color(220, 224, 229));
		car1Panel_3.setLayout(null);
		car1Panel_3.setOpaque(false);
		car1Panel_3.setBounds(811, 111, 288, 317);
		CarPanel.add(car1Panel_3);

		JLabel car5Label = new JLabel("Mecedes Benz C200");
		car5Label.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		car5Label.setBounds(82, 11, 144, 18);
		car1Panel_3.add(car5Label);

		JLabel car5Picture = new JLabel("");
		car5Picture.setIcon(new ImageIcon(Homepage.class.getResource("/icon/car5.png")));
		car5Picture.setBounds(50, 38, 200, 139);
		car1Panel_3.add(car5Picture);
		
		JLabel StarLabel_1_1 = new JLabel("");
		StarLabel_1_1.setIcon(new ImageIcon(Homepage.class.getResource("/icon/star.png")));
		StarLabel_1_1.setBounds(253, 5, 30, 30);
		car1Panel_3.add(StarLabel_1_1);
		
		JLabel car1Text_6 = new JLabel("ราคาเช่า : 2,500 /  วัน");
		car1Text_6.setForeground(Color.BLACK);
		car1Text_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		car1Text_6.setBounds(70, 187, 171, 22);
		car1Panel_3.add(car1Text_6);
		
		JRadioButton radio3 = new JRadioButton("คลิกเพื่อเลือกเช่า");
		radio3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radio3.setBounds(40, 280, 137, 23);
		car1Panel_3.add(radio3);
		
		JButton ConfirmBottonc3 = new JButton("Confirm");
		ConfirmBottonc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfirmBottonc3.setBounds(181, 280, 89, 23);
		car1Panel_3.add(ConfirmBottonc3);

		RoundPanel car1Panel_5 = new RoundPanel(40, new Color(220, 224, 229));
		car1Panel_5.setLayout(null);
		car1Panel_5.setOpaque(false);
		car1Panel_5.setBounds(811, 472, 288, 317);
		CarPanel.add(car1Panel_5);

		JLabel car6Label = new JLabel("Tesla Model 3");
		car6Label.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		car6Label.setBounds(92, 11, 105, 18);
		car1Panel_5.add(car6Label);

		JLabel car6Picture = new JLabel("");
		car6Picture.setIcon(new ImageIcon(Homepage.class.getResource("/icon/car6.png")));
		car6Picture.setBounds(50, 40, 200, 150);
		car1Panel_5.add(car6Picture);
		
		JLabel car1Text_4 = new JLabel("ราคาเช่า : 3,000 /  วัน");
		car1Text_4.setForeground(Color.BLACK);
		car1Text_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		car1Text_4.setBounds(68, 193, 171, 22);
		car1Panel_5.add(car1Text_4);
		
		JRadioButton radio6 = new JRadioButton("คลิกเพื่อเลือกเช่า");
		radio6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radio6.setBounds(41, 282, 137, 23);
		car1Panel_5.add(radio6);
		
		JButton ConfirmBottonc6 = new JButton("Confirm");
		ConfirmBottonc6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfirmBottonc6.setBounds(182, 282, 89, 23);
		car1Panel_5.add(ConfirmBottonc6);

		JLabel corner_panel = new JLabel("");
		corner_panel.setBounds(-7, -18, 100, 100);
		CarPanel.add(corner_panel);
		corner_panel.setIcon(new ImageIcon(Homepage.class.getResource("/icon/corners.png")));
		
		ButtonGroup bp = new ButtonGroup();
		bp.add(radio1);
		
		JButton ConfirmBottonc1 = new JButton("Confirm");
		ConfirmBottonc1.setBounds(181, 280, 89, 23);
		car1Panel.add(ConfirmBottonc1);
		bp.add(radio2);
		bp.add(radio3);
		bp.add(radio4);
		bp.add(radio5);
		bp.add(radio6);
		
		/*JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
				Date DatePick = null;
				Date DateReturn= null;
				if(dateChoosePick!=null) showMessageError.setText("Please enter the pick up date.");
				else showMessageError.setText("");
				if(dateChooseReturn!=null) showMessageError.setText("Please enter the date of return of the car.");
				else showMessageError.setText("");
				try {
					DatePick = frm.parse(frm.format(dateChoosePick.getDate()));
					DateReturn = frm.parse(frm.format(dateChooseReturn.getDate()));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				double DateDiff = DateReturn.getTime()-DatePick.getTime();
				DAYS = (int) DateDiff/(60*60*1000)/24;
				System.out.println(DAYS);
				showMessageError.setText(""+DAYS);
			}
		});
		btnNewButton_1.setBounds(334, 190, 89, 23);
		contentPane.add(btnNewButton_1);*/

	}
}
