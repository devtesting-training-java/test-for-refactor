package io.xp.kata.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import io.xp.kata.NormalItem;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new NormalItem("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }

}