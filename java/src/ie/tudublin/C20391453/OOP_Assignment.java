package ie.tudublin.C20391453;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class OOP_Assignment extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    FFT fft;

    int mode = 0;

    float[] lerpedBuffer;

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }

        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void settings() {
        size(1024, 1024, P3D);
        // fullScreen(P3D, SPAN);
    }

    public void setup() {
        minim = new Minim(this);

        ap = minim.loadFile("WARLORDZ (Bailo & ISOxo Remix).mp3", 1024);
        ap.play();
        ab = ap.mix;

        fft = new FFT(ap.bufferSize(), ap.sampleRate());

        colorMode(RGB);

        lerpedBuffer = new float[width];
    }

    float[] real; // stores data from real part of audio spectrum
    float[] img; // stores data from "fake" part of audio spectrum

    public void draw() {
        fft.forward(ap.mix);
        real = fft.getSpectrumReal();
        img = fft.getSpectrumImaginary();

        int xOffset = (width - fft.specSize()) / 2;
        int yOffset = (height - fft.specSize()) / 2;
        float x = width / 2;
        float y = height / 2;

        float avg = 0;
        float sum = 0;
        float smoothedAmp = 0;

        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }

        avg = sum / (float) ab.size();

        smoothedAmp = lerp(smoothedAmp, avg, 0.1f);

        switch (mode) {
            case 0:
                background(0);
                for (int i = 0; i < fft.specSize(); i++) {
                    stroke(real[i] * 25, img[i] * 25, fft.getBand(i) * 10);
                    // line(i + xOffset, height / 2, i + xOffset + real[i] * 20, height / 2 + img[i]
                    // * 20);
                    // circle(xOffset, yOffset, i + xOffset + real[i] * 5);
                    line(width / 2, height / 2, i + xOffset + real[i] * 10, i + yOffset + img[i] * 10);
                    circle(x + real[i], y + img[i], i);
                }
                break;

            case 1:
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    stroke(real[i] * 10, img[i] * 10, fft.getBand(i) * 5);
                    float f = lerpedBuffer[i] * (height / 2) * 4.0f;
                    rect(i, (height / 2) + f, i, (height / 2) - f);
                }
                break;
        }
    }
}