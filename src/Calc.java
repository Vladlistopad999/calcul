
        import java.util.Arrays;
        import java.util.List;

public class Calc {
    int a, b;
    String operator;


    private int calcExp(int n1, String op, int n2) {
        int res;
        switch (op) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
            default:
                throw new AssertionError();
        }
        return res;
    }


    public String result(String exp) throws CalcException {
        boolean isRomanExp;
        Parse parse = new Parse();


        List<String> expItems = Arrays.asList(exp.split(" "));


        if (expItems.size() != 3) {
            throw new CalcException("ОШИБКА.");
        }


        if (parse.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new CalcException("ОШИБКА. Оператор " + expItems.get(1) + " не корректен, должен быть: + - * / ");
        }


        if (parse.isNumeric(expItems.get(0)) && parse.isNumeric(expItems.get(2))) {
            a = Integer.parseInt(expItems.get(0));
            b = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (parse.isRoman(expItems.get(0)) && parse.isRoman(expItems.get(2))) {
            a = parse.romeToArabConvert(expItems.get(0));
            b = parse.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        }else {
            throw new CalcException("ОШИБКА. Одновременно используются разные системы счисления ");
        }


        if (a > 10) {
            throw new CalcException("ОШИБКА. Число №1 должно быть от 1 до 10");
        }

        if (b > 10) {
            throw new CalcException("ОШИБКА. Число №2 должно быть от 1 до 10");
        }

        int res = calcExp(a, operator, b);


        if (isRomanExp) {
            String sign = res < 0 ? "-" : "";
            if(sign.equals("-")){
                throw new CalcException("ОШИБКА. В римской системе нет отрицательных чисел");
            }

            return sign + parse.arabToRomeConvert(Math.abs(res));
        }


        return String.valueOf(res);
    }

}