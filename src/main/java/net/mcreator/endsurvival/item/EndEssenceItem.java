
package net.mcreator.endsurvival.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class EndEssenceItem extends Item {
	public EndEssenceItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).stacksTo(64).rarity(Rarity.EPIC));
		setRegistryName("end_essence");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
