/* 
 * Auteur: Rick van Lieshout
 * 
 * 
 * */

package rex;
//importeer de scanner
import java.util.Scanner;
import java.util.ArrayList;
public class Game {
	
//  Declareer alle variabelen
	private Player myPlayer;
	private int roomCounter = 0;
	private Scanner inputScanner = new Scanner(System.in);
//  Maak een array van 13 kamers
	private Room[] myRooms = new Room[13];
	private String visited = "1";

//  Constructor van Game class
		public Game() {
		//start de game
		//maak de kamers en vul ze
		createRooms();		
		fillRooms();
		
		//Fancy ascii art :D
		System.out.println("RRRRRRRRRRRRRRRRR                                                                  ");
		System.out.println("R::::::::::::::::R                                                                ");
		System.out.println("R::::::RRRRRR:::::R                                                              ");
		System.out.println("RR:::::R     R:::::R                                            ");
		System.out.println("  R::::R     R:::::R   ooooooooooo      ooooooooooo      mmmmmmm    mmmmmmm         ");
		System.out.println("  R::::R     R:::::R oo:::::::::::oo  oo:::::::::::oo  mm:::::::m  m:::::::mm        ");
		System.out.println("  R::::RRRRRR:::::R o:::::::::::::::oo:::::::::::::::om::::::::::mm::::::::::m     ");
		System.out.println("  R:::::::::::::RR  o:::::ooooo:::::oo:::::ooooo:::::om::::::::::::::::::::::m ");
		System.out.println("  R::::RRRRRR:::::R o::::o     o::::oo::::o     o::::om:::::mmm::::::mmm:::::m ");
		System.out.println("  R::::R     R:::::Ro::::o     o::::oo::::o     o::::om::::m   m::::m   m::::m");
		System.out.println("  R::::R     R:::::Ro::::o     o::::oo::::o     o::::om::::m   m::::m   m::::m");
		System.out.println("  R::::R     R:::::Ro::::o     o::::oo::::o     o::::om::::m   m::::m   m::::m");
		System.out.println("RR:::::R     R:::::Ro:::::ooooo:::::oo:::::ooooo:::::om::::m   m::::m   m::::m");
		System.out.println("R::::::R     R:::::Ro:::::::::::::::oo:::::::::::::::om::::m   m::::m   m::::m");
		System.out.println("R::::::R     R:::::R oo:::::::::::oo  oo:::::::::::oo m::::m   m::::m   m::::m");
		System.out.println("RRRRRRRR     RRRRRRR   ooooooooooo      ooooooooooo   mmmmmm   mmmmmm   mmmmmm");
		System.out.println("");
	
		System.out.println("EEEEEEEEEEEEEEEEEEEEEXXXXXXX       XXXXXXX                  lllllll ");
		System.out.println("E::::::::::::::::::::X:::::X       X:::::X                  l:::::l  ");
		System.out.println("E::::::::::::::::::::X:::::X       X:::::X                  l:::::l");
		System.out.println("EE::::::EEEEEEEEE::::X::::::X     X::::::X                  l:::::l ");
		System.out.println("  E:::::E       EEEEEXXX:::::X   X:::::XXppppp   ppppppppp   l::::l   ooooooooooo  rrrrr   rrrrrrrrr      eeeeeeeeeeee   rrrrr   rrrrrrrrr ");
		System.out.println("  E:::::E               X:::::X X:::::X  p::::ppp:::::::::p  l::::l oo:::::::::::oor::::rrr:::::::::r   ee::::::::::::ee r::::rrr:::::::::r ");
		System.out.println("  E::::::EEEEEEEEEE      X:::::X:::::X   p:::::::::::::::::p l::::lo:::::::::::::::r:::::::::::::::::r e::::::eeeee:::::er:::::::::::::::::r");
		System.out.println("  E:::::::::::::::E       X:::::::::X    pp::::::ppppp::::::pl::::lo:::::ooooo:::::rr::::::rrrrr::::::e::::::e     e:::::rr::::::rrrrr::::::r");
		System.out.println("  E:::::::::::::::E       X:::::::::X     p:::::p     p:::::pl::::lo::::o     o::::or:::::r     r:::::e:::::::eeeee::::::er:::::r     r:::::r");
		System.out.println("  E::::::EEEEEEEEEE      X:::::X:::::X    p:::::p     p:::::pl::::lo::::o     o::::or:::::r     rrrrrre:::::::::::::::::e r:::::r     rrrrrrr");
		System.out.println("  E:::::E               X:::::X X:::::X   p:::::p     p:::::pl::::lo::::o     o::::or:::::r           e::::::eeeeeeeeeee  r:::::r ");
		System.out.println("  E:::::E       EEEEEXXX:::::X   X:::::XXXp:::::p    p::::::pl::::lo::::o     o::::or:::::r           e:::::::e           r:::::r");
		System.out.println("EE::::::EEEEEEEE:::::X::::::X     X::::::Xp:::::ppppp:::::::l::::::o:::::ooooo:::::or:::::r           e::::::::e          r:::::r  ");
		System.out.println("E::::::::::::::::::::X:::::X       X:::::Xp::::::::::::::::pl::::::o:::::::::::::::or:::::r            e::::::::eeeeeeee  r:::::r");
		System.out.println("E::::::::::::::::::::X:::::X       X:::::Xp::::::::::::::pp l::::::loo:::::::::::oo r:::::r             ee:::::::::::::e  r:::::r");
		System.out.println("EEEEEEEEEEEEEEEEEEEEEXXXXXXX       XXXXXXXp::::::pppppppp   llllllll  ooooooooooo   rrrrrrr               eeeeeeeeeeeeee  rrrrrrr  ");
		System.out.println("                                          p:::::p ");
		System.out.println("                                          p:::::p");
		System.out.println("                                         p:::::::p");
		System.out.println("                                         p:::::::p");
		System.out.println("                                         p:::::::p");
		System.out.println("                                         ppppppppp");
//Einde fancy ascii art
				
		System.out.println("==================================================================================================");
		
		//Begin dialog
		System.out.println("Welcome to 'Room explorer', please enter your name:");
		//Create a player, and give it a name.
		myPlayer = new Player(inputScanner.nextLine());
		//Greet the player and give them a starting point.
		System.out.println("Nice to meet you, " + myPlayer.getName() + ". I am Goggan your AI helper(also a proud dwarf)" );
		System.out.println();
		System.out.println("It is time to begin your adventure!");
		System.out.println("Some of the example commands are: 'go', 'get' and 'use'");
		System.out.println("But you needn't worry, young traveler. Just type 'help' if you are stuck to get a full list of commands!");
		System.out.println("==================================================================================================");
		//end dialog
		
		//Enter the first room, so print the info
		System.out.println(myRooms[myPlayer.getCurrentroom()].getDescription());
		System.out.println();
		//run de run method
		run();
		
	}
	private void run() {
//		Try catch loop om de error af te vangen
		try {

//			Geef de ingevoerde waarde mee met handleCommand
			System.out.println("Goggan: I am eagerly awaiting your command, oh great master.");
			handleCommand(inputScanner.nextLine());

//			Vang de fout af.
		} catch (Exception E) {			//Print error information
			System.out.println("Something went terribly wrong.");
		}
//		Start de run method opnieuw.
		run();
	}
	
