import java.util.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.List;
    public class Lotto {
        public static void LottoArvonta() {
            try (Scanner s = new Scanner(System.in)) {
                ArrayList<Integer> arvaukset = new ArrayList<>();
                //Luodaan joukko, jossa uniikkeja numeroita.

                LinkedHashSet<Integer> set = new LinkedHashSet<>();

                System.out.println("Syötä seitsemän eri numeroa väliltä 1-40: ");

                while (arvaukset.size() <= 6) {

                    int i = s.nextInt();

                    if (i >= 1 && i <= 40) {
                        //Jos uniikki numero, lisätään listaan.
                        if (set.add(i)) arvaukset.add(i);
                    }
                    else {
                        System.out.println("Syötä numero väliltä 1-40!");
                    }
                    //Kun listan koko on seitsemän, tulosta lista.
                    if (arvaukset.size() == 7) {
                        System.out.println(arvaukset);
                    }
                }
                Random r = new Random();

                ArrayList<Integer> arvotut = new ArrayList<>();

                LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

                System.out.println("Arvotaan voittonumerot:");

                while (arvotut.size() <= 6) {

                    int n = r.nextInt(40) +1;

                    if (set2.add(n)) arvotut.add(n);

                    System.out.println(arvotut);
                }
                //Suoritetaan vertailumetodi.
                vertaaLuvut(arvaukset, arvotut);
            }
        }

        private static void vertaaLuvut(List<Integer> a, List<Integer> b) {
            //Tehdään kopio arvaukset- listasta.
            List<Integer> kopio = new ArrayList<>(a);
            //Pidetään kaikki täsmäävät luvut.
            kopio.retainAll(b);

            System.out.println("Oikein menivät: " + kopio);

            if (kopio.size() == 4) {
                System.out.println("Neljä oikein! Voitit 50 €!");
            }
            else if (kopio.size() == 5) {

                System.out.println("Viisi oikein! Voitit 300 €!");
            }
            else if (kopio.size() == 6) {

                System.out.println("Kuusi oikein!! Voitit 10 000 €!");
            }
            else if (kopio.size() == 7) {

                System.out.println("Kaikki seitsemän oikein!!! Voitit jättipotin, 1 000 000 €!!");
            }
            else {

                System.out.println("Harmi, ei voittoja.");
            }
        }
        public static void main(String[] args) {
            //Suoritetaan arvonta.
            LottoArvonta();
        }
    }
