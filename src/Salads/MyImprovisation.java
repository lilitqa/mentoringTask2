package Salads;

import Exception.CalorieException;
import Exception.ElementNotFoundException;
import Exception.OverweightException;
import products.Vegetable;
import vegetables.*;

public class MyImprovisation {
	Salad mySalad;

	public MyImprovisation(){
		mySalad = new Salad("Improvision");
	}
	
	public String getName(){
		return mySalad.getName();
	}
	
	/**
	 * Make a salad
	 */
	public void create() {
		
		try {
			Cucumber cucumber = new Cucumber("BurplessCucumber", 500);
			Carrot carrot = new Carrot("BoleroCarrot", 200);
			
			cucumber = (Cucumber) cucumber.getPiece(cucumber, 0.5);		

			mySalad.addProducts(cucumber);
			mySalad.addProducts(carrot);
			mySalad.mixSalad();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getInformation() throws CalorieException, OverweightException  {
		System.out.println("Overall calorie is: " + mySalad.calculateCalorie());
		mySalad.sortProductsByCalories();
		mySalad.sortProductsByName();
		mySalad.findProductssByCalories(0, 80);	
		 
	}
	
	public void getException() throws ElementNotFoundException{
		mySalad.findProductsByName("Bolero");
		mySalad.findProductsByIndex(2);
	}
	
	public void writeRecipe(String name, String productsList){
		mySalad.writeRecipe(name, productsList);
	}
	
	public void readFromRecipe(String name){
		mySalad.readFromRecipe(name);
	}
	
	public String getListOfProducts(){		
		String productsList = "";
		for(Vegetable veg : mySalad.getProducts()){
			productsList += " "+veg.getName()+":"+veg.getWeight()+" ";
		}
		return productsList;
	}

}
