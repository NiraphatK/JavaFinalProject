package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Account {
	// attribute //
	private String fname;
	private String lname;
	private String id;
	private String driver_license;
	private String email;
	private String password;
	
	
	// private String start_point;
	// private String meeting_point;
	// private String time;

	// method //
	public void setFName(String FNAME) {
		fname = FNAME.toLowerCase();
	}

	public String getFName() {
		return fname;
	}

	public void setLName(String LNAME) {
		lname = LNAME.toLowerCase();
	}

	public String getLName() {
		return lname;
	}
	
	public String getName() {
		String NAME = (fname.charAt(0)+"").toUpperCase().concat(fname.substring(1)) +
				" "+ (lname.charAt(0)+"").toUpperCase().concat(lname.substring(1));
		return NAME;
	}

	public void setId(String ID) {
		id = ID;
	}

	public String getId() {
		return id;
	}

	public void setDriverLicense(String DL) {
		driver_license = DL;
	}

	public String getDriverLicense() {
		return driver_license;
	}

	public void setEmail(String EMAIL) {
		email = EMAIL.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String PASS) {
		password = PASS;
	}

	public String getPassword() {
		return password;
	}

	/*
	 * public void setStartPoint(String SP) { start_point = SP; }
	 * 
	 * public String getStartPoint() { return start_point; }
	 * 
	 * public void setMeetingPoint(String MP) { meeting_point = MP; }
	 * 
	 * public String getMeetingPoint() { return meeting_point; }
	 * 
	 * public void setTime(String TIME ) { time = TIME; }
	 * 
	 * public String getTime() { return time; }
	 */
	public void register() {
		try {
			BufferedWriter bw = new BufferedWriter(
					(new FileWriter("E:\\eclipse\\workspace\\Myproject\\src\\file\\register.txt", true)));
			bw.write(fname + "," + lname + "," + id + "," + driver_license + "," + email + "," + password + "\n");
			bw.close();
		} catch (Exception e) {
			return;
		}
	}

	public boolean login(String EMAIL, String PASSWORD) {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("E:\\eclipse\\workspace\\Myproject\\src\\file\\register.txt"));
			String s;
			while ((s = br.readLine()) != null) {
				String[] data = s.split(",");
				if (data[4].equalsIgnoreCase(EMAIL) && data[5].equals(PASSWORD)) {
					email = EMAIL.toLowerCase();
					br.close();
					return true;
				}
			}
			br.close();
			return false;
		} catch (Exception e) {
			return false;
		}
	}// end chkLogin //

	// use chkCoupon method for return boolean to setCoupon method in CostCalculator
	// class //
	public boolean chkCoupon(String EMAIL) {
		try {
			BufferedReader br1 = new BufferedReader(new FileReader("E:\\eclipse\\workspace\\Myproject\\src\\file\\register.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("E:\\eclipse\\workspace\\Myproject\\src\\file\\checkcoupon.txt"));
			BufferedWriter bw1 = new BufferedWriter(new FileWriter("E:\\eclipse\\workspace\\Myproject\\src\\file\\checkcoupon.txt", true));
			String m;
			while ((m = br1.readLine()) != null) {
				String[] data = m.split(",");
				if (data[4].equals(EMAIL)) {
					String m2;
					int count1 = 0, count2 = 0;
					while ((m2 = br2.readLine()) != null) {
						count1++;
						if (m2.equals(EMAIL)) {
							bw1.close();
							br2.close();
							br1.close();
							return false;
						} else
							count2++;
					}
					if (count1 == count2) {
						bw1.write(EMAIL);
					}
				}
			}
			bw1.close();
			br2.close();
			br1.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}// end chkCoupon

	public String chkData(String FNAME, String LNAME, String EMAIL, String PASS1, String PASS2, String ID, String DL) {
		try {
			if (FNAME.equals("") || LNAME.equals("") || EMAIL.equals("") || PASS1.equals("") || PASS2.equals("")
					|| ID.equals("") || DL.equals(""))
				return "blank";

			EMAIL = EMAIL.toLowerCase();
			if (EMAIL.startsWith("@") || EMAIL.contains(" ")
					|| !(EMAIL.endsWith("@hotmail.com")) && !(EMAIL.endsWith("@gmail.com")))
				return "email";

			if (PASS1.length() < 6 || PASS2.length() < 6) {
				return "shortPassword";
			}

			if (!PASS1.equals(PASS2))
				return "password";

			if (ID.length() == 13) {
				for (int i = 0; i < 13; i++) {
					if (!Character.isDigit(ID.charAt(i)))
						return "ID";
				}
			} else
				return "ID";

			if (DL.length() == 8) {
				for (int i = 0; i < 8; i++) {
					if (!Character.isDigit(DL.charAt(i)))
						return "DL";
				}
			} else
				return "DL";

			BufferedReader br = new BufferedReader(
					(new FileReader("E:\\eclipse\\workspace\\Myproject\\src\\file\\register.txt")));
			String read;
			while ((read = br.readLine()) != null) {
				String[] data = read.split(",");
				if (data[2].equals(ID) || data[3].equals(DL)||data[4].equals(EMAIL)) {
					br.close();
					return "file";
				}
			}
			br.close();
			return "correct";

		} catch (Exception e) {
			return "file";
		}

	}
	

}
