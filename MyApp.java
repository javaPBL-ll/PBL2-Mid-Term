package PBL_teamproject;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;
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
    public static void main(String[] args) {
        HashMap<String, Integer> studentGrades = new HashMap<>();
        
        // 총점을 계산할 변수
        int totalScore = 0;
        double averageScore = 0.0;
        
        // 파일 경로 설정
        String filePath = "C:\\temp\\inputData2024.txt";

        try {
            // MS949 인코딩으로 파일을 읽기 위한 InputStreamReader와 Scanner 생성
            FileInputStream fis = new FileInputStream(new File(filePath));
            InputStreamReader isr = new InputStreamReader(fis, "MS949");
            Scanner sc = new Scanner(isr);  // InputStreamReader를 이용하여 스캐너 생성
            
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
            fis.close();
            
            // HashMap에서 성적을 하나씩 가져와서 총점을 계산
            Iterator<String> iterator = studentGrades.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                totalScore += studentGrades.get(key);
            }
            
            // 평균 계산
            averageScore = (double) totalScore / studentGrades.size();
            
            //학생들의 총점과 평균 출력
            System.out.println("------ 계산 결과 ------");
            System.out.println("총점: " + totalScore);
            System.out.printf("평균: %.1f\n", averageScore);
            
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + filePath);
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
        
        
    }
}
