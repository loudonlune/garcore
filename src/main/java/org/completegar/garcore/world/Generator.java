package org.completegar.garcore.world;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Generator implements IWorldGenerator{

	ArrayList<GeneratorLogic> lr;
	
	public Generator(){
		lr = new ArrayList<GeneratorLogic>();
	}
	
	public void addLogic(GeneratorLogic gl){
		lr.add(gl);
	}
	
	public void register(){
		GameRegistry.registerWorldGenerator(this, 2);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		
		for(GeneratorLogic gl : lr){
			if(gl.dim == world.provider.getDimensionId()){
				gl.dispatch(random, chunkX, chunkZ, world);
			}else if(gl.dim == gl.DIM_DEFAULT){
				gl.dispatch(random, chunkX, chunkZ, world);
			}
		}
		
	}
	
}
