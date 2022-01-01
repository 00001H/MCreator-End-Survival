package net.mcreator.endsurvival.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endsurvival.network.EndSurvivalModVariables;

public class RemoveTimeCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.overworldPassRemaining = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
