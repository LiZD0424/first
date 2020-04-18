import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class myJson {
    public static void main(String[] args) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = simpleDateFormat.parse("1997-04-24");
        Date parse2 = simpleDateFormat.parse("1997-05-07");
        Stu[] stus = new Stu[2];
        ArrayList<Stu> stus1 = new ArrayList<>();
        stus[0] = new Stu("张三", parse1);
        stus[1] = new Stu("李四", parse2);
        stus1.add(new Stu("张三", parse1));
        stus1.add(new Stu("李四", parse2));
        String s1 = mapper.writeValueAsString(stus);//java转json
        /*
        * writeValue(参数1，obj):
		  参数1：
		  File：将obj对象转换为JSON字符串，并保存到指定的文件中
		  Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
		  OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
		  直接转化为字符串writeValueAsString(obj):将对象转为json字符串
		 */
        String s2 = mapper.writeValueAsString(stus1);
        System.out.println(s1);
        System.out.println(s2);
        Stu[] stu = mapper.readValue(s1, Stu[].class);//json转java
        System.out.println(stu[0]);
        System.out.println(stu[1]);
        List<Stu> stus2 = Arrays.asList(mapper.readValue(s2, Stu[].class));
        System.out.println(stus2);
    }
}

class Stu {
    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Stu(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Stu() {
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday.getTime() +
                '}';
    }
}
