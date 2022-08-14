package com.jopo.silver_item_mod.block;

import com.jopo.silver_item_mod.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MainBlock {

    public static final Block SILVER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool().strength(4.0f, 5.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_SILVER_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.IRON_GRAY).requiresTool().strength(5.0f, 6.0f));
    public static final Block SILVER_ORE = new OreBlock(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f));
    public static final Block DEEPSLATE_SILVER_ORE = new OreBlock(AbstractBlock.Settings.copy(SILVER_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public MainBlock() {

    }

    public void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "silver_block"), SILVER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "silver_block"), new BlockItem(SILVER_BLOCK, new FabricItemSettings().group(Main.MOD_ITEM_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "silver_ore"), SILVER_ORE);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "silver_ore"), new BlockItem(SILVER_ORE, new FabricItemSettings().group(Main.MOD_ITEM_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "deepslate_silver_ore"), DEEPSLATE_SILVER_ORE);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "deepslate_silver_ore"), new BlockItem(DEEPSLATE_SILVER_ORE, new FabricItemSettings().group(Main.MOD_ITEM_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "raw_silver_block"), RAW_SILVER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "raw_silver_block"), new BlockItem(RAW_SILVER_BLOCK, new FabricItemSettings().group(Main.MOD_ITEM_GROUP)));
    }

}
