package ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.animal;

import ss07_abstract_interface.practice.p01_lop_animal_va_interface_edible.edible.IEdible;

public class Chicken extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "Chicken: Cuk cuk cuk takkkkk";
    }

    @Override
    public String howToEat() {
        return "Chicken: Nau roi bo mieng an";
    }
}
