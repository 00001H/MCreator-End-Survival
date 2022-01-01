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
public class TeleportPlayerProcedure {
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
		if ((entity.level.dimension()) == (Level.OVERWORLD) && (entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining == 0) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "go_end");
			}
		}
	}
}
