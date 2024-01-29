import java.util.LinkedList;

public class Photo {

	private int weekNum;
	private String ActivityName;
	private int amtPhotos;
	private LinkedList<Linker> link;

	
	
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
				+ "<div id = content>\n"
				+ "\t<p>" + "<u>Week " + weekNum + ":</u> " + ActivityName + "\n"
				+ "</div>\n");
		
		for(int i = 0; i < amtPhotos; i++) {
			retVal += "<div id = content>\n"
					+ "\t<div id = text>\n"
					+ "\t\t<p>" + link.get(i).getDescription() + "</p>\n\t\t<br><br><br><br>\n\t\t<br><br><br><br>\n"
					+ "\t</div>\n"
					
					+ "\t\n<div id = image>\n"
					+ "\t\t <img class = gear src=\"images/" + link.get(i).getFile() + "\">\n"
					+ "\t</div>\n"
					+ "\n</div>\n\n";
			
			//retVal += "</p>\n<img class = gear src=\"images/" + link.get(i).getFile() + "\">";
			//retVal += "\n<p>" + link.get(i).getDescription() + "</p>\n";
		}		
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
