//Yunus Emre Gezici 1501210666
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ShoppingMall shoppingMall = new ShoppingMall();

		shoppingMall.addDairy();
		shoppingMall.addFruit();
		shoppingMall.addTop();
		shoppingMall.addTrousers();
		shoppingMall.addUnderware();
		shoppingMall.addVegetable();
		shoppingMall.getItems().add(new Top(100));
		
		printContent(shoppingMall);
		printWashingInstructions(shoppingMall);
		
		System.out.println("The bill is " + shoppingMall.bill());
		
	}

	public static void printContent(ShoppingMall shoppingMall) {
		ArrayList<Vegan> vegans = new ArrayList<Vegan>();
		for (int i = 0; i < shoppingMall.getItems().size(); i++) {
			if (shoppingMall.getItems().get(i) instanceof Vegan)
				vegans.add((Vegan) shoppingMall.getItems().get(i));
		}

		for (Vegan vegan : vegans)
			vegan.madeOf();

	}

	public static void printWashingInstructions(ShoppingMall shoppingMall) {
		ArrayList<Washable> washables = new ArrayList<Washable>();
		for (int i = 0; i < shoppingMall.getItems().size(); i++) {
			if (shoppingMall.getItems().get(i) instanceof Washable)
				washables.add((Washable) shoppingMall.getItems().get(i));
		}

		for (Washable washable : washables)
			washable.howToWash();
	}
}
