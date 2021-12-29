package net.mcreator.endsurvival.procedures;

import net.minecraftforge.eventbus.api.Event;

public class TimeLeftDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining > 0;
	}
}
