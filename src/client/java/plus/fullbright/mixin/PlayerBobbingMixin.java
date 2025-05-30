package plus.fullbright.mixin;

import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ItemStack.class})
public abstract class PlayerBobbingMixin {
    @Inject(method = {"getBobbingAnimationTime"}, at = {@At("HEAD")}, cancellable = true)
    private void stopBobbingAnimation(CallbackInfoReturnable<Integer> info) {
        info.setReturnValue(0);
    }
}
