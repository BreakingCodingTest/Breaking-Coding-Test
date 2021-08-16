package leejunghyeok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MutualEvaluation {
    public static void main(String[] args) {
        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};
        System.out.println(solution(scores));
    }

    public static String solution(int[][] scores) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Student> students = new ArrayList<>();
        for(int i=0; i < scores.length; i++) {
            students.add(new Student(scores[i][i]));
        }
        for (int i = 0; i < scores.length; i++) {
            List<Integer> studentScores = new ArrayList<>();
            for (int j = 0; j < scores[i].length; j++) {
                studentScores.add(scores[j][i]);
            }
            Collections.sort(studentScores);
            Student student = students.get(i);
            if (studentScores.get(0) == students.get(i).evaluationScore) {
                if(studentScores.stream().filter(a -> a.equals(student.evaluationScore)).count()==1) {
                    studentScores.remove(0);
                }
            } else if(studentScores.get(scores[i].length - 1) == students.get(i).evaluationScore) {
                if(studentScores.stream().filter(a -> a.equals(student.evaluationScore)).count()==1) {
                    studentScores.remove(scores[i].length - 1);
                }
            }
            double average = (double) studentScores.stream().reduce(0, Integer::sum) / studentScores.size();
            stringBuilder.append(calculateGrade(average));
        }
        return stringBuilder.toString();
    }

    private static String calculateGrade(double reduce) {
        if (reduce >= 90) {
            return "A";
        } else if (reduce < 90 && reduce >= 80) {
            return "B";
        } else if (reduce < 80 && reduce >= 70) {
            return "C";
        } else if (reduce < 70 && reduce >= 50) {
            return "D";
        }
        return "F";
    }

    static class Student {
        int evaluationScore;

        public Student(int evaluationScore) {
            this.evaluationScore = evaluationScore;
        }
    }
}

