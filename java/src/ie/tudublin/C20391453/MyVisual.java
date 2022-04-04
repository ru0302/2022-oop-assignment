package ie.tudublin.C20391453;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.*;

public class MyVisual extends PApplet {
    int displayWidth = 1080;
    int displayHeight = 1080;

    String trackName = "The Chainsmokers - High (Official Video).mp3";
    float fps = 60;
    float smoothingFactor = 0.25f;

    AudioPlayer track;
    FFT fft;
    Minim minim;

    int bands = 256;
    float[] spectrum = new float[bands];
    float[] sum = new float[bands];

    float unit;
    int groundLineY;
    PVector center;

    public void settings() {
        size(displayWidth, displayHeight);
        smooth(8);
    }

    public void setup() {
        frameRate(fps);
        unit = height / 100;
        strokeWeight(unit / 10.24f);
        groundLineY = height * 3/4;
        center = new PVector(width / 2, height * 3/4);

        minim = new Minim(this);
        track = minim.loadFile(trackName, 2048);

        track.loop();

        fft = new FFT(track.bufferSize(), track.sampleRate());

        fft.linAverages(bands);
    }

    int sphereRadius;

    float spherePrevX;
    float spherePrevY;

    int yOffest;

    boolean initialStatic = true;
    float[] extendingSphereLinesRadius;

    void drawStatic() {
        if(initialStatic) {
            extendingSphereLinesRadius = new float[241];

            for(int angle = 0; angle <= 240; angle +=4) {
                extendingSphereLinesRadius[angle] = map(random(1), 0, 1, sphereRadius, sphereRadius * 7);
            }

        }

        initialStatic = false;

        for(int angle = 0; angle <= 240; angle += 4) {
            float x = round(cos(radians(angle + 150)) * sphereRadius + center.x);
            float y = round(sin(radians(angle + 150)) * sphereRadius + groundLineY - yOffest);

            float xDestination = x;
            float yDestination = y;

            for(int i = sphereRadius; i <= extendingSphereLinesRadius[angle]; i++) {
                float x2 = cos(radians(angle + 150)) * i + center.x;
                float y2 = sin(radians(angle + 150)) * i + groundLineY - yOffest;

                if(y2 <= getGroundY(x2)) {
                    xDestination = x2;
                    yDestination = y2;
                }
            }

            stroke(255);

            if(y <= getGroundY(x)) {
                line(x, y, xDestination, yDestination);
            }
        }
    }

    public void drawAll(float[] sum) {
        sphereRadius = 15 * round(unit);

        spherePrevX = 0;
        spherePrevY = 0;

        yOffest = round(sin(radians(150)) * sphereRadius);

        drawStatic();

        float x = 0;
        float y = 0;
        int surrCount = 1;

        boolean direction = false;

        while(x < width * 1.5 && x > 0 - width / 2) {
            float surroundingRadius;

            float surrRadMin = sphereRadius + sphereRadius * 1/2 * surrCount;
            float surrRadMax = sphereRadius + surrRadMin * 1/8;

            float surrYOffest;

            float addon = frameCount * 1.5f;

            if(direction) {
                addon = addon * 1.5f;
            }

            for(float angle = 0; angle <= 240; angle += 1.5) {
                surroundingRadius = map(sin(radians(angle * 7 + addon)), -1, 1, surrRadMin, surrRadMax);

                surrYOffest = sin(radians(150)) * surroundingRadius;

                x = round(cos(radians(angle + 150)) * surroundingRadius + center.x);
                y = round(sin(radians(angle + 150)) * surroundingRadius + getGroundY(x) - surrYOffest);

                noStroke();
                fill(map(surroundingRadius, surrRadMin, surrRadMax, 100, 255));
                circle(x, y, 3 * unit / 10.24f);
                noFill();
            }

            direction = !direction;

            surrCount += 1;
        }

    }

}