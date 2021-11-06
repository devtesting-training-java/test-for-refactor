package io.xp.kata;

import io.xp.kata.gildedrose.*;

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
                new NormalItem("+5 Dexterity Vest", 10, 20), //
                new AgedBrie("Aged Brie", 2, 0), //
                new NormalItem("Elixir of the Mongoose", 2, 7), //
                new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
                new Passes("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Passes("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Passes("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Passes("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new NormalItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 3;
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
            app.updateQuality();
        }
        return outputStream.toString();
    }
}
