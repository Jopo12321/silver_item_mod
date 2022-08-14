package com.jopo.silver_item_mod.item;

import com.jopo.silver_item_mod.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MainItem {

    public static final Item SILVER_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item SILVER_NUGGET = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public MainItem() {

    }

    public void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "silver_ingot"), SILVER_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "silver_nugget"), SILVER_NUGGET);
    }

}
