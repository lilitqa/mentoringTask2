package vegetables;

import cultures.Solanaceaes;

public class Tomato extends Solanaceaes {

	public Tomato(String name, double weight) {
		super(name, weight);
		super.setCalorie(18);//for 100g
	}

}
