package rex;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {
	// variabelen aanmaken
	private String name;
	private String description;
	private int hp;
	private int base_dmg;
	private boolean alive = true;
	private String categorie;
	private ArrayList<Item> loot = new ArrayList<Item>();
	private Loot myloot = new Loot();

	public Enemy(String name, String description, int hp, int base_dmg, String categorie) {
		setName(name);
		setDescription(description);
		setHp(hp);
		setBase_dmg(base_dmg);
		setCategorie(categorie);
			loot.add(myloot.randomizeLoot());
		}
			
	//print alle info van de enemy
	public void printInfo() {
		System.out.println();
		System.out.println("************* Enemy Information****************");
		System.out.println("* Name: " + getName());
		System.out.println("* Description: " + getDescription());
		System.out.println("* Category: " + getCategorie());
		System.out.println("* Health: " + hp);
		System.out.println("* Base_dmg: " + getBase_dmg());
		
		if(isAlive()){System.out.println("* Status: Alive");}
		else{System.out.println("* Status: Deceased");}
		System.out.println("***********************************************");
	}

// return the loot item
	public Item getloot(){
		Item returnitem = null;
		for(Item i: loot){
			returnitem = i;
			break;
		}
		
		return returnitem;
	}

	
	
	public int doDamage(){
		int endDamage = 0;
//		Maak random getal op basis van de base_dmg, en val daarmee aan
		Random rnd_dmg = new Random();
		endDamage = rnd_dmg.nextInt(getBase_dmg() + 1);
		return endDamage;
	}
	// getters and setters

	public String getName() {
		return name;
	}

	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getBase_dmg() {
		return base_dmg;
	}

	public void setBase_dmg(int base_dmg) {
		this.base_dmg = base_dmg;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
