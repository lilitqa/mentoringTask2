package products;

public abstract class Products {	
	
	private String name;	
	
	public Products(String name){
		if(name == "" || name == null)
			throw new NullPointerException();
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * Chop up the products. Not all products we can chop up in the same way
	 * @param quantity 
	 */
	public abstract void chopUp(Products products);

}
