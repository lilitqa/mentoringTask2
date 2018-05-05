package vegetables;

import cultures.Solanaceaes;

public class Pepper extends Solanaceaes {

	public Pepper(String name, double weight) {
		super(name, weight);
		super.setCalorie(20);// for 100g
	}

}
