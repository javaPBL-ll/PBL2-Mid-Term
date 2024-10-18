import java.util.HashMap;

/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class MyApp {
    public static void main(String[] args) {
        String filePath = "C:/Temp/inputData2024.txt";

        GradeReader gradeReader = new GradeReader(filePath);
        HashMap<String, Integer> studentGrades = gradeReader.readGrades();

        GradeCal gradeProcessor = new GradeCal(studentGrades);
        int totalScore = gradeProcessor.calculateTotalScore();
        double averageScore = gradeProcessor.calculateAverageScore();

        System.out.println("------ 계산 결과 ------");
        System.out.println("총점: " + totalScore);
        System.out.printf("평균: %.1f\n", averageScore);
    }
}