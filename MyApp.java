import java.util.HashMap;

/**
 * GradeReader 클래스는 파일로부터 학생들의 성적 데이터를 읽습니다
 *
 * @author (2022320003_강동우, 2020315040_채륜, 2023320043_장연희, 2023320033_조미선)
 * @version (20241018)
 */
public class MyApp {
    public static void main(String[] args)
    {
        String filePath = "C:\\Temp\\inputData2024.txt";
        
        // 스태틱 메소드로 변환하기전 코드
        // GradeReader gr = new GradeReader(filePath); 
        // HashMap<String, Integer> sg = gr.readGrade();
        
        HashMap<String, Integer> sg = GradeReader.readGrade(filePath);
        
        GradeCal gc = new GradeCal(sg);
        int totalScore = gc.calculateTotalScore();
        double averageScore = gc.calculateAverageScore();

        System.out.println("------ 계산 결과 ------");
        System.out.println("총점: " + totalScore);
        System.out.println("평균: " + averageScore);
    }
}