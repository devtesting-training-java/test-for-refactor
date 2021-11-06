package io.xp.kata;

import io.xp.kata.gildedrose.Item;

public class NormalItem extends Item {
    public NormalItem(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void updateItem() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sell_in = sell_in - 1;

        if (sell_in < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }
}
