package Collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyang on 2017/7/4.
 */
public class _001_guavaMultiset {


    public static void main(String[] args) {
        //获取重复值个数
        getKeyCount();
    }

    private static void getKeyCount() {
        String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
        String[] words = strWorld.split("\\|");
        List<String> wordList = new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }
    }


}
