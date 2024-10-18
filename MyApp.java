import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public static void main(String[] args) {
        HashMap<String, Integer> studentGrades = new HashMap<>();
        
        // 총점을 계산할 변수
        int totalScore = 0;
        double averageScore = 0.0;
        
        // 파일 경로 설정
        String filePath = "C:/Temp/inputData2024.txt";

        try {
            // 파일로부터 데이터를 읽기 위한 FileReader와 Scanner 생성
            FileReader fr = new FileReader(new File(filePath));
            Scanner sc = new Scanner(fr);
            
            // 파일로부터 한 줄씩 읽어서 HashMap에 저장
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");  // 공백을 기준으로 이름과 성적을 분리
                String name = data[0];
                int score = Integer.parseInt(data[1]);
                studentGrades.put(name, score);  // HashMap에 이름과 성적 저장
            }
            
            // 파일 입력 종료 후, 스트림 닫기
            sc.close();
            fr.close();
            
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
