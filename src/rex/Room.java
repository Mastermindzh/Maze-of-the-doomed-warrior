package rex;

import java.util.ArrayList;
import java.util.Random;

public class Room {

	// declare variables
	private String description;
	private int east;
	private int north;
	private int south;
	private int west;
	private int roomnumber;
	private String rex;
	private String visited;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Enemy> myEnemies = new ArrayList<Enemy>();
	Enemies my_Enemies = new Enemies();

	// constructor met alle gegevens + deuren
	public Room(String rex, String description, int roomnumber, int north,
			int east, int south, int west) {
		setRex(rex);
		setRoomnumber(roomnumber);
		setDescription(description);
		setEast(east);
		setNorth(north);
		setWest(west);
		setSouth(south);
		generateEnemy();
	}

//  Do damage to the player
	public int hitPlayer(String name){
		int returnint = 0;
		//Check which enemy does the damge
		for (Enemy e: myEnemies){
//			Split the name so you only search on first name
			String[] namesplit = name.split(" ");
//			if first name, or full name is found
			if (namesplit[0].toLowerCase().equals(name) || e.getName().toLowerCase().equals(name)){
//				call the dodamage void.
				returnint = e.doDamage();
			}
		}
		return returnint;
	}
	
	//check if a specific enemy is alive (by name)
	public boolean checkAlive(String name){
		boolean isalive = false;
//		Look through all enemies in a room
		for(Enemy e: myEnemies){//split de naam, zodat het werkt op alleen de voornaam
			String[] namesplit = e.getName().split(" ");

			if (namesplit[0].toLowerCase().equals(name) || e.getName().toLowerCase().equals(name)) {
				if(e.isAlive()){// als hij levend is return dat hij levend is
				isalive = true;}
			}
		}
		
		return isalive;
	}
	
	
	// hit een enemy
	public void hitEnemy(String name, int damage) {
		// vind de juiste enemy in de array
		for (Enemy E : myEnemies) {
			String[] namesplit = E.getName().split(" ");

			if (namesplit[0].toLowerCase().equals(name) || E.getName().toLowerCase().equals(name)) {
//				Als de enemy levend is
				if (E.isAlive()) {
					System.out
							.println("Goggan: Thats it master! hit the sucker!");
//					Maak een random damage getal
					Random rnd_dmg = new Random();
					int dmg = rnd_dmg.nextInt(damage + 1);
//					Als de current hp - het gemaakte damage getal 1 of hoger is dan
					if (E.getHp() - dmg > 0) {
//						breng de schade in rekening
						E.setHp(E.getHp() - dmg);
//						Print wat leuke info
						System.out.println(E.getName() + " has received " + dmg
								+ " points of damage");
						System.out.println(E.getName() + " has got "+ E.getHp() + " health points left.");
						break;
					} else {// Waarde < 1 , dus dood
						E.setHp(E.getHp() - dmg);
						E.setAlive(false);
						
						items.add(E.getloot());
						System.out.println("You killed " + E.getName());
					}
				} else {// Hij is al lang dood :P
					System.out.println("You already killed " + E.getName());
				}
				
			}
			else{// naam van villain niet goed getypt
				System.out.println("You have to type at least the monsters first name to attack");
			}
		}

	}

	// maak een nieuwe enemy in 40% van de gevallen
	public void generateEnemy() {
		// Genereer een random getal tussen 1 en 100
		Random rnd_gen = new Random();
		int random = rnd_gen.nextInt(100) + 1;
		// Als het getal lager is dan 40
		if (random < 40) {
			// voeg een random enemy toe uit de my_Enemies klas
			myEnemies.add(my_Enemies.randomizeEnemy());
		}

	}

	// Print info van de enemies in de kamer
	public void listEnemies() {
		// Controle of er wel enemies zijn
		if (myEnemies.size() > 0) {
			System.out.println();
			System.out.println("Goggan: Master! Master! There is an enemy in this room!:");
			// voer de void printInfo uit voor alle enemies in de arraylist
			for (Enemy e : myEnemies) {
				e.printInfo();
			}
		}
	}

