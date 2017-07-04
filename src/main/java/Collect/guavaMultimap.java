package Collect;

import com.alibaba.fastjson.JSON;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;

/**
 * Created by liuyang on 2017/7/4.
 */
public class guavaMultimap {

    public static void main(String[] args) {
//        Multimap<String, StudentScore> scoreMultimap = getStringStudentScoreMultimap();

//            修改视图
//        modifyMapInView(scoreMultimap);



        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        //kv=null
        multimap.put("qwe",null);
        multimap.put(null,1);
        multimap.put(null,1);
        System.out.println(multimap);



    }

    private static void modifyMapInView(Multimap<String, StudentScore> scoreMultimap) {
        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
//        studentScore.clear();
        StudentScore studentScoreNew=new StudentScore();
        studentScoreNew.CourseId=1011;
        studentScoreNew.score=90;
        studentScore.add(studentScoreNew);

        System.out.println(scoreMultimap.get("peida"));
    }

    private static Multimap<String, StudentScore> getStringStudentScoreMultimap() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("peida", studentScore);
        }
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());
        System.out.println(scoreMultimap.get("peida"));
        return scoreMultimap;
    }
}

class StudentScore {

    int CourseId;
    int score;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("CourseId", CourseId)
            .add("score", score)
            .toString();
    }
}