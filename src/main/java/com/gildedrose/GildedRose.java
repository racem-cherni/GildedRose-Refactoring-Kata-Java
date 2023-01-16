package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item ->{
            if(!item.name.equals("Sulfuras, Hand of Ragnaros")){

                item.sellIn = item.sellIn-1;

                int sellIn = item.sellIn;
                int quality = item.quality;
                String name = item.name;

                if(!(name.equals("Aged Brie") && (item.quality==50))  && !(!name.equals("Aged Brie") && (quality==0))){
                    if(name.equals("Aged Brie")) item.quality++;
                    else if (name.equals("Backstage passes to a TAFKAL80ETC concert")){
                        if (sellIn<0) item.quality=0;
                        else {
                            if(quality<50){
                                int qualityToIncrease;
                                if (sellIn>10) qualityToIncrease=1;
                                else if(sellIn>5) qualityToIncrease=2;
                                else qualityToIncrease=3;

                                item.quality = Math.min(quality + qualityToIncrease, 50);
                            }
                        }
                    }
                    else {
                        int qualityToDecrease;
                        if(sellIn>=0) qualityToDecrease=1;
                        else qualityToDecrease=2;

                        if(quality-qualityToDecrease<0) item.quality = 0;
                        else item.quality = item.quality - qualityToDecrease;
                    }
                }
            }
        } );
    }
}
