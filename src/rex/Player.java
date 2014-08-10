package rex;

// import arraylist for backpack & scanner for input
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

	// maak de variabele aan
	private int currentroom = 1;
	Scanner inputScanner = new Scanner(System.in);
	private String name;
	private ArrayList<Item> backpack = new ArrayList<Item>();
	private boolean hasTeleported = false;
	private int HP = 100;
	private int base_dmg = 18;
	private int lives = 3;

	// constructor die meteen de naam opslaat.
	public Player(String naam) {
		setName(naam);
	}

	// Schade aan de speler
	public void TakeDamage(int damage) {
		//kijk of de speler overlijd aan de klap, zoniet haal de damage van de hp
		if (getHP() - damage > 0) {
			setHP(getHP() - damage);
		} else {//als de speler dood gaat kijk dan of hij nog levens heeft
			if (getLives() >= 1) {
				//er zijn nog levens, dan teleporteer naar de eerste kamer
				System.out
						.println("You have died, and will be teleported to the first room.");
				setLives(getLives() - 1);
				setCurrentroom(1);
				System.out.println("You have " + getLives() + "lives left");
			} else {//geen levens over? -> game over!
				gameOver();
				System.exit(0);
			}
		}
	}

	// Doe iets als je IN een kamer komt (room_enter_event)
	public void DoRoomSpecial() {
		switch (getCurrentroom() + 1) {// bepaal om welke kamer het gaat

		case 4:
			Random rnd = new Random();
			int randomgetal = rnd.nextInt(13);
			System.out.println("*********************************************");
			System.out.println("* You are being teleported to a random room *");
			System.out.println("*********************************************");
			System.out
					.println("=======================================================================");

			setHasTeleported(true);
			setCurrentroom(randomgetal);
		default:
			break;
		}

	}

	// Transfer een item, deze void geeft een item terug die je dan kan
	// gebruiken
	public Item transferItem(String itemname) {
		Item returnitem;
		for (Item i : backpack) {
			// Check of item in rugzak zit
			if (i.getName().toLowerCase().contains(itemname)) {
				returnitem = i;
				return returnitem;
			}
		}
		// Return null als de item niet in de backpack zit
		return null;
	}

	// Stop het item dat meegegeven wordt in de backpack
	public void addTobackpack(Item i) {
		backpack.add(i);
	}

	// Deze void print de inhoud van de backpack in het console
	public void printBackpack() {
		if (backpack.size() > 0) {// check of backpack groter is dan 0
			System.out.println("I shall open the backpack for you master.");
			System.out.println("Your backpack contains:");
			// Doe voor alle items: printItemInfo
			for (Item i : backpack) {
				i.printItemInfo();
			}
		} else {// Als er geen items in de backpack zitten
			System.out
					.println("Your backpack is mighthy empty, we should steal some stuff fast!");
		}
	}

	// Kijk of de player een item in zijn backpack heeft
	public boolean hasItem(String itemname) {
		boolean roomHasItem = false;
		// Kijk voor elk item in de backpack of het item bestaat (door de naam
		// te vergelijken)
		for (Item i : backpack) {
			if (i.getName().toLowerCase().equals((itemname).toLowerCase())) {
				roomHasItem = true;
			}
		}
		return roomHasItem;
	}

	// Voeg een item toe met naam en usagetext
	public void addItem(String itemname, String usagetext) {
		Item i = new Item(itemname, usagetext);
		backpack.add(i);
	}

	// Verwijder een item uit de backpack op naam
	public void removeItemFromBackpack(String itemname) {
		for (Item i : backpack) {
			if (i.getName().toLowerCase().equals(itemname)) {
				backpack.remove(i);
				break;
			}
		}
	}

	// getters and setters
	public ArrayList<Item> getBackpack() {
		return backpack;
	}

	public void setBackpack(ArrayList<Item> backpack) {
		this.backpack = backpack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// check if name isn't empty
		if (name.equals(null)) {
			System.out.println("Please choose a better name:");
			// Ask for a new, valid, name
			setName(inputScanner.nextLine());
		} else {
			this.name = name;
		}
	}

	public int getCurrentroom() {
		return currentroom - 1;
	}

	public void setCurrentroom(int currentroom) {
		this.currentroom = currentroom;
	}

	public boolean isHasTeleported() {
		return hasTeleported;
	}

	public void setHasTeleported(boolean hasTeleported) {
		this.hasTeleported = hasTeleported;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getBase_dmg() {
		return base_dmg;
	}

	public void setBase_dmg(int base_dmg) {
		this.base_dmg = base_dmg;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	//Void to print the 'Game over' text
	private void gameOver(){
		System.out.println("        GGGGGGGGGGGGG                                                                     OOOOOOOOO");
		System.out.println("     GGG::::::::::::G                                                                   OO:::::::::OO ");
		System.out.println("   GG:::::::::::::::G                                                                 OO:::::::::::::OO    ");
		System.out.println("  G:::::GGGGGGGG::::G                                                                O:::::::OOO:::::::O ");
		System.out.println(" G:::::G       GGGGGG aaaaaaaaaaaaa     mmmmmmm    mmmmmmm      eeeeeeeeeeee         O::::::O   O::::::vvvvvvv           vvvvvvveeeeeeeeeeee   rrrrr   rrrrrrrrr ");
		System.out.println("G:::::G               a::::::::::::a  mm:::::::m  m:::::::mm  ee::::::::::::ee       O:::::O     O:::::Ov:::::v         v:::::ee::::::::::::ee r::::rrr:::::::::r ");
		System.out.println("G:::::G               aaaaaaaaa:::::am::::::::::mm::::::::::me::::::eeeee:::::ee     O:::::O     O:::::O v:::::v       v:::::e::::::eeeee:::::er:::::::::::::::::r ");
		System.out.println("G:::::G    GGGGGGGGGG          a::::am::::::::::::::::::::::e::::::e     e:::::e     O:::::O     O:::::O  v:::::v     v:::::e::::::e     e:::::rr::::::rrrrr::::::r");
		System.out.println("G:::::G    G::::::::G   aaaaaaa:::::am:::::mmm::::::mmm:::::e:::::::eeeee::::::e     O:::::O     O:::::O   v:::::v   v:::::ve:::::::eeeee::::::er:::::r     r:::::r");
		System.out.println("G:::::G    GGGGG::::G aa::::::::::::am::::m   m::::m   m::::e:::::::::::::::::e      O:::::O     O:::::O    v:::::v v:::::v e:::::::::::::::::e r:::::r     rrrrrrr");
		System.out.println("G:::::G        G::::Ga::::aaaa::::::am::::m   m::::m   m::::e::::::eeeeeeeeeee       O:::::O     O:::::O     v:::::v:::::v  e::::::eeeeeeeeeee  r:::::r ");
		System.out.println(" G:::::G       G::::a::::a    a:::::am::::m   m::::m   m::::e:::::::e                O::::::O   O::::::O      v:::::::::v   e:::::::e           r:::::r ");
		System.out.println("  G:::::GGGGGGGG::::a::::a    a:::::am::::m   m::::m   m::::e::::::::e               O:::::::OOO:::::::O       v:::::::v    e::::::::e          r:::::r    ");
		System.out.println("   GG:::::::::::::::a:::::aaaa::::::am::::m   m::::m   m::::me::::::::eeeeeeee        OO:::::::::::::OO         v:::::v      e::::::::eeeeeeee  r:::::r    ");
		System.out.println("     GGG::::::GGG:::Ga::::::::::aa:::m::::m   m::::m   m::::m ee:::::::::::::e          OO:::::::::OO            v:::v        ee:::::::::::::e  r:::::r      ");
		System.out.println("        GGGGGG   GGGG aaaaaaaaaa  aaammmmmm   mmmmmm   mmmmmm   eeeeeeeeeeeeee            OOOOOOOOO               vvv           eeeeeeeeeeeeee  rrrrrrr   ");
	}
}
