package rex;

import java.util.ArrayList;
import java.util.Random;

public class Enemies {
	//maak een arraylist met mogelijke enemies
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	
	Random random = new Random();
	public Enemies(){
//	Name / description / hp / base dmg
//		orcs
	enemies.add(new Enemy("Praak the almighthy", "A vicous orc", 60, 7, "Orc"));
	enemies.add(new Enemy("Balo the brave", "A notoriously brave orc", 55, 6, "Orc"));
	enemies.add(new Enemy("Erugor the funny", "A funny looking orc", 50, 5, "Orc"));
//	Dragons
	enemies.add(new Enemy("Pronttikor the Fire Starter", "A truly powerful fire dragon", 85, 12, "Dragon"));
	enemies.add(new Enemy("Matgar the Green Eyed", "The most beautiful dragon in existance", 65, 7, "Dragon"));
	enemies.add(new Enemy("Bestore the Good Hearted", "A deceased dragon", 20, 5, "Dragon"));
	enemies.add(new Enemy("Awkor the Peacefull one", "Creating peace wherever he goes", 60, 7, "Dragon"));
	enemies.add(new Enemy("Lephisto the Dragon", "A simple one", 40, 3, "Dragon"));
	enemies.add(new Enemy("Arbo the Great Flame", "Talks to much", 25, 1, "Dragon"));
	enemies.add(new Enemy("Gretchen the Lightning Belower", "Hardstyle fan", 45, 2, "Dragon"));
	enemies.add(new Enemy("Meceron the Acid Breather", "A very devious dragon, armed to the 'teeth' with poisonous fangs", 45, 2, "Dragon"));
	enemies.add(new Enemy("Celtore the fire starter", "Always tries to start fires, never succeeds", 45, 6, "Dragon"));
	enemies.add(new Enemy("Drake the good hearted", "Harmless really", 45, 2, "Dragon"));
	enemies.add(new Enemy("Ashkoort the Good Hearted", "Harmless really", 45, 2, "Dragon"));
	
//	Skeletons
	enemies.add(new Enemy("Hellthought The Enraged", "Watch out! he's mad! He is also VERY boney", 15, 50, "Skeleton"));
	enemies.add(new Enemy("Killdemon The Smart", "A very smart, but weak skeleton", 80, 1, "Skeleton"));
	enemies.add(new Enemy("Flamechain", "A skeleton mage wielding a fiery chain", 60, 6, "Skeleton"));
	enemies.add(new Enemy("Skeleton warrior", "Will fight till he dies", 40, 8, "Skeleton"));
	enemies.add(new Enemy("Skeleton water mage", "Hurls bursts of water at you", 60, 6, "Skeleton"));
	enemies.add(new Enemy("Skeleton archer", "Lethal with a bow", 30, 10, "Skeleton"));
	enemies.add(new Enemy("Skeleton Thief", "Protect your bag!", 30, 10, "Skeleton"));
//	Animals
	enemies.add(new Enemy("Dog", "Domestic creature, but violent", 40, 3, "Animal"));
	enemies.add(new Enemy("Cat", "Very silly animal", 20, 1, "Animal"));
	enemies.add(new Enemy("Tiger", "A striped big motherfucking cat", 60, 6, "Animal"));
	enemies.add(new Enemy("Lion", "King of the jungle", 60, 6, "Animal"));
	enemies.add(new Enemy("Bear", "He looks very cute, but can kill you without breaking a sweat.", 70, 6, "Animal"));
	enemies.add(new Enemy("Wolf", "A slightly larger, wetter, and smellier dog", 50, 4, "Animal"));
	enemies.add(new Enemy("Hippo", "OMG! look at them teeth!", 120, 10, "Animal"));
	enemies.add(new Enemy("Mouse", "A tiny little mouse", 20, 1, "Animal"));
	
	}
	public Enemy randomizeEnemy(){
		Enemy e = null;
		Random rnd = new Random();
					e = enemies.get(rnd.nextInt(enemies.size()));
			return e;
	
	}
	
	
	
	
	
	
}
