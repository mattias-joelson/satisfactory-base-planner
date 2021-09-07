package org.joelson.mattias.satisfactory;

import org.joelson.mattias.satisfactory.model.Component;
import org.joelson.mattias.satisfactory.model.Item;
import org.joelson.mattias.satisfactory.model.Part;
import org.joelson.mattias.satisfactory.model.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

public class SatisfactoryBasePlanner {

    public static void main(String[] args) {
        Part bauxite = from(new Part("Bauxite"));
        Part cateriumOre = from(new Part("Caterium Ore"));
        Part coal = from(new Part("Coal"));
        Part copperOre = from(new Part("Copper Ore"));
        Part crudeOil = from(new Part("Crude Oil"));
        Part ironOre = from(new Part("Iron Ore"));
        Part limestone = from(new Part("Limestone"));
        Part rawQuartz = from(new Part("Raw Quartz"));
        Part sulfur = from(new Part("Sulfur"));
        Part uranium = from(new Part("Uranium"));
        Part water = from(new Part("Water"));

        Part leaves = from(new Part("Leaves"));
        Part mycelia = from(new Part("Mycelia"));
        Part greenPowerSlug = from(new Part("Green Power Slug"));

        Component biomass = from(new Component("Biomass"), leaves);
        Component copperIngot = from(new Component("Copper Ingot"), copperOre);
        Component wire = from(new Component("Wire", true), copperIngot);
        Component cable = from(new Component("Cable"), wire);
        Component concrete = from(new Component("Concrete"), limestone);
        Component ironIngot = from(new Component("Iron Ingot"), ironOre);
        Component ironPlate = from(new Component("Iron Plate"), ironIngot);
        Component ironRod = from(new Component("Iron Rod"), ironIngot);
        Component screw = from(new Component("Screw", true), ironRod);
        Component reinforcedIronPlate = from(new Component("Reinforced Iron Plate"), ironPlate, screw);

        Component copperSheet = from(new Component("Copper Sheet"), copperIngot);
        Component solidBiofuel = from(new Component("Solid Biofuel"), biomass);
        Component modularFrame = from(new Component("Modular Frame"), reinforcedIronPlate, ironRod);
        Component rotor = from(new Component("Rotor"), ironRod, screw);
        Component smartPlating = from(new Component("Smart Plating"), reinforcedIronPlate, rotor);

        Component steelIngot = from(new Component("Steel Ingot"), ironOre, coal);
        Component steelBeam = from(new Component("Steel Beam"), steelIngot);
        Component steelPipe = from(new Component("Steel Pipe"), steelIngot);
        Component versatileFramework = from(new Component("Versatile Framework"), modularFrame, steelBeam);

        Component stator = from(new Component("Stator"), steelPipe, wire);
        Component automatedWiring = from(new Component("Automated Wiring"), stator, cable);
        Component encasedIndustrialBeam = from (new Component("Encased Industrial Beam"), steelBeam, concrete);
        Component heavyModularFrame = from(new Component("Heavy Modular Frame"), modularFrame, steelPipe, encasedIndustrialBeam, screw);
        Component motor = from(new Component("Motor"), rotor, stator);

        Component plastic = from(new Component("Plastic"), crudeOil);
        Component circuitBoard = from(new Component("Circuit Board"), copperSheet, plastic);
        Component computer = from(new Component("Computer"), circuitBoard, cable, plastic, screw);
        Component adaptiveControlUnit = from(new Component("Adaptive Control Unit"), automatedWiring, circuitBoard, heavyModularFrame, computer);
        Component emptyCanistar = from(new Component("Empyty Canistar"), plastic);
        Component fuel = from(new Component("Fuel"), crudeOil);
        Component heavyOilResidue = from(new Component("Heavy Oil Residue"), crudeOil);
        Component liquidBiofuel = from(new Component("Liquid Biofuel"), solidBiofuel, water);
        Component rubber = from(new Component("Rubber"), crudeOil);
        Component modularEnginge = from(new Component("Modular Engine"), motor, rubber, smartPlating);
        Component petroleumCoke = from(new Component("Petroleum Coke"), heavyOilResidue);
        Component polymerResin = from(new Component("Polymer Resin"), crudeOil);

        Component cateriumIngot = from(new Component("Caterium Ingot"), cateriumOre);
        Component quickwire = from(new Component("Quickwire", true), cateriumIngot);
        Component aiLimiter = from(new Component("A.I. Limiter"), copperSheet, quickwire);
        Component silica = from(new Component("Silica"), rawQuartz);
        Component quartzCrystal = from(new Component("Quartz Crystal"), rawQuartz);
        Component crystalOscillator = from (new Component("Crystal Oscillator"), quartzCrystal, cable, reinforcedIronPlate);

        Component aluminaSolution = from(new Component("Alumina Solution"), bauxite, water);
        Component aluminumScrap = from(new Component("Aluminum Scrap"), aluminaSolution, petroleumCoke);
        Component aluminumIngot = from(new Component("Aluminum Ingot"), aluminumScrap, silica);
        Component alcladAluminumSheet = from(new Component("Alclad Aluminum Sheet"), aluminumIngot, copperIngot);
        Component battery = from(new Component("Battery"), alcladAluminumSheet, wire, sulfur, plastic);
        Component electromagneticControlRod = from(new Component("Electromagnetic Control Rod"), stator, aiLimiter);
        Component sulfuricAcid = from(new Component("Sulfuric Acid"), sulfur, water);
        Component uraniumPellet = from(new Component("Uranium Pellet"), uranium, sulfuricAcid);
        Component encasedUraniumCell = from(new Component("Encased Uranium Cell"), uraniumPellet, concrete);
        Component heatSink = from(new Component("HeatSink"), alcladAluminumSheet, rubber);
        Component radioControlUnit = from(new Component("Radio Control Unit"), heatSink, rubber, crystalOscillator, computer);
        Component nuclearFuelRod = from(new Component("Nuclear Fuel Rod"), encasedUraniumCell, encasedIndustrialBeam, electromagneticControlRod);
        Component nuclearWaste = from(new Component("Nuclear Waste"), nuclearFuelRod);
        Component turboMotor = from(new Component("Turbo Motor"), heatSink, radioControlUnit, motor, rubber);

        Component blackPowder = from(new Component("Black Powder"), coal, sulfur);
        Component compactedCoal = from(new Component("Compacted Coal"), coal, sulfur);
        Component fabric = from(new Component("Fabric"), mycelia, biomass);
        Component highspeedConnector = from(new Component("High-Speed Connector"), quickwire, cable, circuitBoard);
        Component powerShard = from(new Component("Power Shard"), greenPowerSlug);
        Component superComputer = from(new Component("Super Computer"), computer, aiLimiter, highspeedConnector, plastic);
        Component turboFuel = from(new Component("Turbo Fuel"), fuel, compactedCoal);

        layoutBase(adaptiveControlUnit, battery, modularEnginge, superComputer, turboMotor, versatileFramework);

        System.out.println("base graph for https://csacademy.com/app/graph_editor/");
        writeBaseGraph(adaptiveControlUnit, battery, modularEnginge, superComputer, turboMotor, versatileFramework);
    }

