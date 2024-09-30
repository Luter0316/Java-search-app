// В файле data_person_year.csv содержится информация о человеке или персоне года (до 2016 включительно), о каждом в отдельной строке.
// Формат строки следующий:
// год, номинация, имя, страна, год рождения, год смерти, звание, категория, комментарий. Некоторые данные могут отсутствовать.
// Создайте класс для хранения данных только о людях, объявленных человеком года.
// Выведете на консоль и в текстовый файл список людей года для каждой страны отдельно с именем и званием.
// По выбору пользователем года или человека выведете полную информацию о человеке года (если в соответствующем году был выбран именно человек).
// Выведите на консоль список людей года, отсортированный по убыванию возраста на момент получения титула человека года.
// Дополнительно:
// Создайте классы для хранения всей информации, возможно иерархию наследования.
// Создайте класс для хранения информации о людях или персонах года для категории.
// В классе храните название категории и списки людей и персон.
// По данным из файла создайте список категорий.
// Выведете на консоль список категорий, упорядоченный по убыванию общего количества людей и персон года, с указанием стран, к которым они относятся.
// Для каждой категории выведите в отдельный файл общий список людей и персон года, упорядоченный по году присвоения


package Example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("C:\\Users\\perfe\\OneDrive\\ЯрГУ\\Информационные системы и технологии 2к1с\\Individual work on the basics of OOP for developing classes and working with objects Forum\\src\\Example\\data_person_year.csv"));
        ArrayList<String[]> RawData = new ArrayList<>();
        ArrayList<String> CheckCountry = new ArrayList<>();
        String[] rawdata = new String[2];
        int count_man_of_the_year = 0, count_country = 0;

        while (scan.hasNext()) {
            rawdata = scan.nextLine().split(",");
            RawData.add(rawdata);
            if (rawdata[1].equals("Man of the Year") | rawdata[1].equals("Men of the Year") | rawdata[1].equals("Woman of the Year") | rawdata[1].equals("Man and Wife of the Year") | rawdata[1].equals("Person of the Year") | rawdata[1].equals("Persons of the Year")) {
                count_man_of_the_year++;
                if (CheckCountry.contains(rawdata[3])) {
                } else {
                    CheckCountry.add(rawdata[3]);
                    count_country++;
                }
            }
        }

    // Создайте класс для хранения данных только о людях, объявленных человеком года

            ManOfTheYear[] arraymanoftheyears = new ManOfTheYear[count_man_of_the_year];
            int i = 0;

            for (String[] peoples : RawData) {
                if (peoples[1].equals("Man of the Year") | peoples[1].equals("Men of the Year") | peoples[1].equals("Woman of the Year") | peoples[1].equals("Man and Wife of the Year") | peoples[1].equals("Person of the Year") | peoples[1].equals("Persons of the Year")) {
                    try {
                        arraymanoftheyears[i] = new ManOfTheYear(peoples[0], peoples[1], peoples[2], peoples[3], peoples[4], peoples[5], peoples[6], peoples[7], peoples[8]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        arraymanoftheyears[i] = new ManOfTheYear(peoples[0], peoples[1], peoples[2], peoples[3], peoples[4], peoples[5], peoples[6], peoples[7], "unknown");
                    }
                    i ++;
                }
            }

    // Выведете на консоль и в текстовый файл список людей года для каждой страны отдельно с именем и званием.

        FileWriter writer = new FileWriter("C:\\Users\\perfe\\OneDrive\\ЯрГУ\\Информационные системы и технологии 2к1с\\Individual work on the basics of OOP for developing classes and working with objects Forum\\src\\Example\\List of people of the year for each country separately with name and title.txt", false);

        for(int j = 0; j < count_country; j++){
            if(CheckCountry.get(j).equals("")){
            }else {
                System.out.print("Residents of the " + CheckCountry.get(j) + ":" + "\n");
                writer.write("Residents of the " + CheckCountry.get(j) + ":" + "\n");
                for (int k = 0; k < count_man_of_the_year; k++) {
                        if (arraymanoftheyears[k].getCountry().equals(CheckCountry.get(j))) {
                            System.out.print("Citizen: " + arraymanoftheyears[k].getName() + ", with the title - " + arraymanoftheyears[k].getTitle() + "\n");
                            writer.write("Citizen: " + arraymanoftheyears[k].getName() + ", with the title - " + arraymanoftheyears[k].getTitle() + "\n");
                        }
                }
                System.out.println("\n");
                writer.write("\n");
            }
        }
        writer.flush();

    // По выбору пользователем года или человека выведете полную информацию о человеке года (если в соответствующем году был выбран именно человек).

        System.out.println("Enter name or year: ");
        Scanner sc = new Scanner(System.in);
        String userData = sc.nextLine();
        int flag = 0;

        try {
            Integer.parseInt(userData);
            for(int l = 0; l < count_man_of_the_year; l++){
                if (arraymanoftheyears[l].getYear_of_nomination().equals(userData)){
                    System.out.println("Person " + arraymanoftheyears[l].getName() + ", years of life (" + arraymanoftheyears[l].getYear_of_birth() + " - " + arraymanoftheyears[l].getYear_of_dead() + "), was awarded the title " + arraymanoftheyears[l].getNomination() + " (category - " + arraymanoftheyears[l].getCategory() + ") at " + arraymanoftheyears[l].getCountry() + " in " + arraymanoftheyears[l].getYear_of_nomination() + " being " + arraymanoftheyears[l].getTitle() + ". Notes: " + arraymanoftheyears[l].getComment());
                    flag = 1;
                }
            }
        } catch (NumberFormatException e) {
            for (int l = 0; l < count_man_of_the_year; l++) {
                if (arraymanoftheyears[l].getName().equals(userData)) {
                    System.out.println("Person " + arraymanoftheyears[l].getName() + ", years of life (" + arraymanoftheyears[l].getYear_of_birth() + " - " + arraymanoftheyears[l].getYear_of_dead() + "), was awarded the title " + arraymanoftheyears[l].getNomination() + " (category - " + arraymanoftheyears[l].getCategory() + ") at " + arraymanoftheyears[l].getCountry() + " in " + arraymanoftheyears[l].getYear_of_nomination() + " being " + arraymanoftheyears[l].getTitle() + ". Notes: " + arraymanoftheyears[l].getComment());
                    flag = 1;
                }
            }
        }
        if (flag == 0){
            System.out.println("There is no data about the person of the year");
        }System.out.println("");

    // Выведите на консоль список людей года, отсортированный по убыванию возраста на момент получения титула человека года.

        System.out.println("List of people of the year, sorted in descending order of age at the time of receiving the title of person of the year:\n");
        Arrays.sort(arraymanoftheyears, ManOfTheYear.AgeComparator);

        for (int h = 0; h < count_man_of_the_year; h++){
            if (arraymanoftheyears[h].getNominated_age() != 0) {
                System.out.println(arraymanoftheyears[h]);
            }
        }
    }
}
