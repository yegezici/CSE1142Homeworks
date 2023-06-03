//Yunus Emre Gezici 1501210666

public class Trousers extends Clothing {

	public Trousers() {
		this(40.0);
	}

	public Trousers(double basePrice) {
		super.setBasePrice(basePrice);
	}

	@Override
	public void howToWash() {
		System.out.println("Wash Trousers at 30 degrees.");
		
	}

	@Override
	public double calculatePrice() {
		return super.getBasePrice() * (1 + super.getVat()) * 1.2;
	}

}
