package com.taikang.demo;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author Eunice
 * @date 2018/8/14
 */
@JSONType(serialzeFeatures = {SerializerFeature.WriteMapNullValue})
public class Testt {



    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {


        /*Timestamp timestamp = Timestamp.valueOf("2018-01-02 00:00:00");
        Date date = timestamp;
        System.out.println(date);*/

//        System.out.println(null == null);   //true


        /*System.out.println(System.currentTimeMillis());
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Timestamp(System.currentTimeMillis()).getTime());*/
        /*输出:
        1534331395233
        2018-08-15 19:09:55.237
        1534331395244*/

//        Optional<Object> empty = Optional.empty();

        /*Animal animal = new Animal(1,"旭凤", 18, "男");
        Dog dog = new Dog();
        BeanUtils.copyProperties(animal, dog);
        System.out.println(dog);    //Dog(id=1, name=旭凤, age=18, sex=男, hobby=null)*/

      /*  String str = null;
        boolean empty = StringUtils.isEmpty(str);
        boolean empty1 = StringUtils.isEmpty("");
        System.out.println(empty+"---"+empty1);     //true---true*/

        /*String url = "http:10.130.152.13/live-ser/live//10.130.152.13/live-ser/live//10.130.152.13/live-ser/live/signature/getGenseeSattic?tkcid=test1&timestamp=123123";
        String[] split = url.split("//[^/]+/[^/]+/");
        for (String string: split
             ) {
            System.out.println(string);
        }*/


        /**
         *
         * //[^/]+/[^/]+/
         * 结果
         * http:
         * live/signature/getGenseeSattic?tkcid=test1&timestamp=123123
         *
         * //[^/]
         * 结果
         * http:
         * 0.130.152.13/live-ser/live/signature/getGenseeSattic?tkcid=test1&timestamp=123123
         *
         *
         * //[^/]+
         * 结果
         * http:
         * /live-ser/live/signature/getGenseeSattic?tkcid=test1&timestamp=123123
         *
         *
         *
         *
         */

        //枚举类实现单例模式
        /*Animal animal1 = SingletonEnum.INSTANCE.getInstance();
        Animal animal2 = SingletonEnum.INSTANCE.getInstance();
        System.out.println(animal1);
        System.out.println(animal2);*/

        //set中的元素不可重复, 判断是否重复的一句是equals()和hashCode()都相等
        //可以重写equals()和hashCode()方法实现按需求去重
        /*Set<Dog> dogSet = new TreeSet<Dog>();
        Dog dog1 = new Dog.Buider(1, "huahua").age(10).sex("男").hobby("抽烟, 喝酒, 烫头").build();
        Dog dog2 = new Dog.Buider(2, "haha").age(2).sex("女").hobby("喝奶").build();
        Dog dog3 = new Dog.Buider(1, "huahua").age(0).sex("不详").hobby("睡觉").build();
        
        dogSet.add(dog1);
        dogSet.add(dog2);
        dogSet.add(dog3);

        dogSet.stream().forEach(dog -> {
            System.out.println(dog);
        });*/




        /**
         * 运行结果:
         *
         * Dog(id=2, name=haha, age=2, sex=女, hobby=喝奶)
         * Dog(id=1, name=huahua, age=10, sex=男, hobby=抽烟, 喝酒, 烫头)
         */


//        List<Object> objects = Collections.unmodifiableList();


        /**
         * 测试每次返回的空List是否为同一个List
         */
       /* for(int i=0; i<2; i++){
            List list = getList();
            System.out.println(list);
        }*/

        /*List list = new AbstractList<Integer>(){

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Integer get(int index) {
                return null;
            }
        };*/

      /*  Animal animal = new Animal(1, "ella", 12, "male");
        Map<String, String> describe = BeanUtils.describe(animal);
        System.out.println(describe);
*/



    }

    /*public static List getList(){
//        return Collections.emptyList();   //多次调用返回的是同一个list
        return new ArrayList(); //多次调用返回的是不同的list
    }*/



}
