package me.charlie.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creates a list of names for the four ship options.
 * 
 * @author charlie
 *
 */
public class ShipNameHandler {

	private List<String> shipNames = new ArrayList<>();
	private Random random = new Random();

	/**
	 * Creates an instance of ShipNameHandle and adds all the possible names to a
	 * list.
	 */
	public ShipNameHandler() {
		this.shipNames.add("Costa Concordia");
		this.shipNames.add("Britannic II");
		this.shipNames.add("Titanic");
		this.shipNames.add("Sun Vista");
		this.shipNames.add("Sun Venture");
		this.shipNames.add("Achille Lauro");
		this.shipNames.add("SeaBreeze");
		this.shipNames.add("Constitution");
		this.shipNames.add("Britanis");
		this.shipNames.add("Ocean Princess");
		this.shipNames.add("Diamond Princess");
	}

	/**
	 * selects a random name from the list of names and then removes it from the
	 * list.
	 * 
	 * @return a name randomly selected from a list of hardcoded names.
	 */
	public String getName() {
		String name = this.shipNames.get(this.random.nextInt(this.shipNames.size() - 1));
		this.shipNames.remove(name);
		return name;
	}
}
