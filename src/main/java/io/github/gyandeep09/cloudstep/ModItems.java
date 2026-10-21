package io.github.gyandeep09.cloudstep;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import io.github.gyandeep09.cloudstep.item.CloudstepFeather;

public final class ModItems {
	public static final Item CLOUDSTEP_FEATHER = add("cloudstep_feather", CloudstepFeather::new, new Item.Properties().stacksTo(1));

	private ModItems() {
	}

	private static Item add(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, CloudstepMod.id(name));
		Item item = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
				.register(tab -> tab.accept(CLOUDSTEP_FEATHER));
	}
}
