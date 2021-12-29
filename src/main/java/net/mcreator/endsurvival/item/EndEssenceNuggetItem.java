
package net.mcreator.endsurvival.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class EndEssenceNuggetItem extends Item {

	public EndEssenceNuggetItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).stacksTo(64).rarity(Rarity.EPIC));
		setRegistryName("end_essence_nugget");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

}
