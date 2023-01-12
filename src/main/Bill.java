package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Bill {
	// attribute //
	private boolean coupon;
	private String fname;
	private String lname;
	private String id;
	private String driver_license;
	private String email;
	private String start_point;
	private String meeting_point;
	private int day;
	private String type;
	private String color;
	private String seat;
	private int price;
	private int insurance;
	private int child_seat;
	private int gps;
	
	
	// method //
	public void setData(String EMAIL,boolean COUPON) {
		try {
			Car car = new Car();
			BufferedReader br = new BufferedReader(new FileReader("E:\\eclipse\\workspace\\Myproject\\src\\file\\register.txt"));
			String s;
			while((s = br.readLine()) != null) {
				String[] data = s.split(",");
				if(EMAIL.equals(data[4])) {
					fname = data[0];
					lname = data[1];
					id = data[2];
					driver_license = data[3];
					email = EMAIL.toLowerCase();
				}
			}
			br.close();
			type = car.getType();
			seat = car.getSeat();
			color = car.getColor();
			price = car.getPrice();
			setCoupon(COUPON);
		}catch(Exception e) {
			return;
		}
	}
	
	public void setCoupon(boolean COUPON) {
		coupon = COUPON;
	}
	
	public void startPoint(String SP) {
		start_point = SP;
	}
	
	public String getStartPoint() {
		return start_point;
	}
	
	public void setMeetingPoint(String MP) {
		meeting_point = MP;
	}
	
	public String getMeetingPoint() {
		return meeting_point;
	}
	
	public void setDay(String DAY ) {
		day = Integer.parseInt(DAY);
	}
	
	public String getDay() {
		return day+"";
	}
	
	public void setGps(int GPS) {
		gps = GPS;
	}
	
	public String getGps() {
		return gps+"";
	}
	
	public void setInsurance(int IS) {
		insurance = IS;
	}
	
	public String getInsurance() {
		return insurance+"";
	}
	
	public void setChildSeat(int SS) {
		child_seat = SS;
	}
	
	public String getChildSeat() {
		return child_seat+"";
	}
	
	public String getFName() {
		return fname;
	}
	
	public String getLName() {
		return lname;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDriverLicense() {
		return driver_license;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getType() {
		return type;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getSeat() {
		return seat;
	}
	
	public String getPriceOfCar() {
		return price+"";
	}
	
	public double getNetPrice() {
		CostCalculator cc = new CostCalculator();
		int totalOfAddOn = insurance+child_seat+gps;
		cc.setPrice(price);
		cc.setDay(day);
		cc.setAddOn(totalOfAddOn);
		cc.setCoupon(coupon);
		return cc.netPrice();
	}
	
	public void saveBill() {
		try {
			BufferedWriter bw = new BufferedWriter((new FileWriter("E:\\eclipse\\workspace\\Myproject\\src\\file\\billpayment.txt", true)));
			bw.write(fname+","+lname+","+id+","+driver_license+","+email+","+start_point+","+meeting_point
					+","+day+","+type+","+color+","+seat+","
					+price+","+insurance+","+child_seat+","+gps);
			bw.close();
		}catch(Exception e) {
			return;
		}
	}

}
