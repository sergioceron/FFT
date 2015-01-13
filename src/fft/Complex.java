/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fft;

/**
 *
 * @author sxceron
 */
public class Complex {
    private double r;
    private double i;

    public Complex( double r, double i ){
        this.r = r;
        this.i = i;
    }

    public Complex( double r ){
        this.r = r;
        this.i = 0;
    }

    public Complex( Complex c ){
        this.r = c.r;
        this.i = c.i;
    }

    public Complex( String c ){
        if( c.indexOf('i') < 0 ){
            this.r = Double.valueOf(c);
            this.i = 0;
            return;
        }
        c = c.replaceAll("i", "");
        StringBuilder sr = new StringBuilder();
        StringBuilder si = new StringBuilder();
        int sign = c.lastIndexOf('+');
        sign = sign <= 0 ? c.lastIndexOf('-') : sign;

        for( int k = 0; k < sign; k++ )
            sr.append(c.charAt(k));
        for( int k = sign; k < c.length(); k++ )
            si.append(c.charAt(k));

        this.r = Double.valueOf(sr.toString());
        this.i = Double.valueOf(si.toString());

        System.out.println(this);
    }

    public Complex suma( Complex b ){
        this.r += b.getR();
        this.i += b.getI();
        return this;
    }

    public Complex resta( Complex b ){
        this.r -= b.getR();
        this.i -= b.getI();
        return this;
    }

    public Complex conjugado(){
        i = -i;
        return this;
    }

    @Override
    public String toString(){
        String _r = String.format("%.2f", r);
        String _i = String.format("%.2f", i);
        return _r + (i<0?"":(i!=0?"+":"")) + (i!=0 ?(_i + "i") : "");
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }


}
