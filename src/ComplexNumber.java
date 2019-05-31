public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof ComplexNumber) {
            ComplexNumber complexNumber = (ComplexNumber) obj;
            if (this.getIm() == complexNumber.getIm() && this.getRe() == complexNumber.getRe()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        result = (int) (31 * getRe() + 31 * getIm());
        return result;
    }
}