	//void om alle commands te handelen
		private void handleCommand(String userInput) {
			
			try {
//				Array maken van de userinput
				String[] words = userInput.split(" ");
								
//					Kijk wat het eerste woord is. (in kleine letters)
						switch(words[0].toLowerCase()){
					
//						Handle use, geef het 2de woord mee
						case "use": handleUseCommand(words[1]); break;

//						Handle go, geef het 2de woord mee
						case "go": 
							if(words.length > 1){
							handleGoCommand(words[1].toLowerCase());}
							else{System.out.println("Goggan: You have to specify which way you want to go, o great master. (north,east,south,west).");}
							break;
						case "get": 
							if(words.length > 1){
							handleGetCommand(words[1]); break;}
							else{System.out.println("Get what? Please use either one of these: 'North' 'South' 'East' 'West' "); break;}
						case "drop": handleDropCommand(words[1].toLowerCase());break;
//						handle all single word commands
						case "pack": myPlayer.printBackpack();break;
						case "look": handleLookCommand();break;
						case "smack": System.out.println("OUCH! Master why did you hit me?"); break;
						case "help": listCommands(); break;
//						print the gameover text and exit
						case "quit":gameOver(); System.exit(0); break;
						
						
						case "attack": 	handleAttackCommand(words[1].toLowerCase());break;
//						default message (als er iets anders wordt ingetypt.
						default: System.out.println("Oh master, I didn't understand that command I'm afraid :( ");break;
					}
//				print lege lijn om console netjes te houden			
				System.out.println();
				
			}
//			vang de fout af
			catch (Exception E){
				System.out.println("Something has gone wrong, please try again");
			}
		}
		
