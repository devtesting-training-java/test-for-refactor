package io.xp.kata.gildedrose;

import io.xp.kata.gildedrose.Item;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void updateItem() {
        if (quality < 50) {
            quality = quality + 1;
        }

        sell_in = sell_in - 1;

        if (sell_in < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

}
