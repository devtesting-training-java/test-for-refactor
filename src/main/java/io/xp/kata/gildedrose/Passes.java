package io.xp.kata.gildedrose;

public class Passes extends Item {
    public Passes(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void update() {
        super.update();

        if (getSellIn() < 0) {
            clearQuality();
        }
    }

    @Override
    protected int qualityDelta() {
        if (getSellIn() < 5) {
            return 3;
        }
        if (getSellIn() < 10) {
            return 2;
        }
        return 1;
    }

}
