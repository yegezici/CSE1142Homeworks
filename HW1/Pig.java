//Yunus Emre Gezici 150121066
public class Pig extends Mammal{

	private static int count = 0;
	
	public Pig(String name, int age) {
		super(name,age);
		setLegNumber(4);
		setNumberOfOffsprings(12);
		setPregnancyPerYear(2);
		count++;
	}
	
	@Override
	public void sayGreeting() {
		System.out.println("All animals are equal, but some animals are more equal than others!");
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void decrementCount() {
		count--;
	}
	
}