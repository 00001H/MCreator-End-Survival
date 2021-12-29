package net.mcreator.endsurvival.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SetWorldSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData()instanceof WritableLevelData _levelData)
			_levelData.setSpawn(new BlockPos((int) x, (int) y, (int) z), 0);
		if (!world.isClientSide()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().broadcastMessage(
						new TextComponent((entity.getDisplayName().getString() + " set spawn to (" + x + "," + y + "," + z + ")!")), ChatType.SYSTEM,
						Util.NIL_UUID);
		}
	}
}
