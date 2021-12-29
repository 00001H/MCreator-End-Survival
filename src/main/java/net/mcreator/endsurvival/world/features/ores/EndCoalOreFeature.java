
package net.mcreator.endsurvival.world.features.ores;

public class EndCoalOreFeature extends OreFeature {

	public static final EndCoalOreFeature FEATURE = (EndCoalOreFeature) new EndCoalOreFeature().setRegistryName("end_survival:end_coal_ore");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new OreConfiguration(EndCoalOreFeatureRuleTest.INSTANCE, EndSurvivalModBlocks.END_COAL_ORE.defaultBlockState(), 13))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(255)))).squared().count(5);

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public EndCoalOreFeature() {
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

	private static class EndCoalOreFeatureRuleTest extends RuleTest {

		static final EndCoalOreFeatureRuleTest INSTANCE = new EndCoalOreFeatureRuleTest();
		static final com.mojang.serialization.Codec<EndCoalOreFeatureRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		static final RuleTestType<EndCoalOreFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("end_survival:end_coal_ore_match"), () -> codec);

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
