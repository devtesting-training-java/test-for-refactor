package io.xp.kata.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    protected int qualityDelta() {
        return getSellIn() < 0 ? 2 : 1;
    }

}
