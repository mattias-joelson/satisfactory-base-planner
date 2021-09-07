package org.joelson.mattias.satisfactory.model;

public enum Equipments {

    PORTABLE_MINER("Portable miner"),
    XENO_ZAPPER("Xeno zapper");

    private final Item item;

    Equipments(String name) {
        item = new Item(name);
    }

    public Item getItem() {
        return item;
    }
}
