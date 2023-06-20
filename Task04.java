
// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
//Организовать вводи и хранение данных пользователей. ФИО возраст и пол
//вывод в формате Фамилия И.О. возраст пол
//добавить возможность выхода или вывода списка отсортированного по возрасту!)
//*реализовать сортировку по возрасту с использованием индексов
//*реализовать сортировку по возрасту и полу с использованием индексов
import java.util.*;

public class Task04 {

    public static ArrayList <String> ageSort (ArrayList<String> str) {
        ArrayList<String> sorted = new ArrayList<>();
        // Age
        int [] age = new int [str.size()];
        for (int i = 0; i < str.size(); i++) {
            String[] line = str.get(i).split(" ");
            age [i] = (Integer.parseInt(line[3]));

        }
        // Sorted age
        int [] sortedAge = Arrays.stream(age).sorted().toArray();


        for (int k : sortedAge) {
            for (int j = 0; j < age.length; j++) {
                if (k == age[j]) {
                    sorted.add(str.get(j));
                }
            }
        }
        return sorted;
    }
    // Sorted by age and gender
    public static ArrayList <String> genderSort (ArrayList<String> str, String gender) {
        ArrayList<String> sorted = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).endsWith(gender)) {
                sorted.add(str.get(i));
            }
        }
        return ageSort(sorted);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList <String> list = new ArrayList<>();
        boolean enterDate = false;
        System.out.println("Введите Фамилию Имя Отчество возраст пол (муж/жен) \nНажмите ' ' (пробел) для завершения ввода данных");
        while (!enterDate) {
            String data = scnr.nextLine();
            if (data.equals(" ")) {
                enterDate = true;

            } else {
                list.add(data);
            }
        }


        System.out.println("***********************************");
        System.out.println("=======Ввод данных завершен========");
        System.out.println("***********************************");


        boolean mainMenu = false;
        while (!mainMenu) {
            System.out.print("\n\nВведите 1 для вывода списка \nВведите 2 для сортировки списка по возрасту \nВведите 3 для сортировки списка по женскому полу и возврасту \nВведите 4 для сортировки списка по мужскому полу и возрасту \nВведите 0 для выхода \nВведите 1,2,3,4 или 0: \n\n");
            int menu = scnr.nextInt();

            switch (menu) {
                case 1 -> list.forEach(System.out::println);
                case 2 -> ageSort(list).forEach(System.out::println);
                case 3 -> genderSort(list, "жен").forEach(System.out::println);
                case 4 -> genderSort(list, "муж").forEach(System.out::println);
                default -> mainMenu = true;
            }
        }

    }

}
