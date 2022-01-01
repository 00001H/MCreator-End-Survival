package net.mcreator.endsurvival.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;

import net.mcreator.endsurvival.network.EndSurvivalModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BanReturnProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		Entity entity = event.getEntity();
		execute(event, event.getDimension(), entity);
	}

	public static void execute(ResourceKey<Level> dimension, Entity entity) {
		execute(null, dimension, entity);
	}

	private static void execute(@Nullable Event event, ResourceKey<Level> dimension, Entity entity) {
		if (dimension == null || entity == null)
			return;
		if (entity instanceof Player) {
			if ((dimension) == (Level.OVERWORLD) && (entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining == 0) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}
