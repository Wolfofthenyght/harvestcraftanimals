package com.nyghtwolf.harvestcraftanimals;

import com.nyghtwolf.harvestcraftanimals.configuration.ConfigurationHandler;
import com.nyghtwolf.harvestcraftanimals.configuration.WNDropHandler;
import com.nyghtwolf.harvestcraftanimals.init.modEntity;
import com.nyghtwolf.harvestcraftanimals.init.modItems;
import com.nyghtwolf.harvestcraftanimals.proxy.CommonProxy;
import com.nyghtwolf.harvestcraftanimals.reference.reference;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import static cpw.mods.fml.common.Mod.EventHandler;

@Mod(modid= reference.MOD_ID, name="harvestcraftanimals", version="1.7.10-0.1a")
public class harvestcraftanimals {

    @Instance(reference.MOD_ID)
    public static harvestcraftanimals instance;
    
    public static final String modid = "harvestcraftanimals";

    @SidedProxy(clientSide="com.nyghtwolf.harvestcraftanimals.proxy.ClientProxy", serverSide="com.nyghtwolf.harvestcraftanimals.proxy.CommonProxy")

    public static CommonProxy Wolfproxy;
    //public static ClientProxy ClientProxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        modEntity.registerEntity();

        //Items Init
        modItems.init();

        //Block Init
        //ModBlocks.init();

        //TileEntity Init
        //ModTileEntities.init();

        //Recipes Init
        //ModRecipes.init();

        //Renders Init
        Wolfproxy.registerRenderThings();
    }

    @EventHandler
    public void init(FMLInitializationEvent event){

        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, guiHandler);
    	//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GemworksGuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new WNDropHandler());
        FMLCommonHandler.instance().bus().register(new WNDropHandler());
    }
}
