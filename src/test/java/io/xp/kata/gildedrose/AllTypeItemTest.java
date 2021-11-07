package io.xp.kata.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class AllTypeItemTest {
    @Parameterized.Parameters(name = "{0} tobe {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new NormalItem("normal", 1, 10), new NormalItem("normal", 0, 9)},
                {new NormalItem("normal", 0, 10), new NormalItem("normal", -1, 8)},

                {new AgedBrie("AgedBrie", 1, 10), new AgedBrie("AgedBrie", 0, 11)},
                {new AgedBrie("AgedBrie", 0, 10), new AgedBrie("AgedBrie", -1, 12)},

                {new Sulfuras("Sulfuras", 1, 10), new Sulfuras("Sulfuras", 1, 10)},
                {new Sulfuras("Sulfuras", 1, 51), new Sulfuras("Sulfuras", 1, 51)},
                {new Sulfuras("Sulfuras", 1, -1), new Sulfuras("Sulfuras", 1, -1)},

                {new Passes("Passes", 11, 10), new Passes("Passes", 10, 11)},
                {new Passes("Passes", 10, 10), new Passes("Passes", 9, 12)},
                {new Passes("Passes", 6, 10), new Passes("Passes", 5, 12)},
                {new Passes("Passes", 5, 10), new Passes("Passes", 4, 13)},
                {new Passes("Passes", 1, 10), new Passes("Passes", 0, 13)},
                {new Passes("Passes", 0, 10), new Passes("Passes", -1, 0)},
        });
    }

    @Parameterized.Parameter(0)
    public Item origin;

    @Parameterized.Parameter(1)
    public Item expect;

    @Test
    public void testUpdate() {
        origin.update();
        assertThat(origin).isEqualTo(expect);
    }

}