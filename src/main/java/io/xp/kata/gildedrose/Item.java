package io.xp.kata.gildedrose;

import java.util.Objects;

public abstract class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update() {
        updateSellIn();
        updateQuality(qualityDelta());
    }

    protected abstract int qualityDelta();

    protected void updateQuality(int delta) {
        quality += delta;
        if (quality < 0) {
            quality = 0;
        }
        if (quality > 50) {
            quality = 50;
        }
    }

    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    protected void clearQuality() {
        quality = 0;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return sellIn == item.sellIn && quality == item.quality && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
