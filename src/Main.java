import java.util.Scanner;

public class Main {
    // Комментарий
    /* Многострочный комментарий */

    private static final double field = 10.58;
    private static final String name1 = "Вася";
    private static final String name2 = "Джин";
    private static final int time1 = 10;
    private static final float speed = 100.0f;
    private static final boolean agreement = false;
    private static String agreementString1 = "- Ну, я пошёл...";
    private static String agreementString2 = "- Счас, разбежался! Сам сгинь!";

    //метод
    public static void main(String[] args) throws InterruptedException {
        System.out.println(name1 + ": - Который час? Я тебя " + time1 + " раз спрашиваю!");
        System.out.println(name2 + ": - Сейчас  " + field + "! Я тебе " + time1 + " раз отвечаю!");
        System.out.println(name1 + " - Сгинь со скоростью " + speed + " километров в час!");

        //Получить строку ответа, для agreement = false
        String agrimentString;
        if (agreement) {
            agrimentString = agreementString1;
        } else {
            agrimentString = agreementString2;
        }
        //Ответить
        System.out.println(agrimentString);

        System.out.println("- Сгинь, пропади!");

        //три раза "Тьфу!" через левое плечо.
        for (int i = 0; i < 3; i++) {
            System.out.println("- Тьфу!");
        }

        //вопрос - ответ
        //массив ответов
        String[] sentences = new String[]{"Нифига!", "Ни за что!", "Никогда!"};
        //вывести вопрос на экран - на экран консоли
        System.out.println(name2 + ":- У меня есть три ответа, выбери, какой ты хочешь услышать?");
        //получить ответ с клавиатуры - с консоли, используя написанную нами функцию getAnswer()
        int answer = myGetAnswer() - 1;
        System.out.println(name2 + ":- Вот тебе ответ - " + sentences[answer]);

        //Пустые строки
        System.out.print("\n\n\n");

        System.out.println(name1 + ": - Считаю!!!");

        //заполняем массив отсчётов {0,1,2,3,4,5,6,7,8,9,10}
        int[] delayTips = new int[11];
        for (int i = 1; i < delayTips.length; i++) {
            delayTips[i] = i;
        }

        //цикл - проговариваем отсчёты,
        // пока или отчёты не кончатся,
        // или в строке не появится слово "умею"
        for (int i = 1; i <= 10; i++) {
            int delayTip = delayTips[i];
            String delayTipString = myGetDelayTipString(delayTip);
            System.out.println(delayTipString);

            //пауза 2000 миллисекунд = 2 секунды перед слудующий отчётом
            mySleep(2000L);

            if (delayTipString.contains("умею")) {
                break;
            }
        }

        //пауза 2000 миллисекунд = 2 секунды перед слудующий отчётом
        mySleep(2000L);

        System.out.println(name2 + ": - О! Как ты мне надоел. Улетаю, шут с тобой!");

        //финальная пауза 3000 миллисекунд = 3 секунды перед слудующий отчётом
        mySleep(3000L);

        //очистить экран
        myClearScreen();
    }


    /**
     * читаем ответ введёный с клавиатуры
     * если введено число не находящееся в ожидаемом диапазоне 1-3,
     * приводим его к этому диапазону,
     * то, что меньше 1, считается 1,
     * то, что больше 3, считается 3
     *
     * @return - ответ в диапазоне 1-3
     */
    static int myGetAnswer() {
        //читаем значение, ввёдёное с консоли
        int answerTmp = myReadConsole();

        //приводим прочитанное число к диапазону 1-3
        int answer;
        if (answerTmp < 2) {
            answer = 1;
        } else if (answerTmp == 2) {
            answer = 2;
        } else {
            answer = 3;
        }
        return answer;
    }

    /**
     * читаем значение, ввёдёное с консоли
     *
     * @return - число введёное с клавиатуры
     */
    static int myReadConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Преобразует отсчёт в виде числа в строку
     *
     * @param delayTip - отчёт
     * @return название
     */
    static String myGetDelayTipString(int delayTip) {
        String delayString = "";
        switch (delayTip) {
            case 1:
                delayString = "- Один!";
                break;
            case 2:
                delayString = "- Два!";
                break;
            case 3:
                delayString = "- Три!";
                break;
            default:
                delayString = "- Дальше не умею считать...";
                break;
        }

        return delayString;
    }


    /**
     * Очистить экран.
     */
    private static void myClearScreen() {
        //очистить экран
        for (int i = 1; i < 70; i++) {
            System.out.println();
        }
    }

    /**
     * Приостанавливает выполненение потока команд на delay миллисекунд
     *
     * @param delay - время задержки в миллисекундах
     * @throws InterruptedException - если что-то пойдёт не так...
     */
    private static void mySleep(Long delay) throws InterruptedException {
        Thread.sleep(delay);
    }

}