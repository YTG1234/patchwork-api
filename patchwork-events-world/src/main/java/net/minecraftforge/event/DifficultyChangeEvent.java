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

package net.minecraftforge.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.Difficulty;

/**
 * DifficultyChangeEvent is fired when difficulty is changing.
 *
 * <p>TODO: Forge bug: This event is not currently fired.
 * See <a href="https://github.com/MinecraftForge/MinecraftForge/issues/6227">this bug</a> (closed by stalebot).</p>
 *
 * <p>This event is not cancellable.</p>
 *
 * <p>This event does not have a result.</p>
 *
 * <p>This event is fired on the {@link MinecraftForge#EVENT_BUS}.</p>
 */
public class DifficultyChangeEvent extends Event {
	private final Difficulty difficulty;
	private final Difficulty oldDifficulty;

	public DifficultyChangeEvent(Difficulty difficulty, Difficulty oldDifficulty) {
		this.difficulty = difficulty;
		this.oldDifficulty = oldDifficulty;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public Difficulty getOldDifficulty() {
		return oldDifficulty;
	}
}
