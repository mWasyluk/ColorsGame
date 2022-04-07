package pl.mvasio.colorsPalete;

import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;

public class PaletteHoverEffect extends Lighting {

    public PaletteHoverEffect(){
        this.setDiffuseConstant(1.0);
        this.setSpecularConstant(0.15);
        this.setSpecularExponent(60);
        this.setSurfaceScale(3.1);
        this.setBumpInput(getShadow());
    }

    private Shadow getShadow(){
        Shadow shadow = new Shadow();
        shadow.setHeight(160);
        shadow.setWidth(160);
        shadow.setRadius(21);
        return shadow;
    }

}
