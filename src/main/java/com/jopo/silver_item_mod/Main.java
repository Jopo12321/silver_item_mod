package com.jopo.silver_item_mod;

import com.jopo.silver_item_mod.block.MainBlock;
import com.jopo.silver_item_mod.world.OreGeneration;
import com.jopo.silver_item_mod.item.MainItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final String MOD_ID = "silver_item_mod";
	public static final String MOD_VERSION = "1.0.0";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(MainItem.SILVER_INGOT));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Starting " + MOD_ID + " version: " + MOD_VERSION);

		MainItem items = new MainItem();
		MainBlock block = new MainBlock();
		OreGeneration oreGeneration = new OreGeneration();

		LOGGER.info("Registering mod items for " + MOD_ID);
		items.registerItems();
		LOGGER.info("Registering mod blocks for " + MOD_ID);
		block.registerBlocks();
		LOGGER.info("Registering ore generation for " + MOD_ID);
		oreGeneration.registerOreGeneration();
	}
}
