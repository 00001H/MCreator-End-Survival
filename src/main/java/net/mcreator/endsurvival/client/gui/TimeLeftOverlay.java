
package net.mcreator.endsurvival.client.gui;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class TimeLeftOverlay {

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();

			int posX = w / 2;
			int posY = h / 2;

			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;

			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}

			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;

			if (

			TimeLeftDisplayOverlayIngameProcedure.execute(entity)) {

				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"Remaining:"
								+ ((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EndSurvivalModVariables.PlayerVariables())).RMins)
								+ ":" + ((entity.getCapability(EndSurvivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EndSurvivalModVariables.PlayerVariables())).RSecs)
								+ "",
						posX + -208, posY + -116, -16777216);
			}

		}
	}

}