
package net.mcreator.endsurvival.item;

import net.minecraft.entity.ai.attributes.Attributes;

@EndSurvivalModElements.ModElement.Tag
public class EndEssenceItem extends EndSurvivalModElements.ModElement {

	@ObjectHolder("end_survival:end_essence")
	public static final Item block = null;

	public EndEssenceItem(EndSurvivalModElements instance) {
		super(instance, 52);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("end_essence");
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
