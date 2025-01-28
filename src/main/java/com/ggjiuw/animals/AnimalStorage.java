package com.ggjiuw.animals;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class AnimalStorage {
    private static final String file = "animals.json";
    static AnimalsCollection collection;

    public static List<Animal> getAnimalList() {
        return collection.getCollection();
    }

    public static synchronized void addAnimal(Animal a) {
        collection.getCollection().add(a);
        save();
    }
    public static synchronized void removeAnimal(int index) {
        collection.getCollection().remove(index);
        save();
    }

    public static synchronized void initStorage() {
        if (collection != null)
            return;

        Path animalsFile = Paths.get(file);

        if (!Files.exists(animalsFile))
            try {
                Files.createFile(animalsFile);
            } catch (IOException e) {
                System.out.println("[DBG/createFile]: idk critical err");
            }

        try {
            byte[] bytes = Files.readAllBytes(animalsFile);
            ObjectMapper objM = new ObjectMapper();
            collection = objM.readValue(bytes, AnimalsCollection.class);
        } catch (IOException e) {
            collection = new AnimalsCollection();
            collection.setCollection(new ArrayList<>());
            System.out.println("[DBG/init] IOException: " + e.getMessage());
        }
    }

    public static synchronized void save() {
        try {
            ObjectMapper objM = new ObjectMapper();
            byte[] content = objM.writeValueAsBytes(collection);
            Files.write(Paths.get(file), content);
        } catch (IOException e) {
            System.out.println("[DBG/save] IOException: " + e.getMessage());
        }
    }
}
