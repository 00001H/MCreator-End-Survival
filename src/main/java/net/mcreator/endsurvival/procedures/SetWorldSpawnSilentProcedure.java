package net.mcreator.endsurvival.procedures;

import net.minecraft.world.storage.ISpawnWorldInfo;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.endsurvival.EndSurvivalMod;

import java.util.Map;

public class SetWorldSpawnSilentProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency x for procedure SetWorldSpawnSilent!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency y for procedure SetWorldSpawnSilent!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency z for procedure SetWorldSpawnSilent!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency world for procedure SetWorldSpawnSilent!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world.getWorldInfo() instanceof ISpawnWorldInfo)
			((ISpawnWorldInfo) world.getWorldInfo()).setSpawn(new BlockPos((int) x, (int) y, (int) z), 0);
	}
}
