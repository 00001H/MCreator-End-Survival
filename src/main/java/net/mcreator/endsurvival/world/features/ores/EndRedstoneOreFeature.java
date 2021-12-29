
package net.mcreator.endsurvival.world.features.ores;

public class EndRedstoneOreFeature extends OreFeature {

	public static final EndRedstoneOreFeature FEATURE = (EndRedstoneOreFeature) new EndRedstoneOreFeature()
			.setRegistryName("end_survival:end_redstone_ore");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new OreConfiguration(EndRedstoneOreFeatureRuleTest.INSTANCE, EndSurvivalModBlocks.END_REDSTONE_ORE.defaultBlockState(), 4))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(255)))).squared().count(3);

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public EndRedstoneOreFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		ResourceKey<Level> dimensionType = world.getLevel().dimension();
		boolean dimensionCriteria = false;

		if (dimensionType == Level.END)
			dimensionCriteria = true;

		if (!dimensionCriteria)
			return false;

		return super.place(context);
	}

	private static class EndRedstoneOreFeatureRuleTest extends RuleTest {

		static final EndRedstoneOreFeatureRuleTest INSTANCE = new EndRedstoneOreFeatureRuleTest();
		static final com.mojang.serialization.Codec<EndRedstoneOreFeatureRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		static final RuleTestType<EndRedstoneOreFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("end_survival:end_redstone_ore_match"), () -> codec);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;

			if (blockAt.getBlock() == Blocks.END_STONE)
				blockCriteria = true;

			return blockCriteria;
		}

		protected RuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}

	}

}
