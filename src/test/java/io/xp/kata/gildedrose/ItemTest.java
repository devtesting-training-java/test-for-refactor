package io.xp.kata.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
    private class ItemForTest extends Item {
        public ItemForTest(int sellIn, int quality) {
            super("item", sellIn, quality);
        }

        @Override
        protected int qualityDelta() {
            return 0;
        }
    }

    @Test
    public void testUpdate_will_decrease_sellIn_after_expired() {
        Item item = new ItemForTest(-2, 0);
        item.update();
        assertThat(item.getSellIn()).isEqualTo(-3);
    }

    @Test
    public void testUpdateQuality_will_not_more_than_50() {
        Item item = new ItemForTest(2, 10);
        item.updateQuality(41);
        assertThat(item.getQuality()).isEqualTo(50);
    }

    @Test
    public void testUpdateQuality_will_not_less_than_0() {
        Item item = new ItemForTest(2, 10);
        item.updateQuality(-11);
        assertThat(item.getQuality()).isEqualTo(0);
    }

    @Test
    public void testNewItem_will_keep_quality_out_of_limit() {
        assertThat(new ItemForTest(2, -2).getQuality()).isEqualTo(-2);
        assertThat(new ItemForTest(2, 51).getQuality()).isEqualTo(51);
    }

    @Test
    public void testUpdateQuality_will_fix_original_value_more_than_50() {
        Item item = new ItemForTest(2, 60);
        item.updateQuality(0);
        assertThat(item.getQuality()).isEqualTo(50);
    }

    @Test
    public void testUpdateQuality_will_fix_original_value_less_than_0() {
        Item item = new ItemForTest(2, -3);
        item.updateQuality(0);
        assertThat(item.getQuality()).isEqualTo(0);
    }
}
