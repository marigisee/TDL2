package practica5B.math;

public final class NumeroComplejo  {
    private double re;
    private double im;

    public NumeroComplejo(double re, double im){
        this.re = re;
        this.im = im;
    }

    public double realPart(){
        return re;
    }

    public double imaginaryPart(){
        return im;
    }

    public NumeroComplejo add (NumeroComplejo c) {
        NumeroComplejo res = new NumeroComplejo(0,0);
        res.re = this.re + c.re;
        res.im = this.im + c.im;
        return res;
    }

    public NumeroComplejo substract (NumeroComplejo c) {
        NumeroComplejo res = new NumeroComplejo(0,0);
        res.re = this.re - c.re;
        res.im = this.im - c.im;
        return res;
    }

    public NumeroComplejo multiply (NumeroComplejo c) {
        // Teniendo en cuenta la siguiente formula: (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
        NumeroComplejo res = new NumeroComplejo(0,0);
        res.re = (this.re * c.re) - (this.im * c.im);
        res.im = (this.re * c.im) + (this.im * c.re);
        return res;
    }

    public NumeroComplejo divide (NumeroComplejo c) {
        // Teniendo en cuenta la siguiente formula: (a + bi) / (c + di) = [(ac + bd) / (c^2 + d^2)] + [(bc - ad) / (c^2 + d^2)] * i
        NumeroComplejo res = new NumeroComplejo(0,0);
        res.re = ((this.re * c.re) + (this.im * c.im)) / ((c.re * c.re) + (c.im * c.im));
        res.im = ((this.im * c.re) - (this.re * c.im)) / ((c.re * c.re) + (c.im * c.im));
        return res;
    }
    @Override
    public boolean equals(Object o){
      if (o instanceof NumeroComplejo ) {
          if ((((NumeroComplejo) o).re == this.re) & (((NumeroComplejo) o).im == this.im)) {
              return true;
          } else {
              return false;
          }
      }
      else
          return false;
    }

    public int hashCode(){
        return (int) (this.re + this.im);
    }

    @Override
    public String toString(){
        return this.re + " + " + this.im + "i";
    }

    public NumeroComplejo valueOf(double re, double im){
        NumeroComplejo c = new NumeroComplejo(re,im);
        return c;
    }

}
