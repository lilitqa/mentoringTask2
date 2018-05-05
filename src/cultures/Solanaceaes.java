package cultures;

import products.Products;
import products.Vegetable;

public class Solanaceaes extends Vegetable{

	
// is it ok always call super constructor //inherited 
	public Solanaceaes(String name, double weight) {
		super(name, weight);
		
	}

	@Override
	public void chopUp(Products products) {
		
	}

}
