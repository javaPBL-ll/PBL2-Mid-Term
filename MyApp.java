import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * GradeReader 클래스는 파일로부터 학생들의 성적 데이터를 읽습니다
 *
 * @author (2022320003_강동우, 2020315040_채륜, 2023320043_장연희, 2023320033_조미선)
 * @version (20241018)
 */
public class MyApp {
    public static void main(String[] args)
    {
        String filePath = ":\\Temp\\inputData2024.txt";
        Scanner sc = new Scanner(System.in);
        System.out.println("성적파일이 존재하는 드라이브문자를 입력하세요. 예)d");
        String drivePath = sc.nextLine();
        filePath = drivePath + filePath;
        
        GradeReader gr = new GradeReader(filePath); 
        HashMap<String, Integer> sg = gr.readGrade();

        GradeCal gc = new GradeCal(sg);
        int totalScore = gc.calculateTotalScore();
        double averageScore = gc.calculateAverageScore();

        if(sg.size() == 0)
        {
            System.out.println("학생데이터가 존재하지 않습니다");
        }
        else
        {
            System.out.println("------ 학생 성적 리스트 ------");
            for(String key : sg.keySet())
            {
                System.out.println(key + " : " + sg.get(key));
            }
            
            System.out.println("------ 학생 이름순 정렬 ------");
            
            List<String> name = new ArrayList<>(sg.keySet());
            Collections.sort(name);
            
            for(String sn : name)
            {
                System.out.println(sn + " : " + sg.get(sn));
            }
            System.out.println("------ 계산 결과 ------");
            System.out.println("총점: " + totalScore);
            System.out.println("평균: " + averageScore);
            
            System.out.println("------ 최우수 학생 ------");
            List<String> highScoreStudents = gr.getHighScoreStudent();
            for (String hss : highScoreStudents)
            {
                System.out.println(hss + " : " + sg.get(hss));
            }
        }
    }
}