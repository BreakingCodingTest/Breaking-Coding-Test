package leejunghyeok;

public class StringArrayCompression {
    public static void main(String[] args) {
        System.out.println(solution("a"));
    }

    public static int solution(String s) {
        return getCompressionLength(s);
    }

    private static int getCompressionLength(String word) {
        String[] alphabets = word.split("");
        int sameWordLength = alphabets.length / 2;
        if(word.length() == 1) {
            return 1;
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1; i <= sameWordLength; i++) {
            String compressionStandardWord = word.substring(0,i);
            int result = calculateCompression(compressionStandardWord, i, alphabets, word);
            answer = Math.min(result, answer);
        }
        return answer;
    }

    private static int calculateCompression(String compressionStandardWord, int i, String[] alphabets, String word) {
        StringBuilder stringBuilder = new StringBuilder();
        String csw = compressionStandardWord;
        int index = 1;
        for (int j = i; j < alphabets.length; j += i) {
            if(j + i <= alphabets.length) {
                String nextCompressionWord = word.substring(j, j + i);
                if(csw.equals(nextCompressionWord)) {
                    index++;
                    if(j+i == alphabets.length) {
                        stringBuilder.append(index++).append(csw);
                    }
                } else {
                    System.out.println(index);
                    if(index > 1) {
                        stringBuilder.append(index).append(csw);
                        if(j+i == alphabets.length) {
                            stringBuilder.append(nextCompressionWord);
                        }
                        index = 1;
                    } else {
                        stringBuilder.append(csw);
                        if(j+i == alphabets.length) {
                            stringBuilder.append(nextCompressionWord);
                        }
                    }
                    csw = nextCompressionWord;
                }

            } else {
                if(index > 1) {
                    stringBuilder.append(index);
                    index = 1;
                }
                String endWord = word.substring(j, alphabets.length);
                stringBuilder.append(csw).append(endWord);
            }

        }

        return stringBuilder.toString().length();
    }
}
