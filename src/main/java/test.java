import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiusa on 2017/3/24.
 */
public class test {
    public static void main(String[] args) {
        String content = "<head> asdlfad  adsflq !!!</head>";

        String pattern = "<head>\\w+</head>";

        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(content);
        System.out.println(m.group(0));
    }
}
