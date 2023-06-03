//Yunus Emre Gezici 150121066
public class Horse extends Mammal{

	private static int count = 0;
	
	public Horse(String name, int age) {
		super(name,age);
		setLegNumber(4);
		setNumberOfOffsprings(1);
		setPregnancyPerYear(1);
		count++;
	}
	
	@Override
	public void sayGreeting() {
		System.out.println("I will work harder!");
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void decrementCount() {
		count--;
	}
	
}