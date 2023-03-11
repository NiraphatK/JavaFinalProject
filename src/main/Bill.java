package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bill extends Account {
	// attribute //
	private Car car;
	private String startReturnPoint;
	private int day;
	private int insurance;
	private int childSeat;
	private int gps;
	private float discount;

	// method //
	public Bill() {
		super();
		car = null;
		startReturnPoint = "";
		day = 1;
		insurance = 0;
		childSeat = 0;
		gps = 0;

	}

	public Bill(String email, Car car, String startReturnPoint, int day, int insurance, int childSeat, int gps)
			throws IOException {
		super(email);
		this.car = car;
		this.startReturnPoint = startReturnPoint;
		this.day = day;
		this.insurance = insurance;
		this.childSeat = childSeat;
		this.gps = gps;
	}

	public boolean getCoupon(String email) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("checkcoupon.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("checkcoupon.txt",true));
		String temp = null;
		while ((temp = br.readLine()) != null) {
			if (email.equalsIgnoreCase(temp)) {
				br.close();
				bw.close();
				return false;
			}
		}
		bw.write(email+"\n");
		bw.close();br.close();
		return true;
	}

	public String getStartReturnPoint() {
		return startReturnPoint;
	}

	public void setCouponPrice() throws IOException {
		discount =  getCoupon(super.getEmail()) ? (getTotalPrice() + getPriceAddon()) * 0.1f : 0f;
	}
	
	public float getCouponPrice() throws IOException {
		return discount;
	}

	public float getTotalPrice() {
		return car.getPrice() * day;
	}

	public int getPriceAddon() {
		return insurance + childSeat + insurance;
	}

	public float getNetPrice() throws IOException {
		return getTotalAddon() - discount;
	}

	public float getTotalAddon() {
		return getTotalPrice() + getPriceAddon();
	}

	public Car getCar() {
		return car;
	}

	public int getInsurance() {
		return insurance;
	}

	public int getchildSeat() {
		return childSeat;
	}

	public int getGPS() {
		return gps;
	}

	public int getDay() {
		return day;
	}

	public void saveBill() throws IOException {
		BufferedWriter bw = new BufferedWriter((new FileWriter("billpayment.txt", true)));
		bw.write(super.getFName() + "," + super.getLName() + "," + super.getId() + "," + super.getDriverLicense() + ","
				+ super.getEmail() + "," + startReturnPoint + "," + day + "," + car.getType() + "," + ","
				+ car.getPrice() + "," + insurance + "," + childSeat + "," + gps + "," + discount + ","
				+ getNetPrice()+"\n");
		bw.close();

	}

}
