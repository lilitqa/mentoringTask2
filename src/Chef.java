import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.ElementNotFoundException;
import Salads.MyImprovisation;
import Salads.Salad;
import dataReader.ReadFromDB;
import dataReader.ReadFromJson;

public class Chef {
	public static void main(String[] args) throws ElementNotFoundException {
		MyImprovisation mySalad = new MyImprovisation();
		try {
			// Part 1
			mySalad.create();

			mySalad.getInformation();
		} catch (Exception e) {

			e.printStackTrace();
		}

		// Part 2
		Speed speed = new Speed();
		speed.checkSpeedOfArrayList();
		speed.checkSpeedOfLinkedList();
		speed.checkSpeedDeleteOfArrayList();
		speed.checkSpeedDeleteOfLinkedList();
		speed.checkSpeedGetOfArrayList();
		speed.checkSpeedGetOfLinkedList();

		// Task 3 Part 1
		mySalad.getException();

		// Task 3 Part 2

		mySalad.writeRecipe(mySalad.getName(), mySalad.getListOfProducts());
		mySalad.readFromRecipe(mySalad.getName());

		// Task 4 Part 1: Read from DB(PostgreSql)
		ReadFromDB db = new ReadFromDB();
		try {

			db.connect();
			ResultSet rs = db.executeQuery("SELECT \"ID\", \"ProductName\" FROM public.salad;");

			while (rs.next()) {
				System.out.println(rs.getString("ProductName"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.close();

		}

		// Task 4 Part 2: Read from json file
		ReadFromJson json = new ReadFromJson();
		json.connect();
		System.out.println(json.getJson().toJSONString());

	}

}
