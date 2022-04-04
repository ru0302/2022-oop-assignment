package ie.tudublin;

public class PowerUp {
    float x, y;
    float w;
    float halfW;
    float fx, fy;

    YASC yasc;

    float rotation;

    public PowerUp(float w, YASC yasc) {
        this.x = -50;
        this.y = yasc.random(yasc.height);
        this.w = w;
        this.fx = 1;
        this.fy = yasc.random(-5, 5);
        halfW = w / 2.0f;
        this.yasc = yasc;
        this.rotation = 0;
    }

    public void render() {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.stroke(255);
        yasc.noFill();
        yasc.rectMode(YASC.CENTER);
        yasc.rect(0, 0, w, w);
        yasc.popMatrix();
    }

    public void update()
    {
        x += fx;
        y += fy;
        rotation += 0.05f;

    }
    
}
