//Yunus Emre Gezici 150121066
public class Mammal extends Animal{
	
	public Mammal(String name, int age) {
		super(name, age);
	}
	public void walk() {
		System.out.println("I can walk to the far away lands!");
	}
	
	@Override
	public void reproduce() {
		System.out.println("I give birth!");
	}

	public void herbivore() {
		System.out.println("I eat plants only!");
	}
}
