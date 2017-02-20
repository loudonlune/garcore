package org.completegar.garcore.blocks;

import org.completegar.garcore.GarCore;
import org.completegar.garcore.factory.BlockCreationForm;
import org.completegar.garcore.factory.BlockFactory;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockList {
	
	public static Block nulltest;
	
	public static void init(){
		{
			BlockCreationForm mr = new BlockCreationForm();
			mr.material = Material.rock;
			mr.hardness = 10;
			mr.resistance = 20;
			mr.unlocalizedName = "nullTest";
			mr.lightLevel = 0;
			mr.creativeTab = GarCore.tab;
			nulltest = BlockFactory.makeBlock(mr);
		}	
	}
}
