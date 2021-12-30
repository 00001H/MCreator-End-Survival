package net.mcreator.endsurvival.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.endsurvival.EndSurvivalModVariables;
import net.mcreator.endsurvival.EndSurvivalMod;

import java.util.Map;
import java.util.HashMap;

public class ToEndTimerExpireProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency entity for procedure ToEndTimerExpire!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
			if ((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining > 0) {
				{
					double _setval = ((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining - 1);
					entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.overworldPassRemaining = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		{
			String _setval = (new java.text.DecimalFormat("##")
					.format(Math.floor((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining / 1200)));
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RMins = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (new java.text.DecimalFormat("##.#")
					.format(((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining % 1200) / 20));
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RSecs = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
