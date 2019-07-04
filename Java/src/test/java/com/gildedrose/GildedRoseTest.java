package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    //@Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void testUpdateQuality_onceSellByDatePassedQualityDegradesTwiceAsFast() {

        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);

    }

    @Test
    public void testUpdateQuality_qualityIsNeverNegative() {

        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);

    }

    //test - "Aged Brie" actually increases in Quality the older it gets
	//test - The Quality of an item is never more than 50
	//test - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	//test - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	//test Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    //test Quality drops to 0 after the concert
    //test - "Conjured" items degrade in Quality twice as fast as normal items

}
