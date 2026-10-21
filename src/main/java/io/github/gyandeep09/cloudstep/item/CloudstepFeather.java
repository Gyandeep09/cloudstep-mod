package io.github.gyandeep09.cloudstep.item;

import java.util.function.Consumer;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

public class CloudstepFeather extends Item {
	private static final int SECOND = 20;

	private static final int LEAP_JUMP_TICKS = 6 * SECOND;
	private static final int LEAP_JUMP_LEVEL = 2;
	private static final int LEAP_FALL_TICKS = 12 * SECOND;
	private static final int LEAP_COOLDOWN = 40 * SECOND;

	private static final int GLIDE_FALL_TICKS = 40 * SECOND;
	private static final int GLIDE_COOLDOWN = 60 * SECOND;

	public CloudstepFeather(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		if (!level.isClientSide()) {
			boolean glide = user.isShiftKeyDown();

			if (!glide) {
				user.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, LEAP_JUMP_TICKS, LEAP_JUMP_LEVEL, false, true, true));
			}

			int fallTicks = glide ? GLIDE_FALL_TICKS : LEAP_FALL_TICKS;
			user.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, fallTicks, 0, false, true, true));

			int cooldown = glide ? GLIDE_COOLDOWN : LEAP_COOLDOWN;
			user.getCooldowns().addCooldown(user.getItemInHand(hand), cooldown);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> lines, TooltipFlag flag) {
		lines.accept(Component.translatable("itemTooltip.cloudstep.cloudstep_feather.leap").withStyle(ChatFormatting.AQUA));
		lines.accept(Component.translatable("itemTooltip.cloudstep.cloudstep_feather.glide").withStyle(ChatFormatting.GRAY));
	}
}
