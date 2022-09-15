
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TeamValidation {
	@Test
	public void teamVerification() throws ParseException, IOException {
		int fcount = 0;
		int actual = 1;
		int count = 0;
		FileReader team = new FileReader(
				"C:\\Users\\ELCOT\\eclipse-workspace\\CricketTeam\\src\\test\\resources\\team.json");

		JSONParser jsonparser = new JSONParser();

		Object object = jsonparser.parse(team);
		JSONObject Obj = (JSONObject) object;
		Object name = Obj.get("name");
		Object location = Obj.get("location");
		Object player = Obj.get("player");
		JSONArray arrayObj = (JSONArray) player;
		for (int i = 0; i < arrayObj.size(); i++) {
			Object a = arrayObj.get(i);
			JSONObject j = (JSONObject) a;
			Object name1 = j.get("name");
			Object country = j.get("country");
			Object role = j.get("role");
			if ((boolean) role.toString().equals("Wicket-keeper")) {
				count++;
			}
			if (!(boolean) country.toString().equals("India")) {
				fcount++;
			}
		}
		if (fcount == 4) {
			System.out.println("team contains only 4 foreign player");
		} else {
			System.out.println("team requires atleast 4 foreign player");
		}
		if (count >= 1) {
			System.out.println("team contains sufficient wicket keeper");
		} else {
			System.out.println("team requires atleast one wicket keeper");
		}
	}
}