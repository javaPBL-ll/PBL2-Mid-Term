import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * GradeReader 클래스는 파일로부터 학생들의 성적 데이터를 읽습니다
 *
 * @author (2022320003_강동우, 2020315040_채륜, 2023320043_장연희, 2023320033_조미선)
 * @version (20241018)
 */
public class GradeReader
{
    //스태틱 메소드로 바꾸면서 필요가 없어짐
    private String filePath;
    private int highScore;
    private List highScoreStudent;

    /**
     * GradeReader 클래스의 객체 생성자
     */
    public GradeReader(String filePath)
    {
        this.filePath = filePath;
        this.highScore = 0;
        this.highScoreStudent = new ArrayList<>();
    }

    /**
     * 파일로부터 학생들의 이름과 성적을 HashMap에 저장합니다
     * 
     * @param 성적 데이터 파일을 경로 filePath
     * @return 학생의 이름을 key, 성적을 value로하는 HashMap을 반환합니다
     */
    public HashMap<String, Integer> readGrade()
    {
        HashMap<String, Integer> studentGrade = new HashMap<>();
        try
        {
            FileInputStream fr = new FileInputStream(new File(filePath));
            InputStreamReader isr = new InputStreamReader(fr, "MS949");
            Scanner sc = new Scanner(isr);
            while (sc.hasNext())
            {
                String name = sc.next();
                Integer score = sc.nextInt();
                studentGrade.put(name, score);

                if (score > highScore)
                {
                    highScore = score;
                    highScoreStudent.clear();
                    highScoreStudent.add(name);
                }
                else if(score == highScore)
                {
                    highScoreStudent.add(name);
                }
            }
            fr.close();
            sc.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println("파일을 찾을 수 없습니다");
            System.out.println("파일경로가 올바른지 확인하세요");
            System.out.println("입력된 파일 경로 = " + filePath);
            System.exit(0);
        }

        catch (Exception e)
        {
            System.out.println("오류가 발생했습니다");
            System.out.println("입력파일에 문제가 있을 가능성이 있습니다");
            System.exit(0);
        }
        return studentGrade;
    }

    /**
     * 최고 점수를 가진 학생들
     * 
     * @param
     * @return 최고 점수를 가진 학생들의 이름 리스트를 반환합니다
     */
    public List<String> getHighScoreStudent()
    {
        return this.highScoreStudent;
    }
}