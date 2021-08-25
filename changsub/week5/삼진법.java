import java.util.*;

public class 삼진법 {
    public int solution(int n) {
        int answer = 0;

        String convertedString = makeRadix3(n);
        convertedString = reverseString(convertedString);
        answer = Integer.parseInt(convertedString, 3);

        return answer;
    }

    private String makeRadix3(int n) {
        String converted = "";
        while(n > 0) {
            converted = (n % 3) + converted;
            n /= 3;
        }

        return converted;
    }

    private String reverseString(String str) {
        StringBuffer sb = new StringBuffer(str);

        return sb.reverse().toString();
    }
}
