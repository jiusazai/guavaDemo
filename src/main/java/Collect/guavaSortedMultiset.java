package Collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.Multiset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyang on 2017/7/4.
 */
public class guavaSortedMultiset {


    public static void main(String[] args) {
        //获取重复值个数
        getRepeatCount();
    }

    private static void getRepeatCount() {
        String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
        String[] words = strWorld.split("\\|");
        List<String> wordList = new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = ImmutableSortedMultiset.copyOf(wordList);

        System.out.println(wordsMultiset);
    }
}
