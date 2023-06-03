//Yunus Emre Gezici 1501210666

import java.util.ArrayList;

public class ShoppingMall {
	private ArrayList<Item> items = new ArrayList<Item>();

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addDairy() {
		items.add(new Dairy());
	}

	public void addFruit() {
		items.add(new Fruit());
	}

	public void addTop() {
		items.add(new Top());
	}

	public void addTrousers() {
		items.add(new Trousers());
	}

	public void addUnderware() {
		items.add(new Underware());
	}

	public void addVegetable() {
		items.add(new Vegetable());
	}

	public void addArbitrary(Item item) {
		items.add(item);
	}

	public double bill() {
		double total = 0;
		for(int i = 0; i < items.size(); i++) {
			total += items.get(i).calculatePrice();
		}
		return total;
	}
}
