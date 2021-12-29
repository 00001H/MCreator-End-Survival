
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endsurvival.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.endsurvival.item.RedstoneChunkItem;
import net.mcreator.endsurvival.item.OverworldPassv3Item;
import net.mcreator.endsurvival.item.OverworldPassv2Item;
import net.mcreator.endsurvival.item.OverworldPassv1Item;
import net.mcreator.endsurvival.item.EndEssenceNuggetItem;
import net.mcreator.endsurvival.item.EndEssenceItem;
import net.mcreator.endsurvival.item.EdiblePearlItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndSurvivalModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item END_COAL_ORE = register(EndSurvivalModBlocks.END_COAL_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item END_IRON_ORE = register(EndSurvivalModBlocks.END_IRON_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item END_WOOD_ORE = register(EndSurvivalModBlocks.END_WOOD_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item END_EMERALD_ORE = register(EndSurvivalModBlocks.END_EMERALD_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item END_ESSENCE_EXTRACTOR = register(EndSurvivalModBlocks.END_ESSENCE_EXTRACTOR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item EDIBLE_PEARL = register(new EdiblePearlItem());
	public static final Item HEAT_CONDENSER = register(EndSurvivalModBlocks.HEAT_CONDENSER, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item END_REDSTONE_ORE = register(EndSurvivalModBlocks.END_REDSTONE_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item OVERWORLD_PASSV_1 = register(new OverworldPassv1Item());
	public static final Item OVERWORLD_PASSV_2 = register(new OverworldPassv2Item());
	public static final Item OVERWORLD_PASSV_3 = register(new OverworldPassv3Item());
	public static final Item ENDER_CRAFTER = register(EndSurvivalModBlocks.ENDER_CRAFTER, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item END_ESSENCE = register(new EndEssenceItem());
	public static final Item END_ESSENCE_NUGGET = register(new EndEssenceNuggetItem());
	public static final Item REDSTONE_CHUNK = register(new RedstoneChunkItem());
	public static final Item SPAWNPOINT_SETTER = register(EndSurvivalModBlocks.SPAWNPOINT_SETTER, CreativeModeTab.TAB_REDSTONE);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
