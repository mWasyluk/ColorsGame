package pl.mvasio.circles;

import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;

public class CircleEffect extends Lighting {

    public CircleEffect(){
        this.setBumpInput(new Shadow());
        this.setDiffuseConstant(1.3);
        this.setSpecularConstant(0.8);
        this.setSpecularExponent(20);
        this.setSurfaceScale(3.5);
    }
}
