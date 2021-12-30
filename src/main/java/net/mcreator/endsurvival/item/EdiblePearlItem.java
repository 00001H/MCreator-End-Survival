
package net.mcreator.endsurvival.item;

@EndSurvivalModElements.ModElement.Tag
public class EdiblePearlItem extends EndSurvivalModElements.ModElement {

	@ObjectHolder("end_survival:edible_pearl")
	public static final Item block = null;

	public EdiblePearlItem(EndSurvivalModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(5).saturation(1f)

							.build()));
			setRegistryName("edible_pearl");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
