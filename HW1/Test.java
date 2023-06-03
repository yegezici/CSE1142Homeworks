//Yunus Emre Gezici 150121066
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IllegalNameException {
		Scanner input = new Scanner(System.in);

		System.out.print(
				"Welcome to Animal Farm simulation program! \nPlease " + "enter the capacity of the animal farm: ");
		AnimalFarm animalFarm = new AnimalFarm(input.nextInt());

		while (true) {
			System.out.println("0 - Exit the program");
			System.out.println("1 - Add animal");
			System.out.println("2 - Remove animal");
			System.out.println("3 - Search animal");
			System.out.println("4 - Sort animals");
			System.out.println("5 - Calculate next year's population estimate");
			System.out.println("6 - Print all animal's movements");
			System.out.println("7 - Print all animal's eating habits");
			System.out.println("8 - Print report");
			System.out.print("Please enter your choice: ");
			int choice = input.nextInt();
			if (choice == 1) {
				System.out.println("1 - Chicken");
				System.out.println("2 - Donkey");
				System.out.println("3 - Horse");
				System.out.println("4 - Pig");
				System.out.println("5 - Raven");
				System.out.println("6 - Sheep");
				System.out.print("Select animal type: ");
				int type = input.nextInt();

				if (type == 1) {
					System.out.print("Enter the name: ");
					String name = input.next();
					if (animalFarm.getAnimalList() != null) {
						for (int i = 0; i < animalFarm.getAnimalList().size(); i++) {
							if (name.equals(animalFarm.getAnimalList().get(i).getName()))
								throw new IllegalNameException("There is an animal with same name in the Animal Farm");
						}
					}
					System.out.print("Enter the age: ");
					int age = input.nextInt();
					animalFarm.addAnimal(new Chicken(name, age));
				} else if (type == 2) {
					System.out.print("Enter the name: ");
					String name = input.next();
					if (animalFarm.getAnimalList() != null) {
						for (int i = 0; i < animalFarm.getAnimalList().size(); i++) {
							if (name.equals(animalFarm.getAnimalList().get(i).getName()))
								throw new IllegalNameException("There is an animal with same name in the Animal Farm");
						}
					}
					System.out.print("Enter the age: ");
					int age = input.nextInt();
					animalFarm.addAnimal(new Donkey(name, age));
				} else if (type == 3) {
					System.out.print("Enter the name: ");
					String name = input.next();
					if (animalFarm.getAnimalList() != null) {
						for (int i = 0; i < animalFarm.getAnimalList().size(); i++) {
							if (name.equals(animalFarm.getAnimalList().get(i).getName()))
								throw new IllegalNameException("There is an animal with same name in the Animal Farm");
						}
					}
					System.out.print("Enter the age: ");
					int age = input.nextInt();
					animalFarm.addAnimal(new Horse(name, age));
				} else if (type == 4) {
					System.out.print("Enter the name: ");
					String name = input.next();
					if (animalFarm.getAnimalList() != null) {
						for (int i = 0; i < animalFarm.getAnimalList().size(); i++) {
							if (name.equals(animalFarm.getAnimalList().get(i).getName()))
								throw new IllegalNameException("There is an animal with same name in the Animal Farm");
						}
					}
					System.out.print("Enter the age: ");
					int age = input.nextInt();
					animalFarm.addAnimal(new Pig(name, age));
				} else if (type == 5) {
					System.out.print("Enter the name: ");
					String name = input.next();
					if (animalFarm.getAnimalList() != null) {
						for (int i = 0; i < animalFarm.getAnimalList().size(); i++) {
							if (name.equals(animalFarm.getAnimalList().get(i).getName()))
								throw new IllegalNameException("There is an animal with same name in the Animal Farm");
						}
					}
					System.out.print("Enter the age: ");
					int age = input.nextInt();
					animalFarm.addAnimal(new Raven(name, age));
				} else {
					System.out.print("Enter the name: ");
					String name = input.next();
					if (animalFarm.getAnimalList() != null) {
						for (int i = 0; i < animalFarm.getAnimalList().size(); i++) {
							if (name.equals(animalFarm.getAnimalList().get(i).getName()))
								throw new IllegalNameException("There is an animal with same name in the Animal Farm");
						}
					}
					System.out.print("Enter the age: ");
					int age = input.nextInt();
					animalFarm.addAnimal(new Sheep(name, age));
				}

			} else if (choice == 2) {
				System.out.println("Enter name:");
				String name = input.next();
				for (int i = 0; i < animalFarm.getAnimalList().size(); i++) {
					if (name.equals(animalFarm.getAnimalList().get(i).getName()))
						animalFarm.removeAnimal(animalFarm.getAnimalList().get(i));
				}
			} else if (choice == 3) {
				System.out.println("1 - Search based on name ");
				System.out.println("2 - Search based on age ");
				int cho = input.nextInt();
				if (cho == 1) {
					System.out.print("Enter name:");
					String name = input.next();
					animalFarm.searchBasedOnName(name);
				} else if (cho == 2) {
					System.out.print("Enter age:");
					int age = input.nextInt();
					animalFarm.searchBasedOnAge(age);
				}
			} else if (choice == 4) {
				// Sorting animals
				System.out.println("1 - Sort based on name");
				System.out.println("2 - Sort based on leg number");
				System.out.println("3 - Sort based on age");
				System.out.println("4 - Sort based on addition date");
				int cho = input.nextInt();

				if (cho == 1) {
					animalFarm.sortAlphabetically();
				} else if (cho == 2) {
					animalFarm.sortBasedOnLegNumber();
				} else if (cho == 3) {
					animalFarm.sortBasedOnAge();
				} else {
					for (String name : animalFarm.getAnimalNames())
						System.out.println(name);
				}
			} else if (choice == 5) {
				System.out.println(animalFarm.nextYearPopulationForecast());

			} else if (choice == 6) {
				animalFarm.animalMovements();

			} else if (choice == 7) {
				animalFarm.eatingHabits();

			} else if (choice == 8) {
				System.out.print("Enter filename:");
				String filename = input.next();
				try {
					animalFarm.printReport(filename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (choice == 0) {
				System.out.println("Process has been finished");
				System.exit(0);
			}
		}
	}
}
