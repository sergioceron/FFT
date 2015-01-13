/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fft;

/**
 *
 * @author sxceron
 */
public class FFT {
	private static final double PIX2 = 2.0 * Math.PI;

	private static final int MAXIMO = 15;
	private static final int MAXTAMANO = 1 << MAXIMO;

	public FFT(int bits) {

		this.bits = bits;

		if (bits > MAXIMO) {
			System.out.println("" + bits + " son demasiados");
			System.exit(1);
		}
		for (int i = (1 << bits) - 1; i >= 0; --i) {
			int k = 0;
			for (int j = 0; j < bits; ++j) {
				k *= 2;
				if ((i & (1 << j)) != 0)
					k++;
			}
			bitinverso[i] = k;
		}
        fases = new Complex[bits][(int)Math.pow(2, bits)];
	}

	public void hacerFFT(Complex [] x, boolean invFlag) {
		int n, n2, i, k, kn2, l, p;
		double ang, s, c, tr, ti;

		n2 = (n = (1 << bits)) / 2;

		for (l = 0; l < bits; ++l) {
			for (k = 0; k < n; k += n2) {
				for (i = 0; i < n2; ++i, ++k) {
					p = bitinverso[k / n2];
					ang = PIX2 * p / n;
					c = Math.cos(ang);
					s = Math.sin(ang);
					kn2 = k + n2;

					if (invFlag)
						s = -s;

					tr = x[kn2].getR() * c + x[kn2].getI() * s;
					ti = x[kn2].getI() * c - x[kn2].getR() * s;

					x[kn2].setR( x[k].getR() - tr );
					x[kn2].setI( x[k].getI() - ti );
					x[k].setR( x[k].getR() + tr);
					x[k].setI( x[k].getI() + ti);
				}
			}
			n2 /= 2; // Fin de cada fase
            for( int m = 0; m < n; m++ )
                fases[l][m] = new Complex(x[m]);
		}

		for (k = 0; k < n; k++) {
			if ((i = bitinverso[k]) <= k)
				continue;

			tr = x[k].getR();
			ti = x[k].getI();
			x[k].setR( x[i].getR() );
			x[k].setI( x[i].getI() );
			x[i].setR( tr );
			x[i].setI( ti );
		}

		if (!invFlag) {
			double f = 1.0 / n;

			for (i = 0; i < n ; i++) {
				x[i].setR( x[i].getR() * f );
				x[i].setI( x[i].getI() * f );
			}
		}
	}

	private int bits;
	private int [] bitinverso = new int[MAXTAMANO];
    private Complex [][] fases;

    public int[] getBitInverso(){
        return bitinverso;
    }

    public Complex[][] getFases(){
        return fases;
    }
}
