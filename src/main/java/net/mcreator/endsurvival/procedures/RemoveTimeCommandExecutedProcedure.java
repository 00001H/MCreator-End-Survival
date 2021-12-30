package net.mcreator.endsurvival.procedures;

import net.minecraftforge.eventbus.api.Event;

public class RemoveTimeCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency entity for procedure RemoveTimeCommandExecuted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		{
			double _setval = 0;
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.overworldPassRemaining = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}

}
