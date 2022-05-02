package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet {

    Player p1;
    Player p2;
    // Player p3;
    PowerUp pu1;

    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public void setup() {
        p1 = new Player(100, 100, 50, this);
        p2 = new Player(200, 200, 50, this);
        // p3 = new Player(250, 250, 50, this);
        pu1 = new PowerUp(50, this);

    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        background(0);

        p1.update();
        p1.render();
        p2.update();
        p2.render();
        pu1.update();
        pu1.render();
    }
}
