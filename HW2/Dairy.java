//Yunus Emre Gezici 1501210666

public class Dairy extends Food {
	public Dairy() {
		this(8.0);
	}

	public Dairy(double basePrice) {
		super.setBasePrice(basePrice);
	}

	@Override
	public double calculatePrice() {
		return super.getBasePrice() * (1 + super.getVat()) * 1.3;
	}

}
