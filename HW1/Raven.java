//Yunus Emre Gezici 150121066
public class Raven extends Bird{
	private static int count = 0;
	
	public Raven(String name, int age) {
		super(name,age);
	}
	
	@Override
	public void sayGreeting() {
		System.out.println("A happy country where we poor animals shall rest forever!");
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void decrementCount() {
		count--;
	}
	
}
