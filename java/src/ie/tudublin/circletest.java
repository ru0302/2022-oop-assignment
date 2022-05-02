package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class circletest extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    FFT fft;

    float[] lerpedBuffer;
    float x = 0;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void settings() {
        size(1024, 1024, P3D);
    }

    public void setup() {
        minim = new Minim(this);
        ap = minim.loadFile("The Chainsmokers - High (Official Video).mp3");
        ap.play();
        ab = ap.mix;
        colorMode(RGB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw() {
        float halfW = width / 2;
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;

        for(int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 5.0f);

        }

        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 5.0f);

        float cx = width / 2;
        float cy = height / 2;

        for(int i = 0; i < ab.size(); i += 10) {
            float cc = map(i, 0, ab.size(), 0, 255);
            stroke(cc, 255, 255);
            float f = lerpedBuffer[i] * halfH * 2.0f;
            line(i, halfH + f, i, halfH - f);
            fill(cc);
            circle(cx, cy, i);
        }
    }
}
