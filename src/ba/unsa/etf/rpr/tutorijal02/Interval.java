package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {
    private double prva;
    private double druga;
    private boolean prvaUnutar;
    private boolean drugaUnutar;

    public Interval () {
        prva=0;
        druga=0;
        prvaUnutar =false;
        drugaUnutar =false;

    }
    public Interval(double pocetna, double krajnja, boolean jeste, boolean nije) {
        prva = pocetna;
        druga = krajnja;
        prvaUnutar = jeste;
        drugaUnutar = nije;

        if (prva>druga) throw new IllegalArgumentException("Greska");
    }

    public boolean isNull() {
        if (prva==0 && druga==0 && prvaUnutar==false && drugaUnutar==false) return true;
        else return false;
    }

    public boolean isIn (double tacka) {
        if ((tacka>prva && tacka<druga) || (tacka==prva && prvaUnutar==true) ||
                (tacka==druga && drugaUnutar==true)) return true;
        else return false;
    }

    public Interval intersect(Interval i) {
        Interval interval = new Interval();
        if (i.prva>this.prva) {
            interval.prva=i.prva;
            interval.prvaUnutar=i.prvaUnutar;
        }
        else {
            interval.prva=this.prva;
            interval.prvaUnutar=this.prvaUnutar;
        }
        if (i.druga<this.druga) {
            interval.druga=i.druga;
            interval.drugaUnutar=i.drugaUnutar;
        }
        else {
            interval.druga=this.druga;
            interval.drugaUnutar=this.drugaUnutar;
        }
        return interval;
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval interval = new Interval();
        if (i1.prva>i2.prva) {
            interval.prva=i1.prva;
            interval.prvaUnutar=i1.prvaUnutar;
        }
        else {
            interval.prva=i2.prva;
            interval.prvaUnutar=i2.prvaUnutar;
        }
        if (i1.druga<i2.druga) {
            interval.druga=i1.druga;
            interval.drugaUnutar=i1.drugaUnutar;
        }
        else {
            interval.druga=i2.druga;
            interval.drugaUnutar=i2.drugaUnutar;
        }
        return interval;
    }

    @Override
    public String toString() {
        String zagrada1, zagrada2;
        if (this.prvaUnutar == true) zagrada1="[";
        else zagrada1="(";
        if (this.drugaUnutar == true) zagrada2="]";
        else zagrada2=")";
        if (this.isNull()==false)
            return zagrada1 + this.prva + "," + this.druga + zagrada2;
        else return zagrada1+zagrada2;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.prva, prva) == 0 &&
                Double.compare(interval.druga, druga) == 0 &&
                prvaUnutar == interval.prvaUnutar &&
                drugaUnutar == interval.drugaUnutar;
    }
}
