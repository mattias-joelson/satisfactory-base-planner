package org.joelson.mattias.satisfactory.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class Recipe {

    private final List<Item> results;
    private final Item[] ingredients;

    private Recipe(Item[] results, Item[] ingredients) {
        this.results = results;
        this.ingredients = ingredients;
    }
//    public Recipe(Item result, Item... ingredients) {
//        this.result = result;
//        this.ingredients = new HashSet<>(Arrays.asList(ingredients));
//    }

    public Item[] getResults() {
        return results;
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

    private String resultsAsString() {
        if (results.size() == 1) {
            return results.
        }
        StringJoiner stringJoiner = new StringJoiner(", ");
        return
        if (re)
    }

    private String getIngredientName(Item ingredient) {
//        if (ingredient instanceof Component && ((Component) ingredient).isLocal()) {
//            return String.format("(*%s)", ingredient.getRecipe().asString());
//        }
        return ingredient.getName();
    }

    public static Recipe singleResultRecipe(Item result, Item... ingredients) {
        return new Recipe(Set.of(result), Set.of(ingredients));
    }
}
