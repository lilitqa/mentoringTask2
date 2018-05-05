package dataReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class ReadFromJson extends DataReader {
	private String path = "../mentoringTask2/IO/json.json";

	private JSONParser parser;
	private JSONObject jsonObject ;

	@Override
	public void connect() {
		Object obj;
		parser = new JSONParser();

		try {
			obj = parser.parse(new FileReader(path));
			jsonObject = (JSONObject) obj;
		} catch (Exception ex) {

		}
	}
	
	public JSONObject getJson(){
		return jsonObject;
	}
}
