package ie.tudublin.C20391453;

import processing.core.PApplet;

public class OOP_Assignment extends PApplet {

    int mode;

    OOP_Assignment_Visuals circle1;

    public void settings() {
        size(500, 500);
    }

    public void setup() {

        colorMode(RGB);
        frameRate(60);
    }

    public void changeVisuals() {
        switch(mode) {
            case 1:
                draw();
                break;
        }

    }

    public void draw() {
        background(0);

    }
    
}
