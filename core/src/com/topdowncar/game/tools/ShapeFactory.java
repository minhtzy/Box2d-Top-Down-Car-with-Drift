package com.topdowncar.game.tools;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


import static com.topdowncar.game.Constants.PPM;

public class ShapeFactory {
    private ShapeFactory() {}

    public static Body createRectangle (final Vector2 position, final Vector2 size, final BodyDef.BodyType type, final World world, final float density){
        final BodyDef bDef = new BodyDef();
        bDef.position.set(position.x / PPM, position.y / PPM);
        bDef.type = type;
        final Body body = world.createBody(bDef);
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x / PPM, size.y / PPM);
        final FixtureDef fDef = new FixtureDef();
        fDef.shape = shape;
        fDef.density = density;
        body.createFixture(fDef);
        shape.dispose();
        return body;
    }
}
