package Salads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.*;

import Exception.CalorieException;
import Exception.ElementNotFoundException;
import Exception.OverweightException;
import products.Vegetable;
import static ch.lambdaj.Lambda.*;

public class Salad {
	
	private String name;
	private double calories;
	private List<Vegetable> products = new ArrayList<Vegetable>();
	
	public Salad(String name){
		this.name = name;
		calories = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public List<Vegetable> getProducts(){
		return products;
	}

	/**
	 * Mix the cutted products
	 */
	protected void mixSalad() {

	}
	
	/**
	 * Add products in salad's list
	 * @param product                                                           
	 */
	protected void addProducts(Vegetable product) {

		product.chopUp(product);
		products.add(product);

	}
	
	/**
	 * Calculates total calories in a salad
	 * @return calories 
	 * @throws CalorieException  
	 * @throws OverweightException 
	 */	
	public double calculateCalorie() throws CalorieException, OverweightException{
		calories = 0;
		System.out.println(name + " salad contain:");
		for(Vegetable veg : products){
			calories +=  veg.calculateCalorie();
			System.out.println(veg.getName());
		}
		
		if( calories > 1500)
			throw new OverweightException(calories);
		
		return calories;
	}		

	/**
	 * Find product to corresponding calories
	 * @param minCalorie The minimum border
	 * @param maxCalorie The maximum border
	 */
	public void findProductssByCalories(double minCalorie, double maxCalorie) {
		double calories;
		
		System.out.println("Show products in " + minCalorie + " - " + maxCalorie + " calories.");
		for (Vegetable vegetable : products) {
			calories = (vegetable.getCalorie()*vegetable.getWeight())/100;
			if (calories >= minCalorie && calories <= maxCalorie) {
				System.out.println(vegetable.getName() + ": " + vegetable.getCalorie() + " kk in 100g");
			}
		}		
	}
	
	/**
	 * Find product to corresponding name
	 * @param name
	 * @throws ElementNotFoundException 
	 */
	public void findProductsByName(String name) throws ElementNotFoundException {
		
		for (Vegetable vegetable : products) {
			if(vegetable.getName() == name)
				System.out.println(vegetable.getName() + ": " + vegetable.getCalorie() + " kk in 100g");
			else
				throw new ElementNotFoundException("There is no such element.");
			}				
	}
	
	/**
	 * Find product to corresponding index
	 * @param index
	 */
	public void findProductsByIndex(int index) {
		try {
			String name = products.get(index).getName();
			System.out.println("Products " + name + " .");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	/**
	 * Sort products by calories
	 */
	public void sortProductsByCalories(){
		List<Vegetable> sorted = sort(products, on(Vegetable.class).getCalorie());
		for (Vegetable vegetable : sorted) {
			System.out.println(vegetable.getCalorie() + ": " + vegetable.getName());
		}
		
	}
	
	/**
	 * Sort products by name
	 */
	public void sortProductsByName(){
		List<Vegetable> sorted = sort(products, on(Vegetable.class).getName());
		for (Vegetable vegetable : sorted) {
			System.out.println(vegetable.getName() + ": " + vegetable.getCalorie());
		}
		
	}
	
	/**
	 * Read recipe from file
	 * @param name
	 */
	public void readFromRecipe(String name){
		
		try(FileInputStream recipeBook = new FileInputStream ("../mentoringTask2/IO/"+name+".txt")){
			InputStreamReader istr = new InputStreamReader ( recipeBook ) ;
            BufferedReader buffreader = new BufferedReader ( istr ) ;
            int i = 0, size = 10;
			String row;			 
			String [][] infoArray = new String [size][];
			
			//Read from file
				while ((row = buffreader.readLine()) != null) {					
					infoArray[i] = row.split("\\s+");
					i++;					
				}
				size = i;
				
				for(i = 0; i< size; i++){
					for(int j = 0; j < infoArray[i].length; j++){					
					System.out.println(infoArray[i][j]);
					}
				}
				recipeBook.close();
			
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}

	
	}
	
	/**
	 * Write recipe into the file
	 * @param name Name of salad
	 * @param productsList 
	 */
	public void writeRecipe(String name, String productsList){
		File file = new File("../mentoringTask2/IO/"+name+".txt");
		
		try (FileOutputStream recipeBook = new FileOutputStream(file)) {

			// if file does not exists, then create new one
			if (!file.exists()) {
				file.createNewFile();
			}
			
			byte[] contentInBytes = (name + productsList).getBytes();
			recipeBook.write(contentInBytes);		
			recipeBook.flush();
			recipeBook.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
