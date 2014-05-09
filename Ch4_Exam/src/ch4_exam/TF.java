package ch4_exam;


public class TF {
	public String name;
	public String roll;
	public String gender;
	public TF(String name, String roll, String gender) {
		this.name = name;
		this.roll = roll;
		this.gender = gender;
	}
	public static TF[] example() {
		return new TF[] {
				new TF("Ice", "Master", "M"),
				new TF("Jason", "VDI", "M"),
				new TF("Chris", "TF", "M"),
				new TF("Cion", "TF", "M"),
				new TF("Reina", "Design", "F"),
				new TF("Paulus", "VDI", "M")};

	}
	
}
