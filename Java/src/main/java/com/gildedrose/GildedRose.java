package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    public static final String AGED_ITEM = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        
        (Arrays.asList(items)).forEach(item -> {

            switch (item.name) {

                case AGED_ITEM: updateAgedItemQuality(item); break;

                case BACKSTAGE_PASSES: updateBackstageQuality(item); break;

                case SULFURAS: updateSulfurasQuality(item); break;

                default: updateRegularItemQuality(item);

            }

        });
        
    }

    public static void updateRegularItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void updateSulfurasQuality(Item item) {
        item.quality = 80;
    }

    private void updateBackstageQuality(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.quality < 50) {
                if (item.sellIn < 11) {
                    item.quality = item.quality + 1;
                }

                if (item.sellIn < 6) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }

    private void updateAgedItemQuality(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;
        
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

}