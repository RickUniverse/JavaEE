package org.review.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/10/20 - 15:06
 */
public class JSONTest {
    public static void main(String[] args) {

        Person person = new Person(1,"张三！");

        Gson gson = new Gson();
        //将javabean转换为person对象
        String personJSONString = gson.toJson(person);
        System.out.println(personJSONString);
        //将字符串转换为person类型数据
        Person person1 = gson.fromJson(personJSONString, Person.class);
        System.out.println(person1);

    }

    /*list和json字符串之间的转换*/
    @Test
    public void test() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"张三1！"));
        personList.add(new Person(2,"张三2！"));
        personList.add(new Person(3,"张三3！"));

        Gson gson = new Gson();
        String personListJSONString = gson.toJson(personList);
        System.out.println(personListJSONString);
        /*
        * 将字符串转换为list
        * */
        List list = gson.fromJson(personListJSONString, new PersonListType().getType());
        System.out.println(list.get(0));
    }

    /*map和json字符串之间的转换*/
    @Test
    public void test2() {
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"张三1！"));
        personMap.put(2,new Person(2,"张三2！"));
        personMap.put(3,new Person(3,"张三3！"));

        Gson gson = new Gson();
        String personMapJSONString = gson.toJson(personMap);
        System.out.println(personMapJSONString);
        /*
         * 将字符串转换为map
         * */
//        List list = gson.fromJson(personListJSONString, new PersonListType().getType());
        //使用匿名内部类
        Map<Integer, Person> map = gson.fromJson(personMapJSONString, new TypeToken<Map<Integer, Person>>() {
        }.getType());
        System.out.println(map.get(1));

    }
}
