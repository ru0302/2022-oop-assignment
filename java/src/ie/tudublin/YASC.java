package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet{

    public void setup()
    {
        x = width /2;
        y = height / 2;
        w = 100;
        halfW = w / 2.0f;
    }

    public void settings()
    {
        size(500, 500);
    }

    public void draw()
    {
        background(0);
        drawPlayer(x, y, w);
    }    
}
