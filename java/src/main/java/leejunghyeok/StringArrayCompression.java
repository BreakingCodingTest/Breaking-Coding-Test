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
        //길이 가 1일 경우 return
        if(word.length() == 1) {
            return 1;
        }
        int answer = Integer.MAX_VALUE;
        //문자열 길이의 반까지 해당하는 문자열을 만들기 위한 반복
        for(int i=1; i <= sameWordLength; i++) {
            // 1~문자열 길이의 반까지 문자열을 자름
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
        //자른 문자열 길이 만큼 반복
        for (int j = i; j < alphabets.length; j += i) {
            // 다음 잘라진 문자열의 범위가 전체 문자열보다 작으면
            if(j + i <= alphabets.length) {
                String nextCompressionWord = word.substring(j, j + i);
                //현재 문자열과 다음 문자열이 같을경우 갯수 증가
                if(csw.equals(nextCompressionWord)) {
                    index++;
                    //만약 다음 문자열이 맨마지막일경우 갯수 증가후 결과 문자열에 추가
                    if(j+i == alphabets.length) {
                        stringBuilder.append(index++).append(csw);
                    }
                ////현재 문자열과 다음 문자열이 다를 경우
                } else {
                    //갯수가 2 이상이라면 갯수와 문자열 결과 문자열에 추가 후 갯수 값 1초기화
                    if(index > 1) {
                        stringBuilder.append(index).append(csw);
                        //만약 다음 문자열이 마지막일 경우 문자열만 추가
                        if(j+i == alphabets.length) {
                            stringBuilder.append(nextCompressionWord);
                        }
                        index = 1;
                    //갯수가 1 이라면 그냥 문자열만 추가
                    } else {
                        stringBuilder.append(csw);
                        if(j+i == alphabets.length) {
                            stringBuilder.append(nextCompressionWord);
                        }
                    }
                    //다음 문자열 현재문자열에 저장
                    csw = nextCompressionWord;
                }
            //다음 자르고 싶은 문자열의 범위가 전체 문자열의 길이를 넘어 설경우
            } else {
                //갯수가 1초과면 문자열 갯수도 추가
                if(index > 1) {
                    stringBuilder.append(index);
                    index = 1;
                }
                // 문자열 추가
                String endWord = word.substring(j, alphabets.length);
                stringBuilder.append(csw).append(endWord);
            }

        }

        return stringBuilder.toString().length();
    }
}
