package org.completegar.garcore.factory;

import org.completegar.garcore.GarCore;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockCreationForm {
	/** Preset to 0 */
	public int lightLevel = 0;
	/** It is highly advised that you set this or your block will appear as the null texture */
	public String textureName = (GarCore.MODID + ":" + "blocknull");
	/** It is highly advised that you set this or your block will be called "blocknull#" */
	public String unlocalizedName; 
	/** REQUIRED, needs to be set or an exception WILL be thrown*/
	public Material material;
	/** Required for custom item drop, if this is left null the block will drop itself */
	public Item dropItem;
	/** Preset to 7.5 */
	public float hardness = 7.5f;
	/** Preset to 15 */
	public float resistance = 15f;
	/** Required for custom item drop, preset to pickaxe */
	public String harvestTool = "pickaxe";
	/** Preset to 0 */
	public int harvestLevel = 0;
	/** Preset to 1, only used if you are using custom item drops*/
	public int minDrop = 1;
	/** Preset to 1, only used if you are using custom item drops */
	public int maxDrop = 1;
	/** Creative tab, defaults to "blocks" */
	public CreativeTabs creativeTab = CreativeTabs.tabBlock;
	/** The step sound, preset to stone */
	public SoundType soundType = Block.soundTypeStone;
}
