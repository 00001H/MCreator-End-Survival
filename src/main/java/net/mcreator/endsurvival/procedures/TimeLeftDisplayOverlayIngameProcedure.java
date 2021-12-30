package net.mcreator.endsurvival.procedures;

import net.minecraftforge.eventbus.api.Event;

public class TimeLeftDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency entity for procedure TimeLeftDisplayOverlayIngame!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		return (entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining > 0;
	}

}
