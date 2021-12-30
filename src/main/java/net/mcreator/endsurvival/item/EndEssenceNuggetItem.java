
package net.mcreator.endsurvival.item;

import net.minecraft.entity.ai.attributes.Attributes;

@EndSurvivalModElements.ModElement.Tag
public class EndEssenceNuggetItem extends EndSurvivalModElements.ModElement {

	@ObjectHolder("end_survival:end_essence_nugget")
	public static final Item block = null;

	public EndEssenceNuggetItem(EndSurvivalModElements instance) {
		super(instance, 53);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("end_essence_nugget");
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
