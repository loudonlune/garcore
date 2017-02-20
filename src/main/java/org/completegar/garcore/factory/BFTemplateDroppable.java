package org.completegar.garcore.factory;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BFTemplateDroppable extends Block{
	private Item drop;
	private int md;
	private int least_drop;
	private int most_drop;
	public BFTemplateDroppable(BlockCreationForm bcf){
		super(bcf.material);
		drop = bcf.dropItem;
		md = 0;
		least_drop = bcf.minDrop;
		most_drop = bcf.maxDrop;
		setUnlocalizedName(bcf.unlocalizedName);
		setLightLevel(bcf.lightLevel);
		setCreativeTab(bcf.creativeTab);
		setStepSound(bcf.soundType);
		setHardness(bcf.hardness);
		setResistance(bcf.resistance);
		setHarvestLevel(bcf.harvestTool, bcf.harvestLevel);
	}
	
	@Override
	public Item getItemDropped(IBlockState bs, Random r, int f){
		return this.drop;
	}
	
	public int damageDropped(int meta){
		return this.md;
	}
	
	public int quantityDropped(int meta, int f, Random r){
		if(least_drop >= most_drop){
			return least_drop;
		}
		return least_drop + r.nextInt((most_drop + f) - (least_drop + f + 1));
	}
	
}
