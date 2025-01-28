package com.ggjiuw.animals;

import java.util.List;

public class AnimalsCollection {
    public List<Animal> getCollection() {
        return this.collection;
    }

    public void setCollection(List<Animal> newCollection) {
        this.collection = newCollection;
    }

    private List<Animal> collection;
}
