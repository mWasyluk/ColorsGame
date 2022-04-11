package pl.mvasio.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.List;

public class Palette extends Pane{

    private final ColorPaletteArc[] paletteArcs;
    private double paletteRadius;
    private final List<Color> colors;

    public Palette(double paletteRadius, List<Color> colors) {
        super();
        this.paletteRadius = paletteRadius;
        this.colors = colors;
        this.paletteArcs = createArcs();
        this.getChildren().addAll(paletteArcs);

    }
    public Palette(double paletteRadius, List<Color> colors, double layX, double layY) {
        super();
        this.paletteRadius = paletteRadius;
        this.colors = colors;
        this.paletteArcs = createArcs();
        this.setPaletteLayout(layX, layY);
        this.getChildren().addAll(this.paletteArcs);
    }

    private ColorPaletteArc[] createArcs(){
        int quantity = this.colors.size();
        ColorPaletteArc[] arcs = new ColorPaletteArc[ quantity ];

        for (int i = 0; i < quantity; i ++){
            arcs[i] = new ColorPaletteArc(colors.get(i), 360.0 / quantity, 90.0 + (360.0 / quantity) * i, this.paletteRadius);
        }
        return arcs;
    }

    public void setEventHandler (EventHandler <MouseEvent> e){
        for ( ColorPaletteArc arc: paletteArcs){
            arc.setOnMouseClicked(e);
        }
    }

    public void setPaletteLayout(double x, double y){
        for (ColorPaletteArc a: paletteArcs){
            a.setLayoutX(x);
            a.setLayoutY(y);
        }
    }

    public ColorPaletteArc[] getPaletteArcs() {
        return paletteArcs;
    }

    public void setPaletteRadius(double paletteRadius) {
        this.paletteRadius = paletteRadius;
    }
}
