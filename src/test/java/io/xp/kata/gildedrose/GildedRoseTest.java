package io.xp.kata.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new NormalItem("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals("foo", app.items[0].getName());
        assertThat(app.items[0].getQuality(), is(4));
        assertThat(app.items[0].getSellIn(), is(0));
    }

}
