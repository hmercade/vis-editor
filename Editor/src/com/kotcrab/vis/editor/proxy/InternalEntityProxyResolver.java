/*
 * Copyright 2014-2015 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kotcrab.vis.editor.proxy;

import com.artemis.Entity;
import com.kotcrab.vis.runtime.component.MusicComponent;
import com.kotcrab.vis.runtime.component.ParticleComponent;
import com.kotcrab.vis.runtime.component.SoundComponent;
import com.kotcrab.vis.runtime.component.SpriteComponent;

/** @author Kotcrab */
public class InternalEntityProxyResolver {
	public static EntityProxy getFor (Entity entity) {
		if (entity.getComponent(SpriteComponent.class) != null) return new SpriteProxy(entity);
		if (entity.getComponent(SoundComponent.class) != null) return new SoundAndMusicProxy(entity, false);
		if (entity.getComponent(MusicComponent.class) != null) return new SoundAndMusicProxy(entity, true);
		if (entity.getComponent(ParticleComponent.class) != null) return new ParticleProxy(entity);

		return null;
	}
}
