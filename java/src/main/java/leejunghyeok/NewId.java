package leejunghyeok;

public class NewId {
    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        return changeId(new_id);
    }

    private static String changeId(String id) {
        String newId = firstChange(id);
        newId = secondChange(newId);
        newId = thirdChange(newId);
        newId = forthChange(newId);
        newId = fifthChange(newId);
        newId = sixthChange(newId);
        newId = forthChange(newId);
        newId = seventhChange(newId);
        return newId;
    }

    private static String seventhChange(String newId) {
        if (newId.length() <= 2) {
            StringBuilder newIdBuilder = new StringBuilder(newId);
            while(newIdBuilder.length() !=3 ) {
                newIdBuilder.append(newIdBuilder.substring(newIdBuilder.length() - 1, newIdBuilder.length()));
            }
            newId = newIdBuilder.toString();
        }
        return newId;
    }

    private static String sixthChange(String newId) {
        if (newId.length() >= 16) {
            return newId.substring(0, 15);
        }
        return newId;
    }

    private static String fifthChange(String newId) {
        if(newId.isEmpty()) {
            return "a";
        }
        return newId;
    }

    private static String forthChange(String newId) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<newId.length(); i++) {
            if(i==0 && newId.charAt(i) == '.') {
                continue;
            } else if(i == newId.length()-1 && newId.charAt(i) == '.') {
                continue;
            }
            stringBuilder.append(newId.charAt(i));
        }

        return stringBuilder.toString();
    }

    private static String thirdChange(String newId) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newId.length(); i++) {
            if (newId.charAt(i) == '.') {
                for (int j = i + 1; j < newId.length(); j++) {
                    if (newId.charAt(j) != '.') {
                        stringBuilder.append(newId.charAt(i));
                        i = j-1;
                        break;
                    }
                }
            } else {
                stringBuilder.append(newId.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static String secondChange(String newId) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newId.length(); i++) {
            if((newId.charAt(i) >= '0' && newId.charAt(i) <= '9') ||(newId.charAt(i) >= 'a' && newId.charAt(i) <= 'z') || newId.charAt(i) == '-' || newId.charAt(i) == '_' || newId.charAt(i) == '.') {
                stringBuilder.append(newId.charAt(i));
            }

        }
        return stringBuilder.toString();
    }

    private static String firstChange(String id) {
        return id.toLowerCase();
    }
}
