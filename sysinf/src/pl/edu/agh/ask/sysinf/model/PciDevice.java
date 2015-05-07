package pl.edu.agh.ask.sysinf.model;

public class PciDevice {

	private String type;
	private String company;
	private String name;

	public PciDevice(String type, String company, String name) {
		this.type = type;
		this.company = company;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getCompany() {
		return company;
	}

	public String getName() {
		return name;
	}
}
