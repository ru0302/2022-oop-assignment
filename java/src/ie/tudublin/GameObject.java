package ie.tudublin;

public abstract class GameObject {
    protected float x, y;
    protected float w;
    protected float halfW;
    protected float fx, fy;

    protected YASC yasc;

    protected float rotation;

    public GameObject(YASC yasc) {
        this.yasc = yasc;
    }

    public abstract void render();

    public abstract void update();
}
