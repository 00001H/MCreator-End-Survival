package net.mcreator.endsurvival;

import java.util.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

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

import net.mcreator.endsurvival.item.OverworldPassv3Item;
import net.mcreator.endsurvival.item.OverworldPassv2Item;
import net.mcreator.endsurvival.item.OverworldPassv1Item;
import net.mcreator.endsurvival.item.EndEssenceItem;
import net.mcreator.endsurvival.block.EnderCrafterBlock;
import net.minecraft.network.chat.Component;

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
        registration.addRecipeCategories(new EnderCrafterJeiCategory(helpers.getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration reg){
        reg.addRecipes(generateEnderCrafterRecipes(),EnderCrafterJeiCategory.Uid);
    }
    private List<EnderCrafterJeiCategory.EnderCrafterRecipeWrapper> generateEnderCrafterRecipes(){
        List<EnderCrafterJeiCategory.EnderCrafterRecipeWrapper> rcps = new ArrayList<>();
        {//recipe 1
            ArrayList<ItemStack> inputs = new ArrayList<>();
            ArrayList<ItemStack> outputs = new ArrayList<>();
            inputs.add(new ItemStack(Blocks.GRASS_BLOCK.asItem()));//0
            inputs.add(new ItemStack(Items.APPLE));//1
            inputs.add(new ItemStack(Items.CHORUS_FRUIT));//2
            inputs.add(new ItemStack(Blocks.GRASS_BLOCK.asItem()));//3
            inputs.add(new ItemStack(new EndEssenceItem()));//4
            outputs.add(new ItemStack(new OverworldPassv1Item()));//5
            rcps.add(new EnderCrafterJeiCategory.EnderCrafterRecipeWrapper(inputs,outputs));
        }
        {//recipe 2
            ArrayList<ItemStack> inputs = new ArrayList<>();
            ArrayList<ItemStack> outputs = new ArrayList<>();
            inputs.add(new ItemStack(new OverworldPassv1Item()));//0
            inputs.add(new ItemStack(Blocks.BIRCH_SAPLING.asItem()));//1
            inputs.add(new ItemStack(Blocks.WHITE_WOOL.asItem()));//2
            inputs.add(new ItemStack(new OverworldPassv1Item()));//3
            ItemStack es = new ItemStack(new EndEssenceItem());
            es.setCount(2);
            inputs.add(es);//4
            outputs.add(new ItemStack(new OverworldPassv2Item()));//5
            rcps.add(new EnderCrafterJeiCategory.EnderCrafterRecipeWrapper(inputs,outputs));
        }
        return rcps;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration reg){
    	reg.addRecipeCatalyst(new ItemStack(new EnderCrafterBlock().asItem()),EnderCrafterJeiCategory.Uid);
    }

    public static class EnderCrafterJeiCategory implements IRecipeCategory<EnderCrafterJeiCategory.EnderCrafterRecipeWrapper>{
        private static ResourceLocation Uid = new ResourceLocation("end_survival","endercraftercategory");
        private final Component title;
        private final IDrawable background;
        public EnderCrafterJeiCategory(IGuiHelper hlpr){
            this.title = new TranslatableComponent("block.end_survival.ender_crafter");
            this.background = hlpr.createDrawable(new ResourceLocation("end_survival","textures/end_crafter_gui_jei.png"),0,0,148,69);
        }

        @Override
        public ResourceLocation getUid(){
            return Uid;
        }

        @Override
        public Class<? extends EnderCrafterRecipeWrapper> getRecipeClass(){
            return EnderCrafterJeiCategory.EnderCrafterRecipeWrapper.class;
        }

        @Override
        public Component getTitle(){
            return title;
        }

        @Override
        public IDrawable getBackground(){
            return background;
        }

        @Override
        public IDrawable getIcon(){
            return null;
        }

        @Override
        public void setIngredients(EnderCrafterRecipeWrapper wrapper,IIngredients ingr){
            ingr.setInputs(VanillaTypes.ITEM,wrapper.getInput());
            ingr.setOutputs(VanillaTypes.ITEM,wrapper.getOutput());
        }

        @Override
        public void setRecipe(IRecipeLayout rclo,EnderCrafterRecipeWrapper wrapper,IIngredients ingr){
            IGuiItemStackGroup stacks = rclo.getItemStacks();
            stacks.init(0,true,14,8);
            stacks.init(1,true,14,44);
            stacks.init(2,true,50,44);
            stacks.init(3,true,50,8);
            stacks.init(4,true,32,26);
            stacks.init(5,false,122,26);
            for(int x=0;x<5;x++)stacks.set(x,ingr.getInputs(VanillaTypes.ITEM).get(x));
            stacks.set(5,ingr.getOutputs(VanillaTypes.ITEM).get(0));
        }

        public static class EnderCrafterRecipeWrapper{
            private List<ItemStack> input;
            private List<ItemStack> output;
            public EnderCrafterRecipeWrapper(List<ItemStack> input,List<ItemStack> output){
                this.input = input;
                this.output = output;
            }

            public List<ItemStack> getInput(){
                return input;
            }

            public List<ItemStack> getOutput(){
                return output;
            }
        }
    }
}
