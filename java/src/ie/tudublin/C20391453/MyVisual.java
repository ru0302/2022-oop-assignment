package ie.tudublin.C20391453;

import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;
import processing.core.PApplet;

public class MyVisual extends PApplet {
    Minim minim;
    AudioPlayer player;
    AudioInput input;
    AudioBuffer buffer;

    int changeVisuals = 0;

    float[] lerpedBuffer;
    float Y = 0;
    float smoothY = 0;
    float smoothedAmp = 0;

    public void displayChoice() {
        if(key >= '0' && key <= '9') {
            changeVisuals = key = '0';
        }

        if(keyCode == ' ') {
            if(player.isPlaying()) {
                player.pause();
            }

            else {
                player.rewind();
                player.play();
            }
        }
    }

    public void displaySettings() {
        fullScreen(P3D, SPAN);
    }

    public void soundSetup() {
        minim = new Minim(this);
        player = minim.loadFile("The Chainsmokers - High (Official Video).mp3", 1024);
        player.play();
        buffer = player.mix;
        colorMode(HSB);

        Y = height / 2;
        smoothY = Y;

        lerpedBuffer = new float[width];

    }

    float turnOff = 0;

    public void draw() {
        float halfH = height / 2;
        float avg = 0;
        float sum = 0;
        turnOff += 1;

        for(int i = 0; i < buffer.size(); i++) {
            sum += abs(buffer.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], buffer.get(i), 0.05f);

            float cx = width / 2;
            float cy = height / 2;

            switch(changeVisuals) {
                case 0:
                    background(0);
                    for(i = 0; i < buffer.size(); i++) {
                        float c = map(i, 0, buffer.size(), 0, 255);
                        stroke(c, 255, 255);
                        float f = lerpedBuffer[i] * halfH * 4.0f;
                        line(i, halfH + f, i, halfH - f);
                    }
                    break;
            }
        }
    }
    
}
