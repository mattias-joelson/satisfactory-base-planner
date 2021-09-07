package org.joelson.mattias.satisfactory.model;

public enum Components {

    BIOMASS("Biomass"),
    CABLE("Cable"),
    CONCRETE("Concrete"),
    COPPER_INGOT("Copper ingot"),
    IRON_INGOT("Iron ingot"),
    IRON_PLATE("Iron plate"),
    IRON_ROD("Iron rod"),
    REINFORCED_IRON_PLATE("Reinforced iron plate"),
    SCREW("Screw"),
    WIRE("Wire"),

    COPPER_SHEET("Copper sheet"),
    SOLID_BIOFUEL("Solid biofuel"),
    MODULAR_FRAME("Modular frame"),
    ROTOR("Rotor"),
    SMART_PLATING("Smart plating");

    private final Item item;

    Components(String name) {
        item = new Item(name, false);
    }

    public Item getItem() {
        return item;
    }
}
