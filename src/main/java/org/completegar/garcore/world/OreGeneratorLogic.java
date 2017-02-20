package org.completegar.garcore.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGeneratorLogic extends GeneratorLogic{

	public int minLevel, maxLevel, depsPerChunk, depSize;
	public WorldGenMinable wgm;
	
	public OreGeneratorLogic(int dim, int minLevel, int maxLevel, IBlockState b, int depSize, int depsPerChunk) {
		super(dim);
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.wgm = new WorldGenMinable(b, depSize);
		this.depsPerChunk = depsPerChunk;
	}

	@Override
	public void dispatch(Random random, int chunkX, int chunkZ, World world) {
		if(minLevel < 0 || maxLevel < 0 || minLevel > 256 || maxLevel > 256 || minLevel > maxLevel){
			throw new IllegalArgumentException("OreGenerator: Height arguments can not be below 0, above 256, or inverse!");
		}
		
		int range = (maxLevel - minLevel) + 1;
		for(int i = 0; i < depsPerChunk; i++){
			int x = chunkX * 16 + random.nextInt(16);
			int y = minLevel + random.nextInt(range);
			int z = chunkZ * 16 + random.nextInt(16);
			wgm.generate(world, random, new BlockPos(x, y, z));
		}
	}
	
}