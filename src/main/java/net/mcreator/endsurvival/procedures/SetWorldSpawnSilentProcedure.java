package net.mcreator.endsurvival.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SetWorldSpawnSilentProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getLevelData()instanceof WritableLevelData _levelData)
			_levelData.setSpawn(new BlockPos((int) x, (int) y, (int) z), 0);
	}
}
