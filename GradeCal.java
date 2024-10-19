import java.util.HashMap;
import java.util.Iterator;

/**
 * GradeReader 클래스는 파일로부터 학생들의 성적 데이터를 읽습니다
 *
 * @author (2022320003_강동우, 2020315040_채륜, 2023320043_장연희, 2023320033_조미선)
 * @version (20241018)
 */
public class GradeCal
{
    private HashMap<String, Integer> studentGrade;

    /**
     * GradeCal 클래스의 객체 생성자
     */
    public GradeCal(HashMap<String, Integer> studentGrade)
    {
        this.studentGrade = studentGrade;
    }

    /**
     * HashMap에 저장된 학생들의 성적을 모두 더해 총점을 계산합니다
     *
     * @param
     * @return 학생들의 성적 총합을 반환합니다
     */
    public int calculateTotalScore()
    {
        int totalScore = 0;
        Iterator<String> iterator = studentGrade.keySet().iterator();

        while (iterator.hasNext())
        {
            String key = iterator.next();
            totalScore += studentGrade.get(key);
        }
        return totalScore;
    }

    /**
     * HashMap에 저장된 학생들의 성적 평균을 계산합니다
     *
     * @param
     * @return 총점을 계산한 후, 학생 수로 나누어 평균을 계산합니다
     */
    public double calculateAverageScore()
    {
        int totalScore = calculateTotalScore();
        return (double) totalScore / studentGrade.size();
    }
}