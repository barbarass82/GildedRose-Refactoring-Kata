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

    @Test
    public void testUpdateQuality_agedBrieIncreasesQualityTheOlderItGets() {

        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 10);

    }

    @Test
    public void testUpdateQuality_theQualityOfAnItemIsNeverMoreThan50() {

        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertFalse(app.items[0].quality > 50);

    }

    @Test
    public void testUpdateQuality_sulfurasNeverHastoBeSold() {

        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);

    }

    @Test
    public void testUpdateQuality_sulfurasNeverDecreasesInQuality() {

        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);

    }

    @Test
    public void testUpdateQuality_sulfurasQualityIs80AndNeverAlters() {

        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);

    }

    @Test
    public void testUpdateQuality_backstagePassesIncreasesQualityTheOlderItGets() {

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 10);

    }
    
    @Test
    public void testUpdateQuality_backstagePassesIncreasesQualityBy2WhenThereAre10DAysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void testUpdateQuality_backstagePassesIncreasesQualityBy3WhenThereAre5DAysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void testUpdateQuality_backstagePassesDropsQualityToZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //test - "Conjured" items degrade in Quality twice as fast as normal items
    // new requirement --^
    //@Test
    public void testUpdateQuality_conjuredItemsDegradeInQualityTwiceAsFastAsNormalItens() {
        Item[] items = new Item[] { new Item("Conjured", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

}