    private static <T extends Item> T from(T item, Item... ingredients) {
        item.setRecipe(new Recipe(item, ingredients));
        return item;
    }

    private static void layoutBase(Item... items) {
        Map<Item, Integer> depthMap = getDepthMap(items);
        printDepthMap(depthMap);
        List<Set<Item>> itemLayers = getItemLayers(depthMap);
        System.out.println();
        int height = itemLayers.size();
        int width = itemLayers.stream().mapToInt(Set::size).max().orElse(0);
        System.out.println(String.format("height: %d, width: %d", height, width));
        int fact = fact(width);
        System.out.println(String.format("row combinations: %d, total combinations: %f", fact, Math.pow(fact, height)));
        System.out.println();
        Map<Item, Integer> usageCount = getUsageCount(depthMap);
        printUsageCount(usageCount);
        System.out.println();

        // reduce
//        depthMap = depthMap.entrySet().stream()
//                .filter(entry -> entry.getKey() instanceof Component)
//                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
//        printDepthMap(depthMap);
//        itemLayers = getItemLayers(depthMap);
//        System.out.println();
//        height = itemLayers.size();
//        width = itemLayers.stream().mapToInt(Set::size).max().orElse(0);
//        System.out.println(String.format("height: %d, width: %d", height, width));
//        fact = fact(width);
//        System.out.println(String.format("row combinations: %d, total combinations: %f", fact, Math.pow(fact, height)));
//
//        List<Integer> layerCombinations = new ArrayList<>(itemLayers.size());
//        double totalCombinations = 1;
//        for (Set<Item> itemLayer : itemLayers) {
//            int n = itemLayer.size();
//            int combinations = fact(width);
//            if (n < width) {
//                int empty = width - n;
//                if (empty > 1) {
//                    int emptyCombinations = fact(empty);
//                    combinations /= emptyCombinations;
//                }
//            }
//            totalCombinations *= combinations;
//            layerCombinations.add(combinations);
//        }
//        System.out.println(String.format("total combinations: %f, combinations per layer: %s", totalCombinations, layerCombinations));
//        for (double d = 0; d < totalCombinations; d += 1) {
//
//        }
//        System.out.println("done");
/*
1

1 2
2 1

1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3
2 3 1 4
2 3 4 1
2 4 1 3
2 4 3 1
3 1 2 4
3 1 4 2
3 2 1 4
3 2 4 1
3 4 1 2
3 4 2 1
4 1 2 3
4 1 3 2
4 2 1 3
4 2 3 1
4 3 1 2
4 3 2 1


 */
        //layout
//        Item[][] layout = new Item[height][width];
//        for (int row = 0; row < itemLayers.size(); row += 1) {
//            List<Item> layer = List.copyOf(itemLayers.get(row));
//            for (int column = 0; column < layer.size(); column += 1) {
//                layout[row][column] = layer.get(column);
//            }
//        }
//        for (int row = 0; row < layout.length; row += 1) {
//            for (int column = 0; column < layout[row].length; column += 1) {
//                Item item = layout[row][column];
//                if (item != null) {
//                    System.out.println(String.format("%" + (column * 4 + 1) + "s%s <- %s", "", item.getName(), item.getRecipe().asString()));
//                }
//            }
//        }
    }

