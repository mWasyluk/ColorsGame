package pl.mvasio.view;

import javafx.scene.effect.Effect;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;

public abstract class CircleEffect{
    public static Effect getCircleEffect(){
        var effect = new Lighting();
        effect.setBumpInput(new Shadow());
        effect.setDiffuseConstant(1.3);
        effect.setSpecularConstant(0.8);
        effect.setSpecularExponent(20);
        effect.setSurfaceScale(3.5);
        return effect;
    }
}
