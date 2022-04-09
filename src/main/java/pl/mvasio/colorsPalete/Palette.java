package pl.mvasio.colorsPalete;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Arrays;

public class Palette extends Pane{

    private final MyArc[] palette;
    private double radius;
    private Color[] colors;

    public Palette(double radius, Color[] colors) {
        super();
        this.radius = radius;
        this.colors = colors;
        this.palette = createArcs();
        this.setLayout(100, 100);
        this.getChildren().addAll(palette);

    }
    public Palette(double radius, Color[] colors, double layX, double layY) {
        super();
        this.radius = radius;
        this.colors = colors;
        this.palette = createArcs();
        this.setLayout(layX, layY);
        this.getChildren().addAll(palette);
    }

    private MyArc[] createArcs(){
        int quantity = colors.length;
        MyArc [] arcs = new MyArc[ quantity ];

        for (int i = 0; i < quantity; i ++){
            arcs[i] = new MyArc(colors[i], 360.0 / quantity, 90.0 + (360.0 / quantity) * i, radius);
        }
        return arcs;
    }

    public void setEventHandler (EventHandler <MouseEvent> e){
        for ( MyArc arc: palette){
            arc.setOnMouseClicked(e);
        }
    }

    public void setLayout (double x, double y){
        for (MyArc a: palette){
            a.setLayoutX(x);
            a.setLayoutY(y);
        }
    }

    public MyArc[] getPalette() {
        return palette;
    }

    public void setColors(Color... colors){
        this.colors = Arrays.copyOf(colors, colors.length);
    }

    public Color[] getColors() {
        return Arrays.copyOf(colors, colors.length);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Palette[size=" + this.colors.length +
                ",radius=" + this.radius + "]";
    }
}
