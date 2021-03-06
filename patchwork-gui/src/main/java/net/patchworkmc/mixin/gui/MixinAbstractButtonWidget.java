/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.patchworkmc.mixin.gui;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.widget.AbstractButtonWidget;

@Mixin(AbstractButtonWidget.class)
public abstract class MixinAbstractButtonWidget extends DrawableHelper {
	@Shadow
	protected int height;

	@Shadow
	public boolean active;

	@Shadow
	public abstract boolean isHovered();

	protected int packedFGColor = 0;

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int value) {
		this.height = value;
	}

	@ModifyVariable(method = "renderButton", at = @At(value = "INVOKE_ASSIGN"), index = 7)
	public int hookRenderButton(int original) {
		return getFGColor();
	}

	public int getFGColor() {
		if (packedFGColor != 0) return packedFGColor;
		int ret = 14737632;

		if (!this.active) {
			ret = 10526880;
		} else if (this.isHovered()) {
			ret = 16777120;
		}

		return ret;
	}

	public void setFGColor(int color) {
		this.packedFGColor = color;
	}
}
