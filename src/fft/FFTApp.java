/*
 * FFTApp.java
 */

package fft;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class FFTApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new FFTView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of FFTApp
     */
    public static FFTApp getApplication() {
        return Application.getInstance(FFTApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        //launch(FFTApp.class, args);
        Complex c[] = new Complex[8];
        c[0] = new Complex(1);
        c[1] = new Complex(2);
        c[2] = new Complex(3);
        c[3] = new Complex(4);

        FFT a = new FFT(2);
        a.hacerFFT(c, true);
        for( Complex x : c )
            System.out.println(x);
    }
}
