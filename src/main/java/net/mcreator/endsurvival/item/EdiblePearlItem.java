
package net.mcreator.endsurvival.item;

public class EdiblePearlItem extends Item {

	public EdiblePearlItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(16).rarity(Rarity.UNCOMMON)
				.food((new FoodProperties.Builder()).nutrition(5).saturationMod(1f)

						.build()));
		setRegistryName("edible_pearl");
	}

}
