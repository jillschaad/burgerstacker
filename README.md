This is a demonstration of using a [Sprite](https://github.com/libgdx/libgdx/wiki/Spritebatch,-Textureregions,-and-Sprites) in libgdx. It's based on the [simple LibGDX game example](https://cssegit.monmouth.edu:2443/jchung/libgdx.wiki/wikis/extending-the-simple-game).

The [Sprite class](http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/Sprite.html) defines a game graphic object whose geometry and position (x, y) attributes can be manipulated using class methods, so it is an essential class in a game. In this version of the Drop demo, a single raindrop Sprite will be drawn at several Rectangle coordinates per frame. The way that a Sprite is drawn is different from the way that a Texture is drawn.

The applicable code is in [core->src->GameScreen.java](https://cssegit.monmouth.edu:2443/jchung/drop-sprite-demo/blob/master/core/src/com/badlogic/drop/GameScreen.java)
and is commented with `// Sprite demo`.

