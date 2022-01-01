package net.mcreator.endsurvival.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.endsurvival.init.EndSurvivalModItems;

import java.util.function.Supplier;
import java.util.Map;

public class EndCrafterOnCraftProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean success = false;
		double i = 0;
		double Consumption = 0;
		success = true;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getItem() == Blocks.GRASS_BLOCK.asItem()
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.GRASS_BLOCK.asItem()
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Items.APPLE
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Items.CHORUS_FRUIT
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == EndSurvivalModItems.END_ESSENCE
				&& new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get()instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(4) > 0
				&& ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY)
								.getItem() == EndSurvivalModItems.OVERWORLD_PASSV_1
						&& new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get()instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(5) < 5 || new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get()instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(5) == 0)) {
			Consumption = 1;
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get()instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(EndSurvivalModItems.OVERWORLD_PASSV_1);
				_setstack.setCount((int) (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get()instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(5) + 1));
				((Slot) _slots.get(5)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getItem() == EndSurvivalModItems.OVERWORLD_PASSV_1
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == EndSurvivalModItems.OVERWORLD_PASSV_1
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getItem() == Blocks.BIRCH_SAPLING.asItem()
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.WHITE_WOOL.asItem()
				&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == EndSurvivalModItems.END_ESSENCE
				&& new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get()instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(4) > 1
				&& ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY)
								.getItem() == EndSurvivalModItems.OVERWORLD_PASSV_2
						&& new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get()instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(5) < 5 || new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get()instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(5) == 0)) {
			Consumption = 2;
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get()instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(EndSurvivalModItems.OVERWORLD_PASSV_2);
				_setstack.setCount((int) (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get()instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(5) + 1));
				((Slot) _slots.get(5)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		} else {
			success = false;
		}
		if (success) {
			i = 0;
			for (int index0 = 0; index0 < (int) (4); index0++) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get()instanceof Map _slots) {
					ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY);
					_setstack.setCount((int) (new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
									&& _current.get()instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount((int) i) - 1));
					((Slot) _slots.get((int) i)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				i = i + 1;
			}
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get()instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(EndSurvivalModItems.END_ESSENCE);
				_setstack.setCount((int) (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
								&& _current.get()instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(4) - Consumption));
				((Slot) _slots.get(4)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
