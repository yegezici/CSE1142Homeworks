//Yunus Emre Gezici 1501210666

public class Top extends Clothing {

	public Top() {
		this(20.0);
	}

	public Top(double basePrice) {
		super.setBasePrice(basePrice);
	}

	@Override
	public void howToWash() {
		System.out.println("Wash Top at 40 degrees.");
	}

	@Override
	public double calculatePrice() {
		return super.getBasePrice() * (1 + super.getVat()) * 1.2;
	}
}
