package rex;

import java.util.ArrayList;
import java.util.Random;


public class Loot {

	ArrayList<Item> loot = new ArrayList<Item>();
	
	
	Random random = new Random();
	public Loot(){
//	Name / description

	loot.add(new Item("Sword", "A sword, might be worth some coin back in town"));
	loot.add(new Item("Axe", "OMG it's really big. Isn't that what she said?"));
	loot.add(new Item("Sack of gold","Yup, you are rich now!"));
	loot.add(new Item("Globe","NOPE!, no map of the dungeon hahahha"));
	loot.add(new Item("Green goo","Yuck!"));
	loot.add(new Item("White goo","Yuck!"));
	loot.add(new Item("Flaming dagger","A dager engulfed in flames"));
	loot.add(new Item("Coal","Reminds Goggan of home"));
	loot.add(new Item("Dolorean","Don't even try to go 88 Mph"));
	loot.add(new Item("Torch", "A lit torch, can be used to find your way out."));
	loot.add(new Item("Potion", "A poisonous potion."));
	loot.add(new Item("Sammy doll", "A pretty doll, doesn't do much though"));
	loot.add(new Item("Janco doll", "Annoying little pecker"));
	loot.add(new Item("Jelle doll", "I'm sexy and I know it!"));
	loot.add(new Item("Edwin doll", "Looks kind of funny with headphones on"));
	loot.add(new Item("Rawa doll", "A tiny , tiny doll."));
	loot.add(new Item("Denis doll", "It moves, although very slowly"));
	loot.add(new Item("Rob doll", "A very helpgull doll, at times"));
	loot.add(new Item("Nick doll", "A very defensive doll"));
	loot.add(new Item("Joost doll", "Don't let him control a radio..."));
	loot.add(new Item("Danny doll", "This one rides a bike."));
	
	}
	
	public Item randomizeLoot(){
		Item i = null;
		Random rnd = new Random();
					i = loot.get(rnd.nextInt(loot.size()));
			return i;
	
	}
	
	
}
