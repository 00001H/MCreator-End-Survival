
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endsurvival.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.endsurvival.block.entity.HeatCondenserBlockEntity;
import net.mcreator.endsurvival.block.entity.EndEssenceExtractorBlockEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndSurvivalModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> END_ESSENCE_EXTRACTOR = register("end_survival:end_essence_extractor",
			EndSurvivalModBlocks.END_ESSENCE_EXTRACTOR, EndEssenceExtractorBlockEntity::new);
	public static final BlockEntityType<?> HEAT_CONDENSER = register("end_survival:heat_condenser", EndSurvivalModBlocks.HEAT_CONDENSER,
			HeatCondenserBlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