		private void handleAttackCommand(String name){
//			print een opmaak lijn
			System.out.println("=======================================================================");
//			Vertel de speler in welke kamers hij al is geweest
		
			myRooms[myPlayer.getCurrentroom()].hitEnemy(name, myPlayer.getBase_dmg());
			myPlayer.setHP(myPlayer.getHP() - myRooms[myPlayer.getCurrentroom()].hitPlayer(name));
			if(myRooms[myPlayer.getCurrentroom()].checkAlive(name)){
				System.out.println(".....");
			System.out.println("You are hit and have " + myPlayer.getHP() + " health left.");}
			//myPlayer.TakeDamage(myRooms[myPlayer.getcurrentroom()].)
		}
		
		private void handleLookCommand(){
//			geef string mee aan kamer waar player in is
			myRooms[myPlayer.getCurrentroom()].setVisited(visited);
//			print een opmaak lijn
			System.out.println("=======================================================================");
//			Vertel de speler in welke kamers hij al is geweest
			System.out.println("Goggan: We have visited the following rooms master:");
			System.out.println(visited);
//			Laat de kamer de rest van de info printen			
			myRooms[myPlayer.getCurrentroom()].listRoomInfo();
			
		}

		private void handleDropCommand(String command){
//			Als player het item heeft
			if (myPlayer.hasItem(command)){
				System.out.println("Why are you throwing things away master?!");
//				Voeg het item toe aan de kamer waar je nu in bent
				myRooms[myPlayer.getCurrentroom()].dropInRoom(myPlayer.transferItem(command));
//				Verwijder het item uit de backpack
				myPlayer.removeItemFromBackpack(command);
				}
//			Als speler het item niet heeft
			else{System.out.println("You don't have '" + command + "'.");}
		}
		private void handleGetCommand(String command){
			
			
//				Als het item in de kamer ligt
				if (myRooms[myPlayer.getCurrentroom()].hasItem(command)){
					System.out.println("Ooooh, Master has gained an item! And it's shiny!");
//					Voeg het item toe aan de backpack
					myPlayer.addTobackpack(myRooms[myPlayer.getCurrentroom()].transferItem(command));
//					Verwijder het item uit de kamer
					myRooms[myPlayer.getCurrentroom()].removeItem(command);
					}
				
			}
		private void handleUseCommand(String command){
//			Kijk of de kamer, of de speler, het item heeft.	
			if(myRooms[myPlayer.getCurrentroom()].hasItem(command) == true || myPlayer.hasItem(command) == true){
				System.out.println("You used: '" + command + "'");
//				Doe de speciale conditie van de kamer.
				myRooms[myPlayer.getCurrentroom()].doSpecial(command);
			}	
			else{// Als zowel de kamer als de speler het item niet heeft
				System.out.println("You don't have '" + command + "' in your backpack, and it's not in the room either");
			}
			
		}
		
//		Void om kamerinformatie te printen
	private void goRoom(String command){
		System.out.println("We are in room: " + myRooms[myPlayer.getCurrentroom()].getRoomnumber());
		System.out.println(myRooms[myPlayer.getCurrentroom()].getDescription());
//		Geef string van bezochte kamers mee
		myRooms[myPlayer.getCurrentroom()].setVisited(visited);
		myRooms[myPlayer.getCurrentroom()].checkdoors();
		myPlayer.DoRoomSpecial();
//		Kijk of de speler geteleporteerd heeft
		if(myPlayer.isHasTeleported()){
			myPlayer.setHasTeleported(false);
			System.out.println("We are in room: " + myRooms[myPlayer.getCurrentroom()].getRoomnumber());
			System.out.println(myRooms[myPlayer.getCurrentroom()].getDescription());
//			Geef string van bezochte kamers mee
			myRooms[myPlayer.getCurrentroom()].setVisited(visited);
			myRooms[myPlayer.getCurrentroom()].checkdoors();
		}
	}

		private void handleGoCommand(String command){
			System.out.println("=======================================================================");
			//switch om te kijken of het noord oost zuid of west is
			switch(command){
			case "north"://				Kijk of er in het noorden een deur is
				if (myRooms[myPlayer.getCurrentroom()].getNorth() == 0){System.out.println("You can't go north");break;}
				else{	//				Verander de currentroom van de speler		
					setVisited(command);
					myPlayer.setCurrentroom(myRooms[myPlayer.getCurrentroom()].getNorth());
					goRoom(command);
					break;
				}
			case "east"://				Kijk of er in het oosten een deur is
				if (myRooms[myPlayer.getCurrentroom()].getEast() == 0){System.out.println("You can't go East");break;}
				else{//				Verander de currentroom van de speler	
					setVisited(command);
					myPlayer.setCurrentroom(myRooms[myPlayer.getCurrentroom()].getEast());
					goRoom(command);		
					break;
				}
			case "south"://				Kijk of er in het zuide een deur is
				if (myRooms[myPlayer.getCurrentroom()].getSouth() == 0){System.out.println("You can't go South");break;}
				else{//				Verander de currentroom van de speler	
					setVisited(command);
					myPlayer.setCurrentroom(myRooms[myPlayer.getCurrentroom()].getSouth());
					goRoom(command);
				break;
				}	
			case "west": //				Kijk of er in het westen een deur is
				if (myRooms[myPlayer.getCurrentroom()].getWest() == 0){System.out.println("You can't go West");break;}
				else{//				Verander de currentroom van de speler	
					setVisited(command);
					myPlayer.setCurrentroom(myRooms[myPlayer.getCurrentroom()].getWest());
					goRoom(command);
					break;
				}
//				Command komt niet overeen met north, east, south, west.
			default:System.out.println("Please enter one of the following options: North, East, South, West") ; break;
			}
				
			System.out.println("===================================================================");
		}
		
		
		//Void om alle commands uit te printen in de console
		private void listCommands(){
			System.out.println();
			System.out.println("In this game you can use the following commands: ");
			System.out.println("use x: Every item has a use, so try 'using' an item.");
			System.out.println("go x: You can use the word 'go' to travel between rooms");
			System.out.println("get x: Get is used to pick up items");
			System.out.println("pack: Pack is used to examine all items in your backpack");
			System.out.println("look: Look at everything in the room");
			System.out.println("Smack: hit the AI dwarf");
			System.out.println("Attack x: This will attack a monster in the room(you only have to type his first name)");
			System.out.println("help: This list");
			System.out.println("quit: Quit the came");
		}
		
		
		
	private void addRoom(String rex, String description, int north, int east, int south,int west){
//		Kijken of de array nog plaats heeft voor een kamer
		if (getRoomCounter() >= myRooms.length){
			System.out.println("You have exceeded the maximum number of allowed rooms. So this one will be skipped");
		}
		else{
//			Kijken of er niet een verbinding wordt gemaakt met een kamer die niet bestaat.
			if(north > myRooms.length || north < 0 || east > myRooms.length || east < 0 || south > myRooms.length || south < 0 || west > myRooms.length || west< 0 ){
				System.out.println("You are trying to make a connection with a room that doesn't exist. Which of course can't be done.");
			}
			else{
//				Maak een nieuwe room en hoog de kamercounter op.
				myRooms[getRoomCounter()] = new Room( rex, description, getRoomCounter() + 1,  north,  east,  south, west);
				setRoomCounter(getRoomCounter()+ 1);
			}
		}
	}


		//void om kamers mee aan te maken
		private void createRooms(){
			//maak de kamers
			// description ,Kamernummer, north, east, south , west
			addRoom("Welcome to the first room in this game! Try to find your way out muahhahahah."
					,"This rooms looks like a pyramid, you can also see a mummy in the corner, and a chest of bones in the center."
					, 2, 0, 0, 0);
		    addRoom("You have found your way into the second room. This room is filled with..... SPIDERS! muhahahhahah"
		    		,"There are so many spiders in this room that you can't really see anything."
		    		, 5, 0, 1, 3);
		    addRoom("I hope you can swim, because this room is full of water. "
					,"This room is filled with water, don't forget to come up for air!"
					, 4, 2, 0, 0);
		    addRoom("Surprise surprise! This room is a giant synchole MUHAHAHHAHAHAH"
					,"In this room you will be teleported to another random room."
					, 0, 0, 3, 0);
		    addRoom("The darkness must not be breached"
					,"Darkness..."
					, 0, 6, 2, 0);
		    addRoom("OMG, are those mutilated bodies hanging from the wall? YES THEY ARE !!"
					,"A room filled with chopped up bodies."
					, 7, 0, 0, 5);
		    addRoom("Nothing to see here, move along."
					,"An empty room."
					, 0, 0, 6, 8);
		    addRoom("Fire, fire! quickly call: 0118 999 881 999 119 7253"
					,"This room is on fire"
					, 9, 7, 0, 0);
		    addRoom("It's time to kick ass and chew bubblegum, and I'm all outta gum"
					,"This room looks like a 'nukem' factory"
					, 10, 0, 8, 0);
		    addRoom("No dice, soldier."
					,"This room is filled with heavy weaponary"
					, 13, 11, 9, 12);
		    addRoom("Do. or Do not, there is no try","This room resembles a forest, also there is a steamy lake in it."
					, 0, 0, 0, 10);
		    addRoom("Follow me, or perish, sweater monkeys."
					,"This room looks like a jungle"
					, 0, 10, 0, 0);
		    addRoom("How dare you face me !? This will be the last of you!"
					,"This room is MASSIVE, it also has pictures of deceased previous players."
					, 0, 0, 10, 0);
		}
		
