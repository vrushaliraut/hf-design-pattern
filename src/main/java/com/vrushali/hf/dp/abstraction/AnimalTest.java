package com.vrushali.hf.dp.abstraction;

import java.util.List;

public class AnimalTest {
    public static void main(String[] args) {
        Animal dog = new Dog("Rover","Black");
        Animal whale = new Whale("Humpback","Gray");

        Swimmable swimmableShark = new Shark("Humpback","Gray");
        Swimmable swimmableWhale = new Whale("Great White","Gray");
        
        // abstract class cannot be instantiated 
        // Animal genericAnimal = new Animal("Animal","Animal");

        // Animal -> TerrestrialAnimal -> Dog
        // Animal -> WaterAnimal -> Whale
        List<Animal> animals = List.of(dog, whale);
        for (Animal animal : animals) {
            animal.makeSound();
            animal.sleep();
        }
        
        List<Swimmable> swimmables = List.of(swimmableShark, swimmableWhale);
        for (Swimmable swimmable : swimmables) {
            swimmable.swim();
        }
    }
}
