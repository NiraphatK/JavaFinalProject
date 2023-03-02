package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bill {
	// attribute //
	private Account acct;
	private Car car;
	private String startPoint;
	private String meetingPoint;
	private int day;
	private int insurance;
	private int childSeat;
	private int gps;

	// method //
	public Bill() {
		acct = null;
		car = null;
		startPoint = "";
		meetingPoint = "";
		day = 1;
		insurance = 0;
		childSeat = 0;
		gps = 0;

	}

	public Bill(Account acct, Car car, String startPoint, String meetingPoint, int day, int insurance, int childSeat,
			int gps) {
		this.acct = acct;
		this.car = car;
		this.startPoint = startPoint;
		this.meetingPoint = meetingPoint;
		this.day = day;
		this.insurance = insurance;
		this.childSeat = childSeat;
		this.gps = gps;
	}

	public boolean getCoupon(String email) throws IOException {
		BufferedReader br2 = new BufferedReader(
				new FileReader("billpayment.txt"));
		BufferedReader br1 = new BufferedReader(
				new FileReader("register.txt"));
		BufferedWriter bw1 = new BufferedWriter(
				new FileWriter("checkcoupon.txt", true));
		String m;
		while ((m = br1.readLine()) != null) {
			String[] data = m.split(",");
			if (data[4].equals(email)) {
				String m2;
				while ((m2 = br2.readLine()) != null) {
					if (m2.equals(email)) {
						bw1.close();
						br2.close();
						br1.close();
						return false;
					}
				}
				bw1.write(email);
			}
		}
		bw1.close();
		br2.close();
		br1.close();
		return true;
	}

	public float getCouponPrice() throws IOException {
		return getCoupon(acct.getEmail()) ? (getTotalPrice() + getPriceAddon()) * 0.1f : 0f;
	}

	public float getTotalPrice() {
		return car.getPrice() * day;
	}

	public int getPriceAddon() {
		return insurance + childSeat + insurance;
	}

	public float getNetPrice() throws IOException {
		return getTotalPrice() + getPriceAddon() - getCouponPrice();
	}

	public void saveBill() throws IOException {
		BufferedWriter bw = new BufferedWriter(
				(new FileWriter("billpayment.txt", true)));
		bw.write(acct.getFName() + "," + acct.getLName() + "," + acct.getId() + "," + acct.getDriverLicense() + ","
				+ acct.getEmail() + "," + startPoint + "," + meetingPoint + "," + day + "," + car.getType() + ","
				+ car.getColor() + "," + car.getSeat() + "," + car.getPrice() + "," + insurance + "," + childSeat + ","
				+ gps + "," + getCouponPrice() + "," + getNetPrice());
		bw.close();

	}

}
