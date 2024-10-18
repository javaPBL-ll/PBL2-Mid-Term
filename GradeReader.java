import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * GradeReader 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class GradeReader
{
    private String filePath;

    public GradeReader(String filePath)
    {
        this.filePath = filePath;
    }

    public HashMap<String, Integer> readGrades()
    {
        HashMap<String, Integer> studentGrades = new HashMap<>();
        try
        {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] data = line.split(" ");
                String name = data[0];
                Integer score = Integer.parseInt(data[1]);
                studentGrades.put(name, score);
            }
            sc.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + filePath);
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
        return studentGrades;
    }
}