package org.completegar.garcore.register;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Register {
	public static ArrayList<Block> blocks;
	public static ArrayList<Item> items;
	public static boolean closed = false;
	
	public static void init(){
		items = new ArrayList<Item>();
		blocks = new ArrayList<Block>();
	}
	
	public static boolean addToRegister(Block b){
		if(closed){
			System.err.println("A mod attempted to insert a block after the Register was closed.");
			return false;
		}
		blocks.add(b);
		return true;
	}
	
	public static boolean removeFromRegister(Block b){
		if(closed){
			System.err.println("A mod attempted to remove a block after the Register was closed.");
			return false;
		}
		blocks.remove(b);
		return true;
	}
	
	public static boolean addToRegister(Item i){
		if(closed){
			System.err.println("A mod attempted to insert an item after the Register was closed.");
			return false;
		}
		items.add(i);
		return true;
	}
	
	public static boolean removeFromRegister(Item i){
		if(closed){
			System.err.println("A mod attempted to remove an item after the Register was closed.");
			return false;
		}
		items.remove(i);
		return true;
	}
	
	public static void close(){
		if(closed){
			System.err.println("Closure was called more than once, this is not allowed. GarCore is now errored.");
			throw new IllegalStateException("GarCore is in invalid state.");
		}
		for( Block b : blocks ){
			GameRegistry.registerBlock(b, b.getUnlocalizedName());
		}
		for( Item i : items){
			GameRegistry.registerItem(i, i.getUnlocalizedName());
		}
	}
}
