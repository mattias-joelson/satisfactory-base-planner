package org.joelson.mattias.satisfactory.model;

// all of Component, Equipment, Part
public class Item {

    private final String name;
    private final boolean fluid;
//    private Recipe recipe;

    public Item(String name) {
        this(name, false);
    }

    public Item(String name, final boolean fluid) {
        this.name = name;
        this.fluid = fluid;
    }

    public String getName() {
        return name;
    }

    public boolean isFluid() {
        return fluid;
    }

    //    public Recipe getRecipe() {
//        return recipe;
//    }
//
//    public void setRecipe(Recipe recipe) {
//        this.recipe = recipe;
//    }
}
