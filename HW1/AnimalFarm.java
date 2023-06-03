//Yunus Emre Gezici 150121066
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AnimalFarm {
	public ArrayList<Animal> getAnimalList() {
		return animalList;
	}

	public ArrayList<String> getAnimalNames() {
		return animalNames;
	}

	private ArrayList<Animal> animalList = new ArrayList<>();
	private ArrayList<String> animalNames = new ArrayList<>();
	private final int CAPACITY;
	private static int numberOfAnimals = 0;

	public AnimalFarm(int capacity) {
		CAPACITY = capacity;
	}

	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}

	public boolean addAnimal(Animal animal) {
		boolean added = false;
		if (animalList != null && animalNames != null) {
			boolean nameCheck = true;
			for (int i = 0; i < animalNames.size(); i++) {
				if (animal.getName().equals(animalNames.get(i))) {
					nameCheck = false;
					break;
				}
			}
			if (animalList.size() + 1 <= CAPACITY && nameCheck) {
				animalList.add(animal);
				animalNames.add(animal.getName());
				added = true;
				numberOfAnimals++;
			}
		} else {
			animalList.add(animal);
			animalNames.add(animal.getName());
			added = true;
			numberOfAnimals++;
		}
		return added;
	}

	public boolean removeAnimal(Animal animal) {
		boolean returnV = false;
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i).equals(animal)) {
				animalList.remove(i);
				animalNames.remove(i);
				returnV = true;
			}
		}
		numberOfAnimals--;
		if (animal instanceof Chicken)
			Chicken.decrementCount();
		if (animal instanceof Donkey)
			Donkey.decrementCount();
		if (animal instanceof Horse)
			Horse.decrementCount();
		if (animal instanceof Pig)
			Pig.decrementCount();
		if (animal instanceof Raven)
			Raven.decrementCount();
		if (animal instanceof Sheep)
			Sheep.decrementCount();

		return returnV;
	}

	public void printAllAnimalGreetings() {
		for (int i = 0; i < animalList.size(); i++)
			animalList.get(i).sayGreeting();
	}

	public void printOneAnimalGreetings(Animal animal) {
		for (int i = 0; i < animalList.size(); i++) {
			if (animal.getClass().isInstance(animalList.get(i)))
				animal.sayGreeting();
		}
	}

	public void printAllAnimalNames() {
		for (int i = 0; i < animalNames.size(); i++) {
			System.out.println(animalNames.get(i));
		}
	}

	public void printOneAnimalName(Animal animal) {
		for (int i = 0; i < animalNames.size(); i++) {
			if (animal.getName().equals(animalNames.get(i)))
				System.out.println(animal.getName());
		}
	}

	public void printAllAnimals() {
		for (int i = 0; i < animalList.size(); i++)
			animalList.get(i).toString();

	}

	public int nextYearPopulationForecast() {
		int total = animalList.size();
		for (int i = 0; i < animalList.size(); i++) {
			total += animalList.get(i).getNumberOfOffsprings() * animalList.get(i).getPregnancyPerYear();
		}
		return total;
	}

	public void animalMovements() {
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i) instanceof Bird) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");
				((Bird) animalList.get(i)).fly();
			}
			if (animalList.get(i) instanceof Mammal) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");

				((Mammal) animalList.get(i)).walk();

			}
		}

	}

	public void eatingHabits() {
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i) instanceof Bird) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");
				((Bird) animalList.get(i)).omnivore();
			}
			if (animalList.get(i) instanceof Mammal) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");
				((Mammal) animalList.get(i)).herbivore();
			}
		}
	}

	public void sortAlphabetically() {

		ArrayList<String> sortedList = new ArrayList<String>();
		for(int i = 0; i < animalNames.size(); i++)
			sortedList.add(animalNames.get(i));
		for (int i = 0; i < sortedList.size() - 1; i++) {
			for (int j = i + 1; j < sortedList.size(); j++) {
				if (sortedList.get(i).compareTo(sortedList.get(j)) > 0) {
					String temp = sortedList.get(i);
					sortedList.set(i, sortedList.get(j));
					sortedList.set(j, temp);
				}
			}
		}
		for (String name : sortedList)
			System.out.println(name);

	}

	public void sortBasedOnLegNumber() {
		ArrayList<Animal> sortedList = new ArrayList<Animal>();
		for(int i = 0; i < animalList.size(); i++)
			sortedList.add(animalList.get(i));
		for (int i = 0; i < sortedList.size() - 1; i++) {
			for (int j = i + 1; j < sortedList.size(); j++) {
				if (sortedList.get(i).getLegNumber() > sortedList.get(j).getLegNumber()) {
					Animal temp = sortedList.get(i);
					sortedList.set(i, sortedList.get(j));
					sortedList.set(j, temp);
				}
			}
		}
		for (Animal animal : sortedList)
			System.out.println(animal.getName() + " has " + animal.getLegNumber() + " legs.");
	}

	public void sortBasedOnAge() {
		ArrayList<Animal> sortedList = new ArrayList<Animal>();
		for(int i = 0; i < animalList.size(); i++)
			sortedList.add(animalList.get(i));

		for (int i = 0; i < sortedList.size() - 1; i++) {
			for (int j = i + 1; j < sortedList.size(); j++) {
				if (sortedList.get(i).getAge() > sortedList.get(j).getAge()) {
					Animal temp = sortedList.get(i);
					sortedList.set(i, sortedList.get(j));
					sortedList.set(j, temp);
				}
			}
		}
		for (Animal animal : sortedList)
			System.out.println(animal.getName() + " is " + animal.getAge() + " years old.");
	}

	public void searchBasedOnName(String name) {

		for (int i = 0; i < animalList.size(); i++) {
			if (name.equals(animalList.get(i).getName()))
				System.out.println(animalList.get(i).toString());
		}
	}

	public void searchBasedOnAge(int age) {
		for (int i = 0; i < animalList.size(); i++) {
			if (age == animalList.get(i).getAge())
				System.out.println(animalList.get(i).toString());
		}
	}

	public void printReport(String filename) throws FileNotFoundException {
		ArrayList<Animal> chicken = new ArrayList<>();
		ArrayList<Animal> donkey = new ArrayList<>();
		ArrayList<Animal> horse = new ArrayList<>();
		ArrayList<Animal> pig = new ArrayList<>();
		ArrayList<Animal> raven = new ArrayList<>();
		ArrayList<Animal> sheep = new ArrayList<>();
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i) instanceof Chicken)
				chicken.add(animalList.get(i));
			if (animalList.get(i) instanceof Donkey)
				donkey.add(animalList.get(i));
			if (animalList.get(i) instanceof Horse)
				horse.add(animalList.get(i));
			if (animalList.get(i) instanceof Pig)
				pig.add(animalList.get(i));
			if (animalList.get(i) instanceof Raven)
				raven.add(animalList.get(i));
			if (animalList.get(i) instanceof Sheep)
				sheep.add(animalList.get(i));
		}
		File file = new File(filename);
		if (file.exists()) {
			System.exit(1);
		}
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.print("We have a total of " + animalList.size() + " animals in the farm.");
		if (Chicken.getCount() != 0) {
			printWriter.print("\n\t*" + Chicken.getCount() + " of them are Chicken. Those are:");
			printWriter.printf("\n\t\t%-15s%-15s%-15s", "Name", "Age", "Leg Number");
			for (int i = 0; i < chicken.size(); i++)
				printWriter.printf("\n\t\t%-15s%-15s%-15s", chicken.get(i).getName(), chicken.get(i).getAge(),
						chicken.get(i).getLegNumber());
		}
		if (Donkey.getCount() != 0) {
			printWriter.print("\n\t*" + Donkey.getCount() + " of them are Donkey. Those are:");
			printWriter.printf("\n\t\t%-15s%-15s%-15s", "Name", "Age", "Leg Number");
			for (int i = 0; i < donkey.size(); i++)
				printWriter.printf("\n\t\t%-15s%-15s%-15s", donkey.get(i).getName(), donkey.get(i).getAge(),
						donkey.get(i).getLegNumber());
		}
		if (Horse.getCount() != 0) {
			printWriter.print("\n\t*" + Horse.getCount() + " of them are Horse. Those are:");
			printWriter.printf("\n\t\t%-15s%-15s%-15s", "Name", "Age", "Leg Number");
			for (int i = 0; i < horse.size(); i++)
				printWriter.printf("\n\t\t%-15s%-15s%-15s", horse.get(i).getName(), horse.get(i).getAge(),
						horse.get(i).getLegNumber());
		}
		if (Pig.getCount() != 0) {
			printWriter.print("\n\t*" + Pig.getCount() + " of them are Pig. Those are:");
			printWriter.printf("\n\t\t%-15s%-15s%-15s", "Name", "Age", "Leg Number");
			for (int i = 0; i < pig.size(); i++)
				printWriter.printf("\n\t\t%-15s%-15s%-15s", pig.get(i).getName(), pig.get(i).getAge(),
						pig.get(i).getLegNumber());
		}
		if (Raven.getCount() != 0) {
			printWriter.print("\n\t*" + Raven.getCount() + " of them are Raven. Those are:");
			printWriter.printf("\n\t\t%-15s%-15s%-15s", "Name", "Age", "Leg Number");
			for (int i = 0; i < raven.size(); i++)
				printWriter.printf("\n\t\t%-15s%-15s%-15s", raven.get(i).getName(), raven.get(i).getAge(),
						raven.get(i).getLegNumber());
		}
		if (Sheep.getCount() != 0) {
			printWriter.print("\n\t*" + Sheep.getCount() + " of them are Sheep. Those are:");
			printWriter.printf("\n\t\t%-15s%-15s%-15s", "Name", "Age", "Leg Number");
			for (int i = 0; i < sheep.size(); i++)
				printWriter.printf("\n\t\t%-15s%-15s%-15s", sheep.get(i).getName(), sheep.get(i).getAge(),
						sheep.get(i).getLegNumber());
		}

		printWriter.close();
	}

}
