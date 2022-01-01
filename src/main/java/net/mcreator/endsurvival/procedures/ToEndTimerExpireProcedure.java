package net.mcreator.endsurvival.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.endsurvival.network.EndSurvivalModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ToEndTimerExpireProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			execute(event, entity);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (Level.OVERWORLD)) {
			if ((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining > 0) {
				{
					double _setval = (entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining - 1;
					entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.overworldPassRemaining = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining < 0) {
			{
				double _setval = 0;
				entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.overworldPassRemaining = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			String _setval = new java.text.DecimalFormat("##")
					.format(Math.floor((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining / 1200));
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RMins = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = new java.text.DecimalFormat("##.#")
					.format(((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining % 1200) / 20);
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RSecs = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
