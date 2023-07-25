package fr.net.asclepiosh.outilcalculgreve.model;

public class Transporteurs {

	public String code;
	private String name;

	public Transporteurs() {

	}

	public Transporteurs(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString()  {
		return this.name;
	}


}
