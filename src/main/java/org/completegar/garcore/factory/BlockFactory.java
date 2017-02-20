package org.completegar.garcore.factory;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFactory {
	
	private static int blocksMade = 0;
	
	/** Make blocks fast, this is not recommended for anything more than static blocks that are not used for anything or stuff like redstone.*/
	public static Block makeBlock(BlockCreationForm bcf){
		Block r;
		if(bcf.material == null){
			System.err.println("BlockFactory: BlockCreationForm is missing required parameters.");
			throw new IllegalArgumentException("BlockFactory: missing vital argument");
		}
		if(bcf.unlocalizedName == null){
			bcf.unlocalizedName = new String("garcoreblock").concat(Integer.toString(blocksMade + 1));
		}
		if(bcf.dropItem != null){
			r = new BFTemplateDroppable(bcf);
		}else{
			r = new BFTemplate(bcf.material);
			r.setUnlocalizedName(bcf.unlocalizedName);
			r.setLightLevel(bcf.lightLevel);
			r.setCreativeTab(bcf.creativeTab);
			r.setStepSound(bcf.soundType);
			r.setHardness(bcf.hardness);
			r.setResistance(bcf.resistance);
			r.setHarvestLevel(bcf.harvestTool, bcf.harvestLevel);
		}
		blocksMade++;
		return r;
	}
}
