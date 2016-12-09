package qa.util;

import java.util.Date;

public class Random {
    private static int shortRandAdd = 0;
    private static int longRandAdd = 0;

    public static int genInt(int from, int to) {
        int tmp = 0;
        if (to >= from)
            tmp = (int) (from + Math.round((Math.random() * (to - from))));
        return tmp;
    }

    public static float genFloat(double from, double to) {
        float tmp = .0f;
        if (to >= from)
            tmp = (float) (from + (Math.random() * (to - from)));
        return tmp;
    }

    public static float genFloat(double from, double to, int precision) {
        float number = genFloat(from, to);
        return (float) Math.round(number * Math.pow(10, precision)) / (float) Math.pow(10, precision);
    }

    public static synchronized long genRandNumber() {
        return System.currentTimeMillis() % 10_000_000_000L + longRandAdd++;
    }

    public static synchronized long genShortRandNumber() {
        return (genInt(1, 9) * 10_000_000) + (System.currentTimeMillis() % 10_000_000) + shortRandAdd++;
    }

    public static String genStreet() {
        return genRandNumber() + " Main str.";
    }

    public static String genPhone() {
        return "555" + genInt(1000000, 9999999);
    }

    public static String genEmail() {
        return "mail" + new Date().getTime() + "@mail.com";
    }

    public static String genEmail(String emailPattern) {
        return emailPattern.substring(0, emailPattern.indexOf("@")) + "+" + genShortRandNumber()
                + emailPattern.substring(emailPattern.indexOf("@"), emailPattern.length());
    }


    public static String genName() {
        //String[] names = {"Asish", "test", "user", "Mandy", "Pap", "Ronny", "Catarine"};
        String[] names = {  "Angelo", "John", "Malcolm", "Fernando", "Christopher", "Kevin", "Katharina",
                            "Galadriel", "Robert", "Alan", "Steven", "Maory"};
        //int rand = genInt(0, 6);
        return names[genInt(0, names.length - 1)];
    }

    public static String genLastName() {
        String[] names = {  "King", "Johnstone", "Tester", "Adrony", "Arya", "Minkel", "Robertson", "Pacino",
                            "McDowell", "Rickman", "Taylor", "Gunnarsson", "Gutmundsdottir", "Alessio",
                            "Newell", "O'Reilly", "Seaman"};
        //int rand = genInt(0, 6);
        return names[genInt(0, names.length - 1)];
    }

    public static String genString(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s = s + Character.toString((char) Random.genInt(97, 120));
        }
        return s;
    }

    public static String genAddress() {
        return new Date().getTime() + "Main St.";
    }

    public static String genPostalCode() {
        return "" + Random.genInt(1, 9) + Random.genInt(10, 99) + Random.genInt(10, 99);
    }

    public static String genCity() {
        //return "New test " + Random.genString(4) + "ville";
        int bigACharCode = 65;
        int bigZCharCode = 90;

        return (char) genInt(bigACharCode, bigZCharCode) + Random.genString(4) + "ville";
    }

    public static String genState() {
        int bigACharCode = 65;
        int bigZCharCode = 90;

        return (char) genInt(bigACharCode, bigZCharCode) + Random.genString(4) + "land";
    }

    public static String genCountry() {
//        String[] names = { "New Zealand", /*"United States",*/ "Malaysia", "Cuba", "Poland", "Italy",
//                "Sweden", "Norway", "Netherlands", "Chile", "France", "Germany",
//                "Spain", "Portugal", "China" };
        //int rand = genInt(0, 6);

        String[] names = {  "Poland", "Sweden", "Norway", "France", "Spain", "Portugal", "Finland", "Turkey",
                            "Iceland", "Ireland", "Belgium" , "Bulgaria", "Croatia", "Czech Republic",
                            "Greenland", "Hungary", "Macedonia", "Netherlands", "Romania", "San Marino", "Slovenia",
                            "Switzerland", "Ukraine", "United Kingdom", "Australia", "Israel", "Qatar", "Saudi Arabia", "China",
                            "Japan", "Argentina", "Brazil", "Chile" , "Peru" };

        return names[genInt(0, names.length - 1)];
    }

    public static String genMobilePhone() {
        return "555" + genInt(1000000, 9999999);
    }

    public static String genGender() {
        String[] gender = {"man", "woman"};
        int randInt = genInt(0, 1);
        return gender[randInt];
    }
}