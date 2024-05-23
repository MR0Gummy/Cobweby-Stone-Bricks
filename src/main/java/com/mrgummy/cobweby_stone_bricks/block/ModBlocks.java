package com.mrgummy.cobweby_stone_bricks.block;

import com.mrgummy.cobweby_stone_bricks.CobwebyStoneBricks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {

	public static final Block COBWEBY_STONE_BRICKS =registerBlock("cobweby_stone_bricks",
		new CrumblyBlock(QuiltBlockSettings.copyOf(Blocks.STONE_BRICKS), Blocks.COBWEB, 20));
	public static final Block COBWEBY_DEEPSLATE_BRICKS =registerBlock("cobweby_deepslate_bricks",
		new CrumblyBlock(QuiltBlockSettings.copyOf(Blocks.DEEPSLATE_BRICKS), Blocks.COBWEB, 20));
	public static final Block COBWEBY_DEEPSLATE_TILES =registerBlock("cobweby_deepslate_tiles",
		new CrumblyBlock(QuiltBlockSettings.copyOf(Blocks.DEEPSLATE_TILES), Blocks.COBWEB, 20));
	public static final Block COBWEBY_POLISHED_BLACKSTONE_BRICKS =registerBlock("cobweby_polished_blackstone_bricks",
		new CrumblyBlock(QuiltBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICKS), Blocks.COBWEB, 20));
	public static final Block COBWEBY_NETHER_BRICKS =registerBlock("cobweby_nether_bricks",
		new CrumblyBlock(QuiltBlockSettings.copyOf(Blocks.NETHER_BRICKS), Blocks.COBWEB, 20));


	private  static Block registerBlock(String name, Block block){
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(CobwebyStoneBricks.MOD_ID, name), block);
	}

	public static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(CobwebyStoneBricks.MOD_ID, name),
			new BlockItem(block, new QuiltItemSettings()));
	}
	public static void regiterModBlock() {
		CobwebyStoneBricks.LOGGER.info("Registerin ModBlocks for " + CobwebyStoneBricks.MOD_ID);
	}

}
