//Yunus Emre Gezici 1501210666

public class Fruit extends Food implements Vegan, Washable{
	
	public Fruit(){
		this(6.0);
	}
	
	public Fruit(double basePrice) {
		super.setBasePrice(basePrice);
	}

	@Override
	public void howToWash() {
		System.out.println("Wash Fruit with cold water.");
		
	}

	@Override
	public void madeOf() {
		System.out.println("It is made only of fruits.");
		
	}

	@Override
	public double calculatePrice() {
		return super.getBasePrice() * (1 + super.getVat()) * 1.2;
	}
	
	
}
