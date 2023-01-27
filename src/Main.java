

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {

            System.out.print("Введите выражение: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String calcString = reader.readLine();

            Calc calc = new Calc();
            String result = calc.result(calcString);
            System.out.println("Ответ: " + result);
        } catch (CalcException | IOException e) {

        }

    }
}