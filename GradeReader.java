import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * GradeReader 클래스는 파일로부터 학생들의 성적 데이터를 읽습니다
 *
 * @author (2022320003_강동우, 2020315040_채륜, 2023320043_장연희, 2023320033_조미선)
 * @version (20241018)
 */
public class GradeReader
{
    // 스태틱 메소드로 바꾸면서 필요가 없어짐
    // public String filePath;

    // /**
     // * GradeReader 클래스의 객체 생성자
     // */
    // public GradeReader(String filePath)
    // {
        // this.filePath = filePath;
    // }

    /**
     * 파일로부터 학생들의 이름과 성적을 HashMap에 저장합니다
     * 
     * @param 성적 데이터 파일을 경로 filePath
     * @return 학생의 이름을 key, 성적을 value로하는 HashMap을 반환합니다
     */
    public static HashMap<String, Integer> readGrade(String filePath)
    {
        HashMap<String, Integer> studentGrade = new HashMap<>();
        try
        {
            // FileReader fr = new FileReader(new File(filePath));
            // Scanner sc = new Scanner(fr);
            
            // MS949 인코딩으로 파일을 읽기 위한 InputStreamReader와 Scanner 생성
            FileInputStream fr = new FileInputStream(new File(filePath));
            InputStreamReader isr = new InputStreamReader(fr, "MS949");
            Scanner sc = new Scanner(isr);  // InputStreamReader를 이용하여 스캐너 생성
            
            while (sc.hasNext())
            {
                String name = sc.next();
                Integer score = sc.nextInt();
                studentGrade.put(name, score);
            }
            fr.close();
            sc.close();
        }
        
        catch (FileNotFoundException e)
        {
            System.out.println("파일을 찾을 수 없습니다" + filePath);
        }
        
        catch (Exception e)
        {
            System.out.println("오류가 발생했습니다");
        }
        return studentGrade;
    }
}