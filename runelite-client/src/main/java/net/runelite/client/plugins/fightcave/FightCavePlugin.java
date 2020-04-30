/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.fightcave;

import javax.annotation.Nullable;
import javax.inject.Inject;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.fightcave.helpers.FighterType;
import net.runelite.client.ui.overlay.OverlayManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@PluginDescriptor(
		name = "Fight Cave",
		description = "Show what to pray against Jad",
		tags = {"bosses", "combat", "minigame", "overlay", "prayer", "pve", "pvm"}
)
public class FightCavePlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FightCaveOverlay overlay;

	@Inject
	private FightCaveInfoOverlay infoOverlay;

	@Getter(AccessLevel.PACKAGE)
	private JadAttack attack;

	private NPC jad;

	@Getter(AccessLevel.PACKAGE)
	private FightCaveInstance instance = null;

	@Getter(AccessLevel.PACKAGE)
	private boolean inCave = false;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(infoOverlay);
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		jad = null;
		attack = null;
		inCave = false;
		instance = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING || event.getGameState() == GameState.CONNECTION_LOST)
		{
			inCave = false;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		String message = event.getMessage();
		if (message.contains("<col=ef1020>Wave: ")) {
			message = message.split("<col=ef1020>Wave: ")[1];
			message = message.split("</col>")[0];

			try {
				int wave = Integer.parseInt(message);
				inCave = true;
				if (instance == null) {
					instance = new FightCaveInstance();
				}
				instance.setWaveNumber(wave);
			} catch (NumberFormatException e) {
				return;
			}
		}

	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final int id = event.getNpc().getId();

		if (FighterType.valueOf(id) != null) {
			if (!inCave) inCave = true;
			if (id == NpcID.TZTOKJAD || id == NpcID.TZTOKJAD_6506)
			{
				jad = event.getNpc();
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{

		if (jad == event.getNpc())
		{
			jad = null;
			attack = null;
		}
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		if (event.getActor() != jad)
		{
			return;
		}

		if (jad.getAnimation() == JadAttack.MAGIC.getAnimation())
		{
			attack = JadAttack.MAGIC;
		}
		else if (jad.getAnimation() == JadAttack.RANGE.getAnimation())
		{
			attack = JadAttack.RANGE;
		}
	}
}
