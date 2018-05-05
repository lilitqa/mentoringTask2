package products;

import Exception.CalorieException;

public abstract class Vegetable extends Products {
	// Is this correct to declare weight and calorie in Vegetable class not in
	// the Product class??
	private double weight;// g
	private double calorie;// for 100g

	public Vegetable(String name, double weight) {
		super(name);
		if (weight <= 0)
			throw new IllegalArgumentException("Weight shoud be more than 0.");
		this.weight = weight;
	}

	public void setCalorie(double calorie) {
		if (calorie < 0)
			throw new IllegalArgumentException();
		else
			this.calorie = calorie;
	}

	public double getCalorie() {
		return calorie;
	}

	public double getWeight() {
		return weight;
	}

	public Vegetable getPiece(Vegetable vegetable, double piece) {

		vegetable.weight *= piece;// no need to calculate calorie
		return vegetable;

	}

	public double calculateCalorie() throws CalorieException {
		try {
			if (calorie == 0)
				throw new CalorieException();
			return (calorie * weight) / 100;// 100g
		} catch (ArithmeticException ex) {
			return 0.1;
		}
	}

}
