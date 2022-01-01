
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endsurvival.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import net.mcreator.endsurvival.world.features.ores.EndWoodOreFeature;
import net.mcreator.endsurvival.world.features.ores.EndRedstoneOreFeature;
import net.mcreator.endsurvival.world.features.ores.EndIronOreFeature;
import net.mcreator.endsurvival.world.features.ores.EndEmeraldOreFeature;
import net.mcreator.endsurvival.world.features.ores.EndCoalOreFeature;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndSurvivalModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(EndCoalOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, EndCoalOreFeature.GENERATE_BIOMES,
				EndCoalOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(EndIronOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, EndIronOreFeature.GENERATE_BIOMES,
				EndIronOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(EndWoodOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, EndWoodOreFeature.GENERATE_BIOMES,
				EndWoodOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(EndEmeraldOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				EndEmeraldOreFeature.GENERATE_BIOMES, EndEmeraldOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(EndRedstoneOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				EndRedstoneOreFeature.GENERATE_BIOMES, EndRedstoneOreFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
