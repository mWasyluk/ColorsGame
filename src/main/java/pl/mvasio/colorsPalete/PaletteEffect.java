package pl.mvasio.colorsPalete;

import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;

public class PaletteEffect extends Lighting {

    public PaletteEffect(){
        this.setDiffuseConstant(1.3);
        this.setSpecularConstant(0.65);
        this.setSpecularExponent(40);
        this.setSurfaceScale(6.1);
        this.setBumpInput(getShadow());
    }

    private Shadow getShadow(){
        Shadow shadow = new Shadow();
        shadow.setHeight(27);
        shadow.setRadius(21);
        shadow.setWidth(59);
        return shadow;
    }
}
