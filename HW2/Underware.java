//Yunus Emre Gezici 1501210666

public class Underware	extends Clothing{

	public Underware() {
		this(30.0);
	}
	
	public Underware(double basePrice) {
		super.setBasePrice(basePrice); 
	}
	
	@Override
	public void howToWash() {
		System.out.println("Wash Underware at 60 degrees");
	}

	@Override
	public double calculatePrice() {
		return super.getBasePrice() * (1 + super.getVat()) * 1.45;
	}

}
