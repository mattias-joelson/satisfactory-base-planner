package org.joelson.mattias.satisfactory.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Recipe {

    private final Item result;
    private final Set<Item> ingredients;

    public Recipe(Item result, Item... ingredients) {
        this.result = result;
        this.ingredients = new HashSet<>(Arrays.asList(ingredients));
    }

    public Item getResult() {
        return result;
    }

    public Set<Item> getIngredients() {
        return ingredients;
    }

    public String asString() {
        if (ingredients.isEmpty()) {
            return result.getName();
        }
        StringJoiner stringJoiner = new StringJoiner(", ");
        ingredients.forEach(ingredient -> stringJoiner.add(getIngredientName(ingredient)));
        return String.format("%s <- %s", result.getName(), stringJoiner);
    }

    private String getIngredientName(Item ingredient) {
        if (ingredient instanceof Component && ((Component) ingredient).isLocal()) {
            return String.format("(*%s)", ingredient.getRecipe().asString());
        }
        return ingredient.getName();
    }
}
