import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class MyApp
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> studentGrades = new HashMap<>();
        int totalScore = 0;
        double averageScore = 0.0;
        String filePath = "C:/Temp/inputData2024.txt";

        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            InputStreamReader isr = new InputStreamReader(fis, "MS949");
            Scanner sc = new Scanner(isr);
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");
                String name = data[0];
                int score = Integer.parseInt(data[1]);
                studentGrades.put(name, score);
            }
            
            sc.close();
            fis.close();
            
            // HashMap에서 성적을 하나씩 가져와서 총점을 계산
            Iterator<String> iterator = studentGrades.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                totalScore += studentGrades.get(key);
            }

            // 평균 계산
            averageScore = (double) totalScore / studentGrades.size();

            // 출력: 학생들의 성적, 총점, 평균
            System.out.println("학생 성적 리스트:");
            for (String key : studentGrades.keySet()) {
                System.out.println(key + " : " + studentGrades.get(key));
            }

            System.out.println("총점: " + totalScore);
            System.out.printf("평균: %.2f\n", averageScore);

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + filePath);
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
    }
}