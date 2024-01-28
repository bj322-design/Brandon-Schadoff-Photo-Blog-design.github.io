import java.util.LinkedList;

public class Photo {

	private int weekNum;
	private String ActivityName;
	int amtPhotos;
	LinkedList<Linker> link;
	
	public Photo(int WN, String AC, int AMT, LinkedList<Linker> l) {
		this.weekNum = WN;
		this.ActivityName = AC;
		this.amtPhotos = AMT;
		link = l;
	}
	
	
	public int getWeekNum() {
		return weekNum;
	}
	
	
	public String toStringHTML() {
		
		String retVal = ("<br>\n<br>\n"
				+ "<div id = car>\n"
				+ "<p>" + "<u>Week " + weekNum + "</u>");
		
		for(int i = 0; i < amtPhotos; i++) {
			retVal += "</p>\n<img class = gear src=\"images/" + link.get(i).getFile() + "\">";
			retVal += "\n<p>" + link.get(i).getDescription() + "</p>\n";
		}		
		
		retVal += "\n</div>\n";
		return retVal;
	}
	
	public String toString() {
		String retVal = ("Week " + weekNum + ": " + ActivityName + "\n"
				+ "AMT Photos" + amtPhotos + "\n");
		
		for(int i = 0; i < amtPhotos; i++) {
			retVal += link.toString();
		}
		
		return retVal;
	}
}
