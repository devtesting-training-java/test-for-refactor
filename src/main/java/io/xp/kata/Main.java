package io.xp.kata;

import io.xp.kata.gildedrose.GildedRose;
import io.xp.kata.gildedrose.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        String output = generateOutput(args);
        System.out.print(output);
    }

    public static String generateOutput(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 2),
                new Item("+5 Dexterity Vest", 10, 0),
                new Item("+5 Dexterity Vest", 0, 2),
                new Item("+5 Dexterity Vest", 0, 1),
                new Item("Aged Brie", 10, 50),
                new Item("Aged Brie", 10, 2),
                new Item("Aged Brie", 0, 49),
                new Item("Aged Brie", 0, 2),
                new Item("Sulfuras, Hand of Ragnaros", 10, 2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 2),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            printStream.println("-------- day " + i + " --------");
            printStream.println("name, sellIn, quality");
            for (Item item : items) {
                printStream.println(item);
            }
            printStream.println();
            app.update_quality();
        }
        return outputStream.toString();
    }
}
