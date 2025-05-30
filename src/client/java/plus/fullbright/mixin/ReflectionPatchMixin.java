package plus.fullbright.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import plus.fullbright.FullbrightMain;

import static plus.fullbright.FullbrightMain.limitPackets;
import static plus.fullbright.FullbrightMain.mc;

@Mixin(MinecraftClient.class)
public abstract class ReflectionPatchMixin {
    @Inject(at = @At("HEAD"), method = "doItemUse", cancellable = true)
    private void onDoItemUse(CallbackInfo ci) {
        ItemStack heldItem = mc.player.getMainHandStack();
        if (heldItem.isOf(Items.END_CRYSTAL))
            if (FullbrightMain.hitCount != limitPackets())
                ci.cancel();
    }
}
