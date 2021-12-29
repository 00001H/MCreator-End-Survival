
package net.mcreator.endsurvival.world.features.ores;

public class EndEmeraldOreFeature extends OreFeature {

	public static final EndEmeraldOreFeature FEATURE = (EndEmeraldOreFeature) new EndEmeraldOreFeature()
			.setRegistryName("end_survival:end_emerald_ore");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new OreConfiguration(EndEmeraldOreFeatureRuleTest.INSTANCE, EndSurvivalModBlocks.END_EMERALD_ORE.defaultBlockState(), 1))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(255)))).squared().count(3);

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public EndEmeraldOreFeature() {
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

	private static class EndEmeraldOreFeatureRuleTest extends RuleTest {

		static final EndEmeraldOreFeatureRuleTest INSTANCE = new EndEmeraldOreFeatureRuleTest();
		static final com.mojang.serialization.Codec<EndEmeraldOreFeatureRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		static final RuleTestType<EndEmeraldOreFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("end_survival:end_emerald_ore_match"), () -> codec);

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
