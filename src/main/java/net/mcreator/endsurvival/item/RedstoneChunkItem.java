
package net.mcreator.endsurvival.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class RedstoneChunkItem extends Item {
	public RedstoneChunkItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("redstone_chunk");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
