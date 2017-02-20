package org.completegar.garcore.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public abstract class GeneratorLogic {
	public static final int DIM_DEFAULT = Integer.MAX_VALUE;
	public GeneratorLogic(int dim){
		this.dim = dim;
	}
	protected int dim;
	public abstract void dispatch(Random random, int chunkX, int chunkZ, World world);
}