	// Doe iets met de item
	public void doSpecial(String itemname) {
		switch (getRoomnumber()) {// bepaal om welke kamer het gaat

		case 1:
			if (itemname.equals("bonekey")) {// kijk of het juiste item is gebruikt, in de juiste kamer
				System.out.println("You open the chest with the BoneKey, and... nothing happened!");
			} else if (itemname.equals("endgameitem")) {
				winner();
				System.exit(0);
			}
			// Als item niet juist is
			else {
				System.out.println("You cannot use '" + itemname
						+ "' in this room.");
			}
			// if(itemname.equals(anObject))
			break;
			
		case 8:	if (itemname.equals("ring")){
			System.out.println("Gogann: My precious! My precious!");
			break;
		}
		// Als kamer niet juist is
		default:
			System.out.println("You cannot use '" + itemname
					+ "' in this room.");
			break;
		}
	}

	// Voeg een item toe aan de backpack
	public void addItem(String itemname, String usagetext) {
		// Maak een nieuw item
		Item i = new Item(itemname, usagetext);
		items.add(i);
	}

	// Geef alle items in de room
	public void getItems() {
		if (items.size() > 0) {
			System.out.println();
			System.out.println("Goggan: Master! Master! I have found items in this room:");
			for (Item i : items) {
				i.printItemInfo();
			}
		}
	}

	// verwijder een item uit een kamer.
	public void removeItem(String itemname) {
		for (Item i : items) {
			// Als itemnaam gelijk is aan naam van item in kamer
			if (i.getName().toLowerCase().equals(itemname.toLowerCase())) {
				items.remove(i);
				break;
			}
		}
	}

	// Return een item die je zoekt bij naam
	public Item transferItem(String itemname) {
		Item returnitem;
		for (Item i : items) {
			if (i.getName().toLowerCase().contains(itemname)) {
				returnitem = i;
				return returnitem;
			}
		}
		return null;
	}

	// voeg een item toe aan de kamer doormiddel van item
	public void dropInRoom(Item i) {
		items.add(i);
	}

	// Print room info
	public void listRoomInfo() {
		System.out.println();
		System.out.println("Here is everything I know about the room master:");
		System.out.println("We are in room: " + getRoomnumber());
		System.out.println();

		System.out.println(getDescription());
		System.out.println();
		checkdoors();
		getItems();
		listEnemies();
		System.out
				.println("=======================================================================");
	}

	// check welke deuren er zijn
	public void checkdoors() {
		System.out.println();
		String convertstring;
		// Check of er een deur is aan de oostzijde
		if (getEast() == 0) {
		} else {// als er een deur is doe dit:
			System.out.println("There is a door on the east side of the room");
			convertstring = "" + getEast();
			// Als de string getvisited het kamernummer in zich heeft, dan heb
			// je de kamer bezocht en krijg je het nummer te zien.
			if (getVisited().contains(convertstring)) {
				System.out.println("The door leads to room: " + getEast());
			} else {// Als de kamer nog niet bezocht is
				System.out.println("We haven't been through this door yet.");
			}

		}
		// Check of er een deur is aan de zuiderlijke zijde
		if (getSouth() == 0) {
		} else {// als er een deur is doe dit:
			System.out.println("There is a door on the south side of the room");
			convertstring = "" + getSouth();
			// Als de string getvisited het kamernummer in zich heeft, dan heb
			// je de kamer bezocht en krijg je het nummer te zien.
			if (getVisited().contains(convertstring)) {
				System.out.println("The door leads to room: " + getSouth());
			} else {// Als de kamer nog niet bezocht is
				System.out.println("We haven't been through this door yet.");
			}

		}
		// Check of er een deur is aan de westzijde
		if (getWest() == 0) {
		} else {// als er een deur is doe dit:
			System.out.println("There is a door on the west side of the room");
			convertstring = "" + getWest();
			// Als de string getvisited het kamernummer in zich heeft, dan heb
			// je de kamer bezocht en krijg je het nummer te zien.
			if (getVisited().contains(convertstring)) {
				System.out.println("The door leads to room: " + getWest());
			} else {// Als de kamer nog niet bezocht is
				System.out.println("We haven't been through this door yet.");
			}
		}
		// Check of er een deur is aan de noordzijde
		if (getNorth() == 0) {
		} else {// als er een deur is doe dit:
			System.out.println("There is a door on the north side of the room");
			convertstring = "" + getNorth();
			// Als de string getvisited het kamernummer in zich heeft, dan heb
			// je de kamer bezocht en krijg je het nummer te zien.
			if (getVisited().contains(convertstring)) {
				System.out.println("The door leads to room: " + getNorth());
			} else {// Als de kamer nog niet bezocht is
				System.out.println("We haven't been through this door yet.");
			}
		}
	}

	// Kijk of de item in de kamer ligt
	public boolean hasItem(String itemname) {
		boolean roomHasItem = false;
		for (Item i : items) {
			if (i.getName().toLowerCase().contains((itemname).toLowerCase())) {
				roomHasItem = true;
			}
		}
		return roomHasItem;
	}

	// void to print the 'You Won !' text
	private void winner() {
		System.out
				.println("YYYYYYY       YYYYYYY                                     WWWWWWWW                           WWWWWWWW                                      !!! ");
		System.out
				.println("Y:::::Y       Y:::::Y                                     W::::::W                           W::::::W                                     !!:!!");
		System.out
				.println("Y:::::Y       Y:::::Y                                     W::::::W                           W::::::W                                     !:::!");
		System.out
				.println("Y::::::Y     Y::::::Y                                     W::::::W                           W::::::W                                     !:::!");
		System.out
				.println("YYY:::::Y   Y:::::YYYooooooooooo   uuuuuu    uuuuuu        W:::::W           WWWWW           W:::::W ooooooooooo   nnnn  nnnnnnnn         !:::!");
		System.out
				.println("   Y:::::Y Y:::::Y oo:::::::::::oo u::::u    u::::u         W:::::W         W:::::W         W:::::Woo:::::::::::oo n:::nn::::::::nn       !:::!");
		System.out
				.println("    Y:::::Y:::::Y o:::::::::::::::ou::::u    u::::u          W:::::W       W:::::::W       W:::::Wo:::::::::::::::on::::::::::::::nn      !:::!");
		System.out
				.println("     Y:::::::::Y  o:::::ooooo:::::ou::::u    u::::u           W:::::W     W:::::::::W     W:::::W o:::::ooooo:::::onn:::::::::::::::n     !:::!");
		System.out
				.println("      Y:::::::Y   o::::o     o::::ou::::u    u::::u            W:::::W   W:::::W:::::W   W:::::W  o::::o     o::::o  n:::::nnnn:::::n     !:::!");
		System.out
				.println("       Y:::::Y    o::::o     o::::ou::::u    u::::u             W:::::W W:::::W W:::::W W:::::W   o::::o     o::::o  n::::n    n::::n     !:::!");
		System.out
				.println("       Y:::::Y    o::::o     o::::ou::::u    u::::u              W:::::W:::::W   W:::::W:::::W    o::::o     o::::o  n::::n    n::::n     !!:!!");
		System.out
				.println("       Y:::::Y    o::::o     o::::ou:::::uuuu:::::u               W:::::::::W     W:::::::::W     o::::o     o::::o  n::::n    n::::n      !!! ");
		System.out
				.println("       Y:::::Y    o:::::ooooo:::::ou:::::::::::::::uu              W:::::::W       W:::::::W      o:::::ooooo:::::o  n::::n    n::::n          ");
		System.out
				.println("    YYYY:::::YYYY o:::::::::::::::o u:::::::::::::::u               W:::::W         W:::::W       o:::::::::::::::o  n::::n    n::::n      !!! ");
		System.out
				.println("    Y:::::::::::Y  oo:::::::::::oo   uu::::::::uu:::u                W:::W           W:::W         oo:::::::::::oo   n::::n    n::::n     !!:!!");
		System.out
				.println("    YYYYYYYYYYYYY    ooooooooooo       uuuuuuuu  uuuu                 WWW             WWW            ooooooooooo     nnnnnn    nnnnnn      !!! ");
	}

	// Getters and setters
	public void setDescription(String description) {
		this.description = description;
	}

	public int getEast() {
		return east;
	}

	public void setEast(int east) {
		this.east = east;
	}

	public int getNorth() {
		return north;
	}

	public void setNorth(int north) {
		this.north = north;
	}

	public int getSouth() {
		return south;
	}

	public void setSouth(int south) {
		this.south = south;
	}

	public int getWest() {
		return west;
	}

	public void setWest(int west) {
		this.west = west;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getDescription() {
		System.out.println("The moment we entered the room REX said: ");
		System.out.println("REX:" + getRex());
		System.out.println();
		System.out.println("Here is a small description about the room:");
		return description;

	}

	public String getVisited() {
		return visited;
	}

	public void setVisited(String visited) {
		this.visited = visited;
	}

	public String getRex() {

		return rex;
	}

	public void setRex(String rex) {
		this.rex = rex;
	}

}
