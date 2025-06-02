public class Dzialania implements Operacje {

    @Override
    public LiczbaZespolona dodawanie(LiczbaZespolona a, LiczbaZespolona b) {
        return new LiczbaZespolona(a.getRe()+b.getRe(),a.getIm()+b.getIm() );
    }

    @Override
    public LiczbaZespolona odejmowanie(LiczbaZespolona a, LiczbaZespolona b) {
        return new LiczbaZespolona(a.getRe()-b.getRe(),a.getIm()-b.getIm() );
    }

    @Override
    public LiczbaZespolona mnozenie(LiczbaZespolona a, LiczbaZespolona b) {
        return new LiczbaZespolona(a.getRe()*b.getRe()-a.getIm()*b.getIm(),a.getIm()*b.getRe()+a.getRe()*b.getIm() );
    }

    @Override
    public LiczbaZespolona dzielenie(LiczbaZespolona a, LiczbaZespolona b) {
        double mianownik = b.getRe() * b.getRe() + b.getIm() * b.getIm();

        double re = (a.getRe() * b.getRe() + a.getIm() * b.getIm()) / mianownik;
        double im = (a.getIm() * b.getRe() - a.getRe() * b.getIm()) / mianownik;

        return new LiczbaZespolona(re, im);
    }

    @Override
    public LiczbaZespolona sprzezenie(LiczbaZespolona a) {
        return new LiczbaZespolona(a.getRe(), a.getIm()*(-1));
    }

    @Override
    public double modul(LiczbaZespolona a) {
        return Math.sqrt(Math.pow(a.getRe(),2)+Math.pow(a.getIm(),2));
    }
}
