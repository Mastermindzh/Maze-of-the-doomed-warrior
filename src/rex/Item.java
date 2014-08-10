package rex;

public class Item {

	//Maak variabelen aan
	private String name;
	private String usageText;


	//Constructor
	public Item(String name, String usageText) {
		setName(name);
		setUsageText(usageText);
	
	}

	//void om iteminfo te typen.
	public void printItemInfo(){
			System.out.println(getName() + " - " + usageText);
	}
	

	//getters & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsageText() {
		return usageText;
	}
	public void setUsageText(String usageText) {
		this.usageText = usageText;
	}

	
	
}
