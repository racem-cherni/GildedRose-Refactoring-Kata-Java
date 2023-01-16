package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
        //case of no special product with when the sell by date has not passed
    void whenSimpleNameCaseOne_thenQuality() {
        Item[] items = new Item[] { new Item("foo", 1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3,app.items[0].quality ,"incorrect quality value");
    }

    @Test
        //case of no special product with no rest day to sell
    void whenSimpleNameCaseTwo_thenQuality() {
        Item[] items = new Item[] { new Item("foo", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].quality ,"incorrect quality value");
    }

    @Test
        //case of no special product when the sell by date has passed
    void whenSimpleNameCaseThree_thenQuality() {
        Item[] items = new Item[] { new Item("foo", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality ,"incorrect quality value");
    }

    @Test
        //case of Aged Brie product when the sell by date has not passed and with a max of quality
    void whenAgedNameCaseOne_thenQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality ,"incorrect quality value");
    }

    @Test
        //case of Aged Brie product with no rest day to sell
    void whenAgedNameCaseTwo_thenQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality ,"incorrect quality value");
    }

    @Test
        //case of Sulfuras product
    void whenSulfurasName_thenItem() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertArrayEquals(new int[] {-1,80},new int[] {app.items[0].sellIn,app.items[0].quality} ,"Sulfuras does not change");
    }

    @Test
        //case of Backstage product with sellIn > 10
    void whenBackstageNameCaseOne_thenQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality ,"incorrect quality value");
    }
    @Test
        //case of Backstage product with sellIn > 10  and with a max of quality
    void whenBackstageNameCaseTwo_thenQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertNotEquals(51,app.items[0].quality ,"incorrect quality value");
    }
    @Test
        //case of Backstage product with 5 < sellIn <= 10
    void whenBackstageNameCaseThree_thenQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32,app.items[0].quality ,"incorrect quality value");
    }
    @Test
        //case of Backstage product with sellIn < 5
    void whenBackstageNameCaseFour_thenQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23,app.items[0].quality ,"incorrect quality value");
    }
    @Test
        //case of Backstage product with no rest day to sell
    void whenBackstageNameCaseFive_thenQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality ,"incorrect quality value");
    }
    @Test
        //case of Conjured product when the sell by date has not passed
    void whenConjuredNameCaseOne_thenQuality() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].quality ,"incorrect quality value");
    }
    @Test
        //case of Conjured product when the sell by date has passed
    void whenConjuredNameCaseTwo_thenQualityShould() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].quality ,"incorrect quality value");
    }

}
