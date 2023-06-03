//Yunus Emre Gezici 1501210666

public class Vegetable extends Food implements Vegan, Washable {

	public Vegetable() {
		this(10.0);
	}

	public Vegetable(double basePrice) {
		super.setBasePrice(basePrice);
	}

	@Override
	public void howToWash() {
		System.out.println("Wash Vegetable with warm water.");
	}

	@Override
	public void madeOf() {
		System.out.println("It is made only of vegetables.");
	}

	@Override
	public double calculatePrice() {
		return super.getBasePrice() * (1 + super.getVat()) * 1.25;
	}

}
