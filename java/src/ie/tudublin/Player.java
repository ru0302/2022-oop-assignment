package ie.tudublin;

public class Player {

    float x, y;
    float w;
    float halfW;

    YASC yasc;

    void drawPlayer(float x, float y, float w)
    {
        yasc.stroke(255);
        yasc.line(x - halfW, y + halfW, x, y - halfW);
        yasc.line(x, y - halfW, x + halfW, y + halfW);
        yasc.line(x + halfW, y + halfW, x, y);
        yasc.line(x, y, x - halfW, y + halfW);
    }

}
