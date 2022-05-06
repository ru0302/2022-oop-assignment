package ie.tudublin;

import javax.swing.JFrame;

import ie.tudublin.C20391453.OOP_Assignment;

public class Main
{
    public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

    public static void starMap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new StarMap());
    }

    public static void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

    public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

    public static void arrays()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Arrays());
    }

    public static void life()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Life());
    }


    public static void audio1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
    }

    public static void audio2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio2());
    }

    public static void colorfulLife()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new ColorfulLife());
    }

    public static void YASC()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new YASC());
    }

    public void cat()
    {
        System.out.println("Hello world");

        Animal misty = new Animal("Misty");
        Animal lucy = new Animal("Lucy");

        lucy = misty;
        misty.setName("Tara");

        System.out.println(misty);
        System.out.println(lucy);


        Cat cat = new Cat("Ginger");

        while(cat.getNumLives() > 0)
        {
            cat.kill();
        }
        cat.kill();

    }

    public static void OOP_Assignment()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new OOP_Assignment());
    }

    public static void circletest()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new circletest());
    }

    // public void pitch()
    // {
    //     PitchSpeller ps = new PitchSpeller();
    //     System.out.println(ps.spell(330));
    //     System.out.println(ps.spell(420));
    //     System.out.println(ps.spell(1980));
    // }

    public static void main(String[] args)
    {
        // YASC();
        // circletest();
        // colorfulLife();
        OOP_Assignment();

        // audio1();
        // audio2();

        // JFrame window = new JFrame();
        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // window.setBounds(30, 30, 200, 200);
        // window.getContentPane().add(window, new StarMap());
        // window.setVisible(true);

        // Tara Misty
        // Tara Tara

    }
}