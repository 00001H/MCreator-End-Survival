
package net.mcreator.endsurvival.world.features.ores;

public class EndWoodOreFeature extends OreFeature {

	public static final EndWoodOreFeature FEATURE = (EndWoodOreFeature) new EndWoodOreFeature().setRegistryName("end_survival:end_wood_ore");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new OreConfiguration(EndWoodOreFeatureRuleTest.INSTANCE, EndSurvivalModBlocks.END_WOOD_ORE.defaultBlockState(), 2))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(255)))).squared().count(1);

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public EndWoodOreFeature() {
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

	private static class EndWoodOreFeatureRuleTest extends RuleTest {

		static final EndWoodOreFeatureRuleTest INSTANCE = new EndWoodOreFeatureRuleTest();
		static final com.mojang.serialization.Codec<EndWoodOreFeatureRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		static final RuleTestType<EndWoodOreFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("end_survival:end_wood_ore_match"), () -> codec);

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
