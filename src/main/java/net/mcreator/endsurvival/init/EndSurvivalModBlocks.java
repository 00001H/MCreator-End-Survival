
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endsurvival.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;

import net.mcreator.endsurvival.block.SpawnpointSetterBlock;
import net.mcreator.endsurvival.block.HeatCondenserBlock;
import net.mcreator.endsurvival.block.EnderCrafterBlock;
import net.mcreator.endsurvival.block.EndWoodOreBlock;
import net.mcreator.endsurvival.block.EndRedstoneOreBlock;
import net.mcreator.endsurvival.block.EndIronOreBlock;
import net.mcreator.endsurvival.block.EndEssenceExtractorBlock;
import net.mcreator.endsurvival.block.EndEmeraldOreBlock;
import net.mcreator.endsurvival.block.EndCoalOreBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndSurvivalModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block END_COAL_ORE = register(new EndCoalOreBlock());
	public static final Block END_IRON_ORE = register(new EndIronOreBlock());
	public static final Block END_WOOD_ORE = register(new EndWoodOreBlock());
	public static final Block END_EMERALD_ORE = register(new EndEmeraldOreBlock());
	public static final Block END_ESSENCE_EXTRACTOR = register(new EndEssenceExtractorBlock());
	public static final Block HEAT_CONDENSER = register(new HeatCondenserBlock());
	public static final Block END_REDSTONE_ORE = register(new EndRedstoneOreBlock());
	public static final Block ENDER_CRAFTER = register(new EnderCrafterBlock());
	public static final Block SPAWNPOINT_SETTER = register(new SpawnpointSetterBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}
}
