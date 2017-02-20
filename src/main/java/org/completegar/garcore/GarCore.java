package org.completegar.garcore;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.completegar.garcore.blocks.BlockList;
import org.completegar.garcore.register.Register;
import org.completegar.garcore.world.Generator;
import org.completegar.garcore.world.OreGeneratorLogic;

@Mod(modid = GarCore.MODID, version = GarCore.VERSION)
public class GarCore{
    public static final String MODID = "garcore";
    public static final String VERSION = "A0.1";
    
    public static CreativeTabs tab = new CreativeTabs("garcore"){
    	@Override
    	public Item getTabIconItem(){
    		return Item.getItemFromBlock(BlockList.nulltest);
    	}
    };
    
    Generator gen;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
    	Register.init();
    	BlockList.init();
    	gen = new Generator();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
		System.out.println("GarCore " + VERSION + " init start.");
		long now = System.currentTimeMillis();
		
		Register.addToRegister(BlockList.nulltest);
		
		long taken = System.currentTimeMillis() - now;
		System.out.println("GarCore init finished, took " + taken + " milliseconds.");
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
    	Register.close();
    	gen.register();
    }
}