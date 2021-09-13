
package net.mcreator.endsurvival.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.endsurvival.EndSurvivalModElements;

@EndSurvivalModElements.ModElement.Tag
public class RedstoneChunkItem extends EndSurvivalModElements.ModElement {
	@ObjectHolder("end_survival:redstone_chunk")
	public static final Item block = null;
	public RedstoneChunkItem(EndSurvivalModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.REDSTONE).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("redstone_chunk");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
