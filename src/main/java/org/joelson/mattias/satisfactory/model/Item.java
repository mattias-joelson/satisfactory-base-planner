package org.joelson.mattias.satisfactory.model;

public class Item {

    private final String name;
    private Recipe recipe;


    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
