import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String weekday = getWeekday();

        System.out.println("Hola, ¿como te llamas?");
        String name = scanner.nextLine();
        System.out.println("Hola, " + name + ", ¿como te sientes este bonito " + weekday + "?");
        String stateMind = scanner.nextLine().toLowerCase(Locale.ROOT);
        switch (stateMind) {
            case "triste":
                getJoke();
                break;
            case "alegre":
                System.out.println("Me alegro");
                break;
            case "nervioso":
                System.out.println("No te ralles");
                break;
            default:
                System.out.println("No te he entendido");
                break;
        }
    }

    private static String getWeekday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1: return "Lunes";
            case 2: return "Martes";
            case 3: return "Miércoles";
            case 4: return "Jueves";
            case 5: return "Viernes";
            case 6: return "Sábado";
            default: return "Domingo";
        }
    }

    private static void getJoke() {
        Random random = new Random();
        int value = random.nextInt(10);

        switch (value) {
            case 0:
                System.out.println("¿Cuál es el último animal que subió al arca de Noé? El del-fin.");
                break;

            case 1:
                System.out.println("¿Cómo se dice pañuelo en japonés? Saka-moko.");
                break;

            case 2:
                System.out.println("¿Cómo se dice disparo en árabe? Ahí-va-la-bala.");
                break;

            case 3:
                System.out.println("¿Qué le dice un gusano a otro gusano? Voy a dar una vuelta a la manzana.");
                break;

            case 4:
                System.out.println("¿Cuál es el colmo de Aladdín? Tener mal genio.");
                break;

            case 5:
                System.out.println("Si se muere una pulga, ¿a dónde va? Al pulgatorio.");
                break;

            case 6:
                System.out.println("¿Cómo se dice pelo sucio en chino? Chin cham pu.");
                break;

            case 7:
                System.out.println("Estás obsesionado con la comida, de verdad. ¿Qué dices croquetamente?");
                break;

            case 8:
                System.out.println("¿Por qué las focas miran siempre hacia arriba? ¡Porque ahí están los focos!");
                break;

            case 9:
                System.out.println("¿Cómo se llama el primo de Bruce Lee? Broco Lee.");
                break;
        }
    }
}
