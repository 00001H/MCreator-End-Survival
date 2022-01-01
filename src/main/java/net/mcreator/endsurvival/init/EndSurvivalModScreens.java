
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endsurvival.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.endsurvival.client.gui.HeatCondenserGuiScreen;
import net.mcreator.endsurvival.client.gui.EndEssenceExtractorGuiScreen;
import net.mcreator.endsurvival.client.gui.EndCrafterGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndSurvivalModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EndSurvivalModMenus.END_ESSENCE_EXTRACTOR_GUI, EndEssenceExtractorGuiScreen::new);
			MenuScreens.register(EndSurvivalModMenus.HEAT_CONDENSER_GUI, HeatCondenserGuiScreen::new);
			MenuScreens.register(EndSurvivalModMenus.END_CRAFTER_GUI, EndCrafterGuiScreen::new);
		});
	}
}
