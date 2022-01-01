package net.mcreator.endsurvival.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NoNetherProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		Entity entity = event.getEntity();
		execute(event, event.getDimension());
	}

	public static void execute(ResourceKey<Level> dimension) {
		execute(null, dimension);
	}

	private static void execute(@Nullable Event event, ResourceKey<Level> dimension) {
		if (dimension == null)
			return;
		if ((dimension) == (Level.NETHER)) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
