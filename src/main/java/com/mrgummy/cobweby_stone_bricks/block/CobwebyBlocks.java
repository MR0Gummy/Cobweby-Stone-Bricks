package com.mrgummy.cobweby_stone_bricks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;

public class CobwebyBlocks extends Block {
	private static boolean IsStepedOn;

	public CobwebyBlocks(Settings settings) {
		super(settings);
	}

	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		super.onLandedUpon(world, state, pos, entity, fallDistance);
		TurnCobweb(world, state, pos);

	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		super.onSteppedOn(world, pos, state, entity);
		IsStepedOn = true;

	}

	public void TurnCobweb(World world, BlockState state, BlockPos pos) {
		world.setBlockState(pos, Blocks.COBWEB.getDefaultState());
		world.addBlockBreakParticles(pos.up(1), state);
		world.addBlockBreakParticles(pos, state);
	}

	static {
		IsStepedOn = false;
	}
}
