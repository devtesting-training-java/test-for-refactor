package io.xp.kata.gildedrose;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void update() {
    }

    @Override
    protected int qualityDelta() {
        return 0;
    }
}
