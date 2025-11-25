import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<String> passengerNames = List.of(
            "Василий Петров",
            "Анна Ягирская",
            "Виктория Сотова",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    private Map<String, Integer> orders = new HashMap<>();

    public static void main(String[] args) {
        first();
        second();
        third();
        fourth();
    }

    // Начинаем принимать заказы! 🍕
    private void openPizzeria() {
        newOrder("Леонардо");
        newOrder("Донателло");
        newOrder("Рафаэль");
        newOrder("Леонардо");
        newOrder("Микеланджело");
        newOrder("Шреддер");
        newOrder("Донателло");
    }

    private void newOrder(String clientName) {
        // Сохраните новый заказ в хеш-таблицу. При обновлении счётчика заказов
        // не забудьте учесть заказы, которые уже были сделаны ранее.

        if (orders.containsKey(clientName)){
            int value = orders.getOrDefault(clientName, 0);
            orders.put(clientName, ++value);
        }
        else{
            orders.put(clientName,1);
        }
    }

    private void printStatistics() {
        // Выведите собранную статистику в консоль и посчитайте общее количество заказов.
        //
        // Формат для вывода данных в консоль:
        //     Заказов от Микеланджело: 15
        //     Заказов от Леонардо: 4
        //     Всего заказов: 19
        var values = orders.entrySet();
        int sum = 0;
        for (var item : values){
            System.out.println("Заказов от " + item.getKey() + ": " + item.getValue());
            sum += item.getValue();
        }
        System.out.println("Всего заказов: " + sum);
    }

    public static Map<String, Integer> assignSeats(List<String> passengerNames) {
        int seat = 0;
        Map<String, Integer> seats = new HashMap<>();
        for (var item : passengerNames){
            seats.put(item,++seat);
        }
        return seats;
    }

    public static void first(){
        // хеш-таблица содержит информацию о количестве жителей в разных городах
        Map<String, Integer> citiesPopulation = new HashMap<>();
        citiesPopulation.put("Москва", 12_655_050);
        citiesPopulation.put("Лондон", 8_961_989);
        citiesPopulation.put("Нью-Йорк", 8_804_190);

        // попытаемся узнать, каким будет население Парижа через год
        String city = "Париж";
        Integer cityPopulation = citiesPopulation.get(city);
        System.out.println(citiesPopulation.containsKey(city)? "Через 1 год население города " + city + " будет: " + (int)(cityPopulation * 1.01) : "Такого города нет в Map");

    }

    public static void second(){
        // ключ — название задачи, значение — выполнена эта задача или ещё нет
        Map<String, Boolean> todos = new HashMap<>();

        todos.put("Выучить Java", true);
        todos.put("Найти классную работу", false);
        todos.clear(); // дополните код, чтобы очистить список задач

        System.out.println("Todo-список пуст? Ответ: " + todos.isEmpty());// дополните кодом, который даст верный ответ
    }

    public static void third(){
        Map<String, Integer> seats = assignSeats(passengerNames);
        System.out.println("Места пассажиров: " + seats);
    }

    public static void fourth(){
        Main pizzeria = new Main();
        pizzeria.openPizzeria();
        pizzeria.printStatistics();
    }
}
