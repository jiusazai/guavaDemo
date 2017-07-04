package Collect;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by liuyang on 2017/7/4.
 */
public class guavaTable {

    public static void main(String[] args) {

        init();
    }

    private static void init() {
        Table<Integer, Integer, String> aTable = HashBasedTable.create();

//        aTable.put(null, null, "123");
        aTable.put(1, 1, "123");
        aTable.put(1, 2, "123");
        aTable.put(1, 2, "124");


//        for (char a = 'A'; a <= 'C'; ++a) {
//            for (Integer b = 1; b <= 3; ++b) {
//                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
//                aTable.put(Character.toString(a), ++b, String.format("%c%d", a, b));
//
//            }
//        }

        System.out.println(aTable);

//        System.out.println(aTable.column(2));
//        System.out.println(aTable.row("B"));
//        System.out.println(aTable.get("B", 2));
//
//        System.out.println(aTable.contains("D", 1));
//        System.out.println(aTable.containsColumn(3));
//        System.out.println(aTable.containsRow("C"));
//        System.out.println(aTable.columnMap());
//        System.out.println(aTable.rowMap());
//
//        System.out.println(aTable.remove("B", 3));
    }
}
