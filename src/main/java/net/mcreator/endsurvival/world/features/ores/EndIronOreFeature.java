
package net.mcreator.endsurvival.world.features.ores;

public class EndIronOreFeature extends OreFeature {

	public static final EndIronOreFeature FEATURE = (EndIronOreFeature) new EndIronOreFeature().setRegistryName("end_survival:end_iron_ore");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new OreConfiguration(EndIronOreFeatureRuleTest.INSTANCE, EndSurvivalModBlocks.END_IRON_ORE.defaultBlockState(), 6))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(255)))).squared().count(3);

	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public EndIronOreFeature() {
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

	private static class EndIronOreFeatureRuleTest extends RuleTest {

		static final EndIronOreFeatureRuleTest INSTANCE = new EndIronOreFeatureRuleTest();
		static final com.mojang.serialization.Codec<EndIronOreFeatureRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		static final RuleTestType<EndIronOreFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("end_survival:end_iron_ore_match"), () -> codec);

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
