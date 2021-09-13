package net.mcreator.endsurvival.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.endsurvival.item.OverworldPassv3Item;
import net.mcreator.endsurvival.item.OverworldPassv2Item;
import net.mcreator.endsurvival.item.OverworldPassv1Item;
import net.mcreator.endsurvival.EndSurvivalModVariables;
import net.mcreator.endsurvival.EndSurvivalMod;

import java.util.Map;

public class GrantOverworldTimeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EndSurvivalMod.LOGGER.warn("Failed to load dependency entity for procedure GrantOverworldTime!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double grant = 0;
		grant = (double) 0;
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == OverworldPassv1Item.block)) {
			grant = (double) 6000;
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == OverworldPassv2Item.block)) {
			grant = (double) 12000;
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == OverworldPassv3Item.block)) {
			grant = (double) 27000;
		}
		if ((grant > 0)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				_setstack.setCount(
						(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
								- 1));
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
		{
			double _setval = (double) (((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining) + grant);
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.overworldPassRemaining = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
