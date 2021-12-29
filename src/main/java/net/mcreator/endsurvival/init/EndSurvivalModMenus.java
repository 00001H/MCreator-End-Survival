
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endsurvival.init;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.endsurvival.world.inventory.HeatCondenserGuiMenu;
import net.mcreator.endsurvival.world.inventory.EndEssenceExtractorGuiMenu;
import net.mcreator.endsurvival.world.inventory.EndCrafterGuiMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndSurvivalModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<EndEssenceExtractorGuiMenu> END_ESSENCE_EXTRACTOR_GUI = register("end_essence_extractor_gui",
			(id, inv, extraData) -> new EndEssenceExtractorGuiMenu(id, inv, extraData));
	public static final MenuType<HeatCondenserGuiMenu> HEAT_CONDENSER_GUI = register("heat_condenser_gui",
			(id, inv, extraData) -> new HeatCondenserGuiMenu(id, inv, extraData));
	public static final MenuType<EndCrafterGuiMenu> END_CRAFTER_GUI = register("end_crafter_gui",
			(id, inv, extraData) -> new EndCrafterGuiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
