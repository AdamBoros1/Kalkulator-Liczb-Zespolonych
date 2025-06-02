import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<LiczbaZespolona> argumenty = new ArrayList<>();
        Dzialania dzialania = new Dzialania();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe zespolona do operacji (w formacie X +- Yi) i zatwierdz enterem.\n");
        while (true) {
            String arg = scanner.nextLine();
            if (arg.equals("m")) {
                while (true){
                    System.out.print("""
                
                Wybierz opcje (numerycznie):
                 1. Dodać
                 2. Odjąć
                 3. Podzielić
                 4. Pomnożyć
                 5. Wyświetl wprowadzone liczby
                 6. Wyczyść wszystkie liczby
                 (dodatkowo)
                 7. Policzyc sprzezenie wybranej liczby zespolonej
                 8. Policzyc modul wybranej liczby zespolonej
                 q. Wyjście z programu, powrot do opcji dodawania liczb
                > """);

                    String wybor = scanner.next();
                    if (wybor.equalsIgnoreCase("q")) {
                        System.out.println("Mozesz ponownie wprowadzic liczbe zespolona");
                        break;
                    }

                    if (argumenty.isEmpty() && !"5".equals(wybor) && !"6".equals(wybor)) {
                        System.out.println("Brak liczb do wykonania działania.");
                        continue;
                    }

                    LiczbaZespolona wynik;

                    switch (wybor) {
                        case "1": // Dodawanie
                            wynik = new LiczbaZespolona(0, 0);
                            boolean przerwanoDodawanie = false;

                            for (LiczbaZespolona z : argumenty) {
                                wynik = dzialania.dodawanie(wynik, z);
                            }

                            if (!przerwanoDodawanie) {
                                System.out.println("Suma: " + wynik);
                            }
                            break;
                        case "2": // Odejmowanie
                            wynik = argumenty.get(0);
                            for (int i = 1; i < argumenty.size(); i++) {
                                wynik = dzialania.odejmowanie(wynik, argumenty.get(i));
                            }
                            System.out.println("Różnica: " + wynik);
                            break;
                        case "3": // Dzielenie
                            wynik = argumenty.get(0);
                            for (int i = 1; i < argumenty.size(); i++) {
                                try {
                                    wynik = dzialania.dzielenie(wynik, argumenty.get(i));
                                } catch (ArithmeticException e) {
                                    System.out.println("Błąd dzielenia: " + e.getMessage());
                                    break;
                                }
                            }
                            System.out.println("Iloraz: " + wynik);
                            break;
                        case "4": // Mnożenie
                            wynik = new LiczbaZespolona(1, 0);
                            for (LiczbaZespolona z : argumenty) {
                                wynik = dzialania.mnozenie(wynik, z);
                            }
                            System.out.println("Iloczyn: " + wynik);
                            break;
                        case "5": // Wyświetlenie
                            if (argumenty.isEmpty()) {
                                System.out.println("Brak zapisanych liczb.");
                            } else {
                                System.out.println("Wprowadzone liczby zespolone:");
                                for (LiczbaZespolona z : argumenty) {
                                    System.out.println("  " + z);
                                }
                            }
                            break;
                        case "6": // Czyszczenie
                            argumenty.clear();
                            System.out.println("Wyczyszczono wszystkie liczby.");
                            break;
                        case "7":
                            int i = 0;
                            System.out.println("Wybierz (numerycznie) liczbe ktorej sprzezenie chcesz policzyc:");
                            for(LiczbaZespolona z : argumenty){
                                System.out.println(i+". "+ argumenty.get(i));
                                i++;
                            }
                            int w = scanner.nextInt();
                            System.out.println("Sprzezenie liczby:"+ argumenty.get(w)+"="+ dzialania.sprzezenie(argumenty.get(w)));
                            break;
                        case "8":
                            int j = 0;
                            System.out.println("Wybierz (numerycznie) liczbe ktorej sprzezenie chcesz policzyc:");
                            for(LiczbaZespolona z : argumenty){
                                System.out.println(j+". "+ argumenty.get(j));
                                j++;
                            }
                            int x = scanner.nextInt();
                            System.out.println("Modul liczby:"+ argumenty.get(x)+"="+ dzialania.modul(argumenty.get(x)));
                            break;
                        default:
                            System.out.println("Nieprawidłowa opcja.");
                    }
                }
            }

            try {
                if(!arg.equals("m") && !arg.equals("q") && !arg.isEmpty()) {
                    LiczbaZespolona liczba = LiczbaZespolona.parse(arg);
                    argumenty.add(liczba);
                    System.out.println("Dodano (" + liczba + ") do listy argumentów.");
                    System.out.println("Podaj kolejna liczbe lub wyswietl menu wpisujac 'm'");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Błąd: " + e.getMessage());
            }
        }


    }
}