package net.mcreator.endsurvival.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.endsurvival.network.EndSurvivalModVariables;
import net.mcreator.endsurvival.init.EndSurvivalModItems;

public class GrantOverworldTimeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double grant = 0;
		grant = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getItem() == EndSurvivalModItems.OVERWORLD_PASSV_1) {
			grant = 3500;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getItem() == EndSurvivalModItems.OVERWORLD_PASSV_2) {
			grant = 11000;
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getItem() == EndSurvivalModItems.OVERWORLD_PASSV_3) {
			grant = 27000;
		}
		if (grant > 0) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				_setstack.setCount((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getCount() - 1));
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.getInventory().setChanged();
			}
		}
		{
			double _setval = (entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndSurvivalModVariables.PlayerVariables())).overworldPassRemaining + grant;
			entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.overworldPassRemaining = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
