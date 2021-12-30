package net.mcreator.endsurvival.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SetWorldSpawnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency world for procedure SetWorldSpawn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency x for procedure SetWorldSpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency y for procedure SetWorldSpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency z for procedure SetWorldSpawn!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency entity for procedure SetWorldSpawn!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		if (world.getWorldInfo() instanceof ISpawnWorldInfo)
			((ISpawnWorldInfo) world.getWorldInfo()).setSpawn(new BlockPos((int) x, (int) y, (int) z), 0);
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent((entity.getDisplayName().getString() + " set spawn to (" + x + "," + y + "," + z + ")!")),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}

}
