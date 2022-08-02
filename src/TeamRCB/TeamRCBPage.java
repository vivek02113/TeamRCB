package TeamRCB;

public class TeamRCBPage {
	int countF=0;
	int countW=0;
	public int isTeamHasOnly4ForaignPlayers(String data) {
		
		if (!data.equals("India")) {
			countF++;
		}
		return countF;
	}

	public int isTeamHasAtleast1WicketKeeper(String data) {
		if (data.equals("Wicket-keeper")) {		
			countW++;
		}
		return countW;
	}
}
