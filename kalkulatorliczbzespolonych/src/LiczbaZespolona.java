public class LiczbaZespolona {
    public double re;
    public double im;
    public LiczbaZespolona(double re, double im){
        this.re=re;
        this.im=im;
    }
    @Override
    public String toString(){
        if(im>0) return this.re+"+"+this.im+"i";
        else return this.re+""+this.im+"i";
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    public static LiczbaZespolona parse(String input) {
        input = input.replaceAll(" ", "").replaceAll("−", "-");
        //System.out.print("Input to:" +input);
        if (input.matches("^[+-]?\\d+(\\.\\d+)?$")) {
            return new LiczbaZespolona(Double.parseDouble(input), 0);
        }
        if (input.matches("^[+-]?(\\d+(\\.\\d+)?)*i$")) {
            String imStr = input.replace("i", "");
            if (imStr.equals("") || imStr.equals("+")) imStr = "1";
            if (imStr.equals("-")) imStr = "-1";
            return new LiczbaZespolona(0, Double.parseDouble(imStr));
        }
        if (input.matches("^[+-]?\\d+(\\.\\d+)?[+-]\\d+(\\.\\d+)?i$")) {
            int znak = Math.max(input.lastIndexOf('+'), input.lastIndexOf('-'));
            String re = input.substring(0, znak);
            String im = input.substring(znak, input.length() - 1);
            return new LiczbaZespolona(Double.parseDouble(re), Double.parseDouble(im));
        }

        throw new IllegalArgumentException("Nieprawidłowy format liczby zespolonej: " + input);
    }
}

