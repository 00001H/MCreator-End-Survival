package net.mcreator.endsurvival.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.item.ExperienceOrbEntity;

import net.mcreator.endsurvival.EndSurvivalMod;

import java.util.Random;
import java.util.Map;

public class EndDiamondOreBlockDestroyedByPlayerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency x for procedure EndDiamondOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency y for procedure EndDiamondOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency z for procedure EndDiamondOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency world for procedure EndDiamondOreBlockDestroyedByPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.isRemote()))) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) (((new Random()).nextInt((int) 7 + 1)) + 10)));
			}
		}
	}
}
