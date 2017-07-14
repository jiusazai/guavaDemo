package Collect;

import com.alibaba.fastjson.JSON;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;

/**
 * Created by liuyang on 2017/7/4.
 */
public class _004_guavaListMultimap_ {

    public static void main(String[] args) {
        Multimap<String, StudentScore> scoreMultimap = getStringStudentScoreMultimap();

//            修改视图
        modifyMapInView(scoreMultimap);

    }

    private static void modifyMapInView(Multimap<String, StudentScore> scoreMultimap) {
        Collection<StudentScore> studentScore = scoreMultimap.get("class");
//        studentScore.clear();
        StudentScore studentScoreNew=new StudentScore();
        studentScoreNew.CourseId=1011;
        studentScoreNew.score=90;
        studentScore.add(studentScoreNew);

        System.out.println(scoreMultimap.get("class"));
    }

    private static Multimap<String, StudentScore> getStringStudentScoreMultimap() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 12; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("class", studentScore);
        }
        System.out.println(scoreMultimap.get("class"));
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