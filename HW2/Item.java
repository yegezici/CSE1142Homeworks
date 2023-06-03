//Yunus Emre Gezici 1501210666

public abstract class Item {
	private double vat;
	private double basePrice;

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public abstract double calculatePrice();


}