    private static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n -1);
    }

//    private static int pow(int base, int exponent) {
//        return (exponent <= 1) ? base : base * pow(base, exponent - 1);
//    }

    private static Map<Item, Integer> getDepthMap(Item[] items) {
        Map<Item, Integer> depthMap = new HashMap<>();
        Arrays.stream(items)
                .forEach(item -> addItem(depthMap, item, 1));
        return depthMap;
    }

    private static void printDepthMap(Map<Item, Integer> depthMap) {
        depthMap.entrySet().stream()
                .sorted(Comparator.comparing(Entry::getValue))
                .forEach(itemDepthEntry -> System.out.println(String.format("%2d : %s", itemDepthEntry.getValue(), itemDepthEntry.getKey().getRecipe().asString())));
    }

    private static List<Set<Item>> getItemLayers(Map<Item, Integer> depthMap) {
        int maxDepth = depthMap.values().stream().max(Comparator.comparing(Function.identity())).orElse(0);
        List<Set<Item>> itemLayers = new ArrayList<>(maxDepth);
        for (int i = 0; i < maxDepth; i += 1) {
            itemLayers.add(new HashSet<>());
        }
        depthMap.entrySet().forEach(entry -> itemLayers.get(entry.getValue() - 1).add(entry.getKey()));
        return itemLayers;
    }

    private static Map<Item, Integer> getUsageCount(Map<Item, Integer> depthMap) {
        Map<Item, Integer> usageCount = new HashMap<>();
        Set<Item> itemsUsed = depthMap.keySet();
        itemsUsed.forEach(item -> usageCount.put(item, 0));
        itemsUsed.forEach(item -> item.getRecipe().getIngredients().forEach(ingredient -> increaseIngredient(usageCount, ingredient)));
        return usageCount;
    }

    private static void printUsageCount(Map<Item, Integer> usageCount) {
        usageCount.entrySet().stream()
                .sorted(Entry.<Item, Integer>comparingByValue().reversed().thenComparing(entry -> entry.getKey().getName()))
                .forEach(entry -> System.out.println(String.format("%-23s - %2d", entry.getKey().getName(), entry.getValue())));
    }

    private static void increaseIngredient(Map<Item, Integer> usageCount, Item ingredient) {
        if (ingredient instanceof Component && ((Component) ingredient).isLocal()) {
            ingredient.getRecipe().getIngredients().forEach(item -> increaseIngredient(usageCount, item));
        } else {
            usageCount.put(ingredient, usageCount.get(ingredient) + 1);
        }
    }

//    private static Recipe getRecipe(Item item) {
//        if (item.getRecipe() != null) {
//            return item.getRecipe();
//        }
//        return new Recipe(item);
//    }

    private static void addItem(Map<Item, Integer> depthMap, Item item, int currDepth) {
        if (item instanceof Component && ((Component) item).isLocal()) {
            item.getRecipe().getIngredients().forEach(ingredient -> addItem(depthMap, ingredient, currDepth));
        } else if (!depthMap.containsKey(item) || depthMap.get(item) < currDepth) {
            depthMap.put(item, currDepth);
            item.getRecipe().getIngredients().forEach(ingredient -> addItem(depthMap, ingredient, currDepth + 1));
        }
    }

    // https://satisgraphtory.com/
    // https://csacademy.com/app/graph_editor/
    private static void writeBaseGraph(Item... items) {
        int[] weights = { 0, 1024, 256, 64, 16, 4, 1 };
        Map<Item, Integer> depthMap = getDepthMap(items);
        Map<Item, Integer> usageCount = getUsageCount(depthMap);

        Set<Item> writtenItems = new HashSet<>();
        List<Item> itemsToWrite = new ArrayList<>(List.of(items));
        for (int i = 0; i < itemsToWrite.size(); i += 1) {
            Item item = itemsToWrite.get(i);
            if (!writtenItems.contains(item)) {
                writtenItems.add(item);
                for (Item ingredient : item.getRecipe().getIngredients()) {
                    if (ingredient instanceof Component) {
                        if (((Component) ingredient).isLocal()) {
                            ingredient = new ArrayList<>(ingredient.getRecipe().getIngredients()).get(0);
                        }
                    }
                    int weight = weights[usageCount.get(ingredient)];
                    System.out.println(trimSpaces(item.getName()) + " " + trimSpaces(ingredient.getName()) + " " + weight);
                    itemsToWrite.add(ingredient);
                }
            }
        }
    }

    private static String trimSpaces(String s) {
        return s.replaceAll(" ", "");
    }
}

