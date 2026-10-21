package io.github.gyandeep09.cloudstep;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class CloudstepMod implements ModInitializer {
	public static final String MOD_ID = "cloudstep";

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModItems.initialize();
	}
}
