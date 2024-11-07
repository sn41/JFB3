import java.util.Scanner;

public class Main {
    // Комментарий
    /* Многострочный комментарий */


    // private - видимые только из функций класса
    // static - статические (общие для всех объектов класса)
    // final - неизменяемые
    // поля класса
    private static final double field = 10.58;
    private static final String name1 = "Вася";
    private static final String name2 = "Джин";
    private static final int time1 = 10;
    private static final float speed = 100.0f;
    private static final boolean agreement = false;
    private static String agreementString1 = "- Ну, я пошёл...";
    private static String agreementString2 = "- Счас, разбежался! Сам сгинь!";

    // Главный метод
    public static void main(String[] args) throws InterruptedException {
        // Выводим строки на экран
        System.out.println(name1 + ": - Который час? Я тебя " + time1 + " раз спрашиваю!");
        System.out.println(name2 + ": - Сейчас  " + field + "! Я тебе " + time1 + " раз отвечаю!");
        System.out.println(name1 + " - Сгинь со скоростью " + speed + " километров в час!");

        // Получить строку ответа, для agreement = false, это agreementString2 = "- Счас, разбежался! Сам сгинь!"
        String agrimentString;
        if (agreement) {
            agrimentString = agreementString1;
        } else {
            agrimentString = agreementString2;
        }

        // Выводим строку "- Счас, разбежался! Сам сгинь!"
        System.out.println(agrimentString);

        System.out.println("- Сгинь, пропади!");

        //три раза "Тьфу!" через левое плечо.
        for (int i = 0; i < 3; i++) {
            System.out.println("- Тьфу!");
        }

        // Выводим вопрос -
        //   читаем консоль -
        //       по введённому значению находим строку ответа -
        //           выводим эту строку

        // Массив ответов
        String[] sentences = new String[]{"Нифига!", "Ни за что!", "Никогда!"};
        // Вывести вопрос на экран - на экран консоли
        System.out.println(name2 + ":- У меня есть три ответа, выбери, какой ты хочешь услышать?");
        // Получить ответ с клавиатуры - с консоли, используя написанную нами функцию my_get_answer()
        //   Она возвращает значение 1 или 2 или 3
        //       а индексы значений списка sentences равны 0,1,2
        //           поэтому приводим диапазон ответов к диапазону индексов, отнимаем 1.
        int answerIndex = myGetAnswer() - 1;
        // Получаем строку ответа, читаем элемент списка sentences по его индексу answerIndex
        String answerString = sentences[answerIndex];
        // Печатаем строку ответа
        System.out.println(name2 + ":- Вот тебе ответ - " + answerString);

        //Пустые строки
        System.out.print("\n\n\n");

        System.out.println(name1 + ": - Считаю!!!");

        // Заполняем массив отсчётов
        // Там будет {0,1,2,3,4,5,6,7,8,9,10}
        int[] delayTips = new int[11];

        for (int i = 1; i < delayTips.length; i++) {
            delayTips[i] = i;
        }

        // Выполняем цикл -
        //   получаем число из списка - delayTip
        //       преобразуем число delayTip в строку функцией myGetDelayTipString(delayTip)
        //               результат помещаем в переменную delayTipString
        //           выводим на экран эту строку print(delayTipString),
        //       ждём две секунды
        //    проверяем, содержалась ли строка "умею" в выведенной на экран строке delay_tip_string
        //    если содержалась - прекращаем цикл, иначе - переходим к следующей итерации цикла
        //
        // Другими словами, выводим строки на экран, пока мы не прочитаем все значения списка,
        //   соответствующие delay_tips_range
        //       или в выводимой строке не появится слово "умею"

        for (int i = 1; i <= 10; i++) {

            int delayTip = delayTips[i];
            String delayTipString = myGetDelayTipString(delayTip);
            System.out.println(delayTipString);

            //пауза 2000 миллисекунд = 2 секунды перед следующим отчётом
            mySleep(2000L);

            if (delayTipString.contains("умею")) {
                break;
            }
        }

        //пауза 2000 миллисекунд = 2 секунды
        mySleep(2000L);

        System.out.println(name2 + ": - О! Как ты мне надоел. Улетаю, шут с тобой!");

        //финальная пауза 3000 миллисекунд = 3 секунды
        mySleep(3000L);

        //очистить экран
        myClearScreen();
    }


    /**
     * Читаем ответ, введённый с клавиатуры,
     * приводим число к диапазону 1-3,
     *
     * то, что меньше 2, считается 1,
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
     * Прочитать ввод с консоли
     *
     * @return - число введённое с клавиатуры
     */
    static int myReadConsole() {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        return value;
    }

    /**
     * Преобразует число в строку
     *
     * @param delayTip - отчёт
     * @return название
     */
    static String myGetDelayTipString(int delayTip) {

        // Последовательно сравниваем delayTip со значениями
        // 1, 2, 3
        // если delayTip и значение совпали - выполняем соответствующий блок кода
        // и выходим из оператора switch.
        // Например, если delayTip равно 1, выполнится delayTipString = "- Один!"

        // Если ни один из вариантов не совпал с delayTip,
        // тогда выполняется блок кода по-умолчанию
        //      default:
        // Здесь, это -
        //          delayTipString = "- Дальше не умею считать...";
        //          break;

        String delayTipString = "";
        switch (delayTip) {
            case 1:
                delayTipString = "- Один!";
                break;
            case 2:
                delayTipString = "- Два!";
                break;
            case 3:
                delayTipString = "- Три!";
                break;
            default:
                delayTipString = "- Дальше не умею считать...";
                break;
        }

        return delayTipString;
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
     * Приостанавливает выполнение потока команд на delay миллисекунд
     *
     * @param delay - время задержки в миллисекундах
     * @throws InterruptedException - если что-то пойдёт не так...
     */
    private static void mySleep(Long delay) throws InterruptedException {
        Thread.sleep(delay);
    }

}