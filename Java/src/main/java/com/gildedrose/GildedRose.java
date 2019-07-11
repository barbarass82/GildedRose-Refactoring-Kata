package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        
        (Arrays.asList(items)).forEach(item -> {

            switch (item.name) {

                case "Aged Brie": updateChesseQuality(item); break;

                case "Backstage passes to a TAFKAL80ETC concert": updateBackstageQuality(item); break;

                case "Sulfuras, Hand of Ragnaros": updateSulfurasQuality(item); break;

                default: updateRegularItemQuality(item);

            }

        });
        
    }

    public static void updateRegularItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                    item.quality = item.quality - 1;
            }
        }
    }

    private void updateSulfurasQuality(Item item) {
        item.quality = 80;
    }

    private void updateBackstageQuality(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.quality < 50) {
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

    private void updateChesseQuality(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;
        
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

}