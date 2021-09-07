package org.joelson.mattias.satisfactory.model;

public enum Parts {
    BAUXITE("Bauxite"),
    CATERIUM_ORE("Caterium"),
    COAL("Coal"),
    COPPER_ORE("Copper ore"),
    CRUDE_OIL("Crude oil", true),
    IRON_ORE("Iron Ore"),
    LIMESTONE("Limestone"),
    RAW_QUARTZ("Raw quartz"),
    SAM_ORE("S.A.M. ore"),
    SULFUR("Sulfur"),
    URANIUM("Uranium"),
    WATER("Water", true);

    private final Item item;

    Parts(String name) {
        this(name, false);
    }

    Parts(String name, boolean fluid) {
        item = new Item(name, fluid);
    }

    public Item getItem() {
        return item;
    }
}