		//void om kamers items te geven
		private void fillRooms(){
//			arrayindex = kamernummer -1
			myRooms[0].addItem("BoneKey", "The Bone Key will open any 'Bone Chest'");	
//			Voeg 100 spinnen toe aan de 2de kamer (die gevuld is met spinnen)
			for(int i = 0; i<100;i++){
			myRooms[1].addItem("Spider", "Used to scare even the bravest of man");	
			}			
			myRooms[2].addItem("Pearl", "Useless, but valuable");	
			myRooms[4].addItem("Torch", "A lit torch, can be used to find your way out.");	
			myRooms[5].addItem("Leg", "A bloody leg.");	
			myRooms[6].addItem("Helmet", "A helmet worn by the citizens of Skyrim.");	
			myRooms[7].addItem("Ring","Use it in room 8.");
			myRooms[12].addItem("EndGameItem", " Bring this item to the first room and use it to win the game");
		
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
		
//getters and setters

	public int getRoomCounter() {
		return roomCounter;
	}

	public Player getMyPlayer() {
		return myPlayer;
	}
	public void setMyPlayer(Player myPlayer) {
		this.myPlayer = myPlayer;
	}
	public Scanner getInputScanner() {
		return inputScanner;
	}
	public void setInputScanner(Scanner inputScanner) {
		this.inputScanner = inputScanner;
	}
	public Room[] getMyRooms() {
		return myRooms;
	}
	public void setMyRooms(Room[] myRooms) {
		this.myRooms = myRooms;
	}
	public void setRoomCounter(int roomCounter) {
		this.roomCounter = roomCounter;
	}
	public String getVisited() {
		return visited;
	}

	public void setVisited(String direction) {
	switch(direction){
		case "north":
//			Maak van .getNorth een String
			String convertString = "" + myRooms[myPlayer.getCurrentroom()].getNorth();
//			Als de visited string het nummer van de kamer al in zich heeft, doe dan niks
			if (this.visited.contains(convertString)){			
			}			
			else{//				Anders, voeg kamernummer toe aan string visited.
				this.visited = getVisited() + "/" + myRooms[myPlayer.getCurrentroom()].getNorth();
			}
			break;
		case "east":
			convertString = "" + myRooms[myPlayer.getCurrentroom()].getEast();
//			Als de visited string het nummer van de kamer al in zich heeft, doe dan niks
			if (this.visited.contains(convertString)){
			}
			else{//				Anders, voeg kamernummer toe aan string visited.
				this.visited = getVisited() + "/" + myRooms[myPlayer.getCurrentroom()].getEast();
			}
			break;
		case "south":
			convertString = "" + myRooms[myPlayer.getCurrentroom()].getSouth();
//			Als de visited string het nummer van de kamer al in zich heeft, doe dan niks
			if (this.visited.contains(convertString)){
			}
			else{//				Anders, voeg kamernummer toe aan string visited.
				this.visited = getVisited() + "/" + myRooms[myPlayer.getCurrentroom()].getSouth();
			}break;
		case "west":
			convertString = "" + myRooms[myPlayer.getCurrentroom()].getWest();
//			Als de visited string het nummer van de kamer al in zich heeft, doe dan niks
			if (this.visited.contains(convertString)){
			}
			else{//				Anders, voeg kamernummer toe aan string visited.
				this.visited = getVisited() + "/" + myRooms[myPlayer.getCurrentroom()].getWest();
			}
			break;
		}
	}
	
}	
		

