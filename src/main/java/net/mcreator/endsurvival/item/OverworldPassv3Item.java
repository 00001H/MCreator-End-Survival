
package net.mcreator.endsurvival.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class OverworldPassv3Item extends Item {

	public OverworldPassv3Item() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(5).rarity(Rarity.COMMON));
		setRegistryName("overworld_passv_3");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Grants 22.5 minutes"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		GrantOverworldTimeProcedure.execute(entity);
		return ar;
	}

}
