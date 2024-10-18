import java.util.HashMap;
import java.util.Iterator;

/**
 * GradeCal 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class GradeCal
{
    private HashMap<String, Integer> studentGrades;

    public GradeCal(HashMap<String, Integer> studentGrades)
    {
        this.studentGrades = studentGrades;
    }

    public int calculateTotalScore()
    {
        int totalScore = 0;
        Iterator<String> iterator = studentGrades.keySet().iterator();

        while (iterator.hasNext())
        {
            String key = iterator.next();
            totalScore += studentGrades.get(key);
        }
        return totalScore;
    }

    public double calculateAverageScore()
    {
        int totalScore = calculateTotalScore();
        return (double) totalScore / studentGrades.size();
    }
}