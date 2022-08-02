package TeamRCBTest;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TeamRCB.TeamRCBPage;

public class TeamRCBTest{
	TeamRCBPage teamRCBPage;
	
	@Test(dataProvider="dp")
	void verifyTeamHasOnly4ForaignPlayers(String data) {
		String rcbPlyaers[]=data.split(",");
		teamRCBPage = new TeamRCBPage();
		int countF = teamRCBPage.isTeamHasOnly4ForaignPlayers(rcbPlyaers[1]);
		Assert.assertEquals(1, countF);
	}
	@Test(dataProvider="dp")
	void verifyTeamHasOnly1WicketKeeper(String data) {
		String rcbPlyaers[]=data.split(",");
		teamRCBPage = new TeamRCBPage();
		int countW = teamRCBPage.isTeamHasAtleast1WicketKeeper(rcbPlyaers[2]);
		Assert.assertEquals(1, countW);
	}
	

	@DataProvider(name="dp")
	public String [] readjson() throws IOException, ParseException ,NullPointerException
	{
		JSONParser jSONParser = new JSONParser ();
		FileReader reader = new FileReader(".\\jsonfiles\\teamrcb.json");
		Object javaObj=jSONParser.parse(reader);
		JSONObject teamRcbJSONObject=(JSONObject)javaObj;
		JSONArray teamRcbJSONArray=(JSONArray)teamRcbJSONObject.get("player");
		String arr[]= new String[teamRcbJSONArray.size()];
		for (int i =0;i<teamRcbJSONArray.size();i++) {
			JSONObject player=(JSONObject)teamRcbJSONArray.get(i);
			String playername=(String)player.get("name");
			String countryname=(String)player.get("country");
			String role=(String)player.get("role");
			arr[i]= playername+","+countryname+","+role;	
		}
	return arr;
			
	}
}
