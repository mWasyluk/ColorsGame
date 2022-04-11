package pl.mvasio.view;

import javafx.scene.effect.Effect;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;

public abstract class PaletteEffect{
    public static Effect getDefaultEffect(){
        var effect = new Lighting();
        effect.setDiffuseConstant(1.3);
        effect.setSpecularConstant(0.65);
        effect.setSpecularExponent(40);
        effect.setSurfaceScale(6.1);
        effect.setBumpInput(getDefaultShadow());
        return effect;
    }

    private static Shadow getDefaultShadow(){
        Shadow shadow = new Shadow();
        shadow.setHeight(27);
        shadow.setRadius(21);
        shadow.setWidth(59);
        return shadow;
    }

    public static Effect getHoverEffect(){
        var effect = new Lighting();
        effect.setDiffuseConstant(1.0);
        effect.setSpecularConstant(0.15);
        effect.setSpecularExponent(60);
        effect.setSurfaceScale(3.1);
        effect.setBumpInput(getHoverShadow());
        return effect;
    }

    private static Shadow getHoverShadow(){
        Shadow shadow = new Shadow();
        shadow.setHeight(160);
        shadow.setWidth(160);
        shadow.setRadius(21);
        return shadow;
    }
}
