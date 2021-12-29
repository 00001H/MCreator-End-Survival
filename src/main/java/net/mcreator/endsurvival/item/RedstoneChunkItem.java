
package net.mcreator.endsurvival.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

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
