package com.jopo.silver_item_mod.world;

import com.jopo.silver_item_mod.Main;
import com.jopo.silver_item_mod.block.MainBlock;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OreGeneration {

    public OreGeneration() {

    }

    public static final List<OreFeatureConfig.Target> OVERWORLD_SILVER_ORES = List.of(
            OreFeatureConfig.createTarget(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MainBlock.SILVER_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(
                    OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MainBlock.DEEPSLATE_SILVER_ORE.getDefaultState()));

    private static final ConfiguredFeature<?, ?> OVERWORLD_SILVER_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES,10)); // vein size

    public static final PlacedFeature OVERWORLD_SILVER_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_SILVER_ORE_CONFIGURED_FEATURE),
            modifiersWithCount(
                    4,
                    HeightRangePlacementModifier.trapezoid(
                            YOffset.fixed(-64),
                            YOffset.fixed(32)
                    )
            )
    );
    public static final PlacedFeature OVERWORLD_SILVER_ORE_PLACED_FEATURE_LOWER = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_SILVER_ORE_CONFIGURED_FEATURE),
            modifiers(
                    CountPlacementModifier.of(UniformIntProvider.create(0, 1)),
                    HeightRangePlacementModifier.uniform(
                            YOffset.fixed(-64),
                            YOffset.fixed(-48)
                    )
            )
    );

    public void registerOreGeneration() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Main.MOD_ID, "overworld_silver_ore"), OVERWORLD_SILVER_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Main.MOD_ID, "overworld_silver_ore"),
                OVERWORLD_SILVER_ORE_PLACED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Main.MOD_ID, "overworld_silver_ore_lower"),
                OVERWORLD_SILVER_ORE_PLACED_FEATURE_LOWER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Main.MOD_ID, "overworld_silver_ore")));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Main.MOD_ID, "overworld_silver_ore_lower")));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);

    }
}
