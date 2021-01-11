package ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible;

import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.animal.Animal;
import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.animal.Chicken;
import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.animal.Tiger;
import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.edible.IEdible;
import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.fruit.Apple;
import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.fruit.Fruit;
import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.fruit.Orange;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Chicken();
        animals[1] = new Tiger();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                IEdible iEdible = (Chicken) animal;
                System.out.println(iEdible.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }


    }
}
