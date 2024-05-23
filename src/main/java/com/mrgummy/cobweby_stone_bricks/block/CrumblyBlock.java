package com.mrgummy.cobweby_stone_bricks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrumblyBlock extends Block {
	public static final BooleanProperty IS_STEPPED_ON;
	public static final IntProperty COBWEBY_BREAK;
	private static BlockState BLOCK = null;
	private static int STAND_TIME;


	public CrumblyBlock(Settings settings, Block block, int stand_time) {
		super(settings);
		this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(IS_STEPPED_ON, false));
		BLOCK = block.getDefaultState();
		STAND_TIME = stand_time;
	}

	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		super.onLandedUpon(world, state, pos, entity, fallDistance);
		Crumble(world, state, pos, BLOCK);

	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		super.onSteppedOn(world, pos, state, entity);
		this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(IS_STEPPED_ON, true));
	}

	public void Crumble(World world, BlockState state, BlockPos pos, BlockState block) {
		world.setBlockState(pos, block);
		world.addBlockBreakParticles(pos.up(1), state);
		world.addBlockBreakParticles(pos, state);
	}
	// waaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah
	static {
		IS_STEPPED_ON = BooleanProperty.of("is_stepped_on");
		STAND_TIME = 0;
		COBWEBY_BREAK = IntProperty.of("cobweby_break", 0, STAND_TIME);
	}
}
