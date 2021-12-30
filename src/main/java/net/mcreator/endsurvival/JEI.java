package net.mcreator.endsurvival;

import java.util.*;

import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.mcreator.endsurvival.EndSurvivalModElements;
import net.minecraft.client.gui.IGuiEventListener;

@mezz.jei.api.JeiPlugin
public class JEI implements IModPlugin{
    public static IJeiHelpers helpers;


    @Override
    public ResourceLocation getPluginUid(){
    	return new ResourceLocation("end_survival","default");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration){
    	helpers = registration.getJeiHelpers();
    	registration.addRecipeCategories(new EnderCrafterJeiCategory(jeiHelper.getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration reg){
    	reg.addRecipes(generateEnderCrafterRecipes(),EnderCrafterJeiCategory.Uid);
    }
    private List<EnderCrafterJeiCategory.EnderCrafterRecipeWrapper> generateEnderCrafterRecipes(){
    	List<EnderCrafterJeiCategory.EnderCrafterecipeWrapper> rcps = new ArrayList<>();
    	ArrayList<ItemStack> inputs = new ArrayList<>();
    	ArrayList<ItemStack> outputs = new ArrayList<>();
    	inputs.add(new ItemStack(Blocks.GRASS_BLOCK.asItem()));
    }
    public static class EnderCrafterJeiCategory implements IRecipeCategory<EnderCrafterJeiCategory.EnderCrafterRecipeWrapper>{
    	private stati ResourceLocation Uid = new ResourceLocation("end_survival","endercraftercategory");
    	private final String title;
    	private final IDrawable background;
    	public EnderCrafterJeiCategory(IGuiHelper hlpr){
    		this.title = "Ender Crafter";
    		this.backgroundackground = guiHelper.createDrawable(new ResourceLocation("end_survival","textures/end_crafter_gui_jei.png");
    	}
    }
}
