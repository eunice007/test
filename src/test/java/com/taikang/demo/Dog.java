package com.taikang.demo;

import lombok.Data;

import java.util.Objects;

/**
 * @author Eunice
 * @date 2018/8/21
 */
@Data
public class Dog implements Comparable<Dog> {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String hobby;

    /**
     * id 和 name 相等即相等
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id) &&
                Objects.equals(name, dog.name);
    }

    /**
     * id 和 name 相等即相等
     * @return
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    public Dog() {
    }

    public Dog(Integer id, String name, Integer age, String sex, String hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
    }

    //用构造器创建Dog对象
    private Dog(Buider buider){
        this.id = buider.id;
        this.name = buider.name;
        this.age = buider.age;
        this.sex = buider.sex;
        this.hobby = buider.hobby;
    }

    //多个参数使用构造器
    public static class Buider{
        private Integer id;
        private String name;

        //optional params
        private Integer age;
        private String sex;
        private String hobby;

        public Buider(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Buider age(Integer age){
            this.age = age;
            return this;
        }

        public Buider sex(String sex){
            this.sex = sex;
            return this;
        }

        public Buider hobby(String hobby){
            this.hobby = hobby;
            return this;
        }

        public Dog build(){
            return new Dog(this);
        }
    }

    /**
     * 实例按id进行排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Dog o) {
        if (this.id > o.id){
            return 1;
        } else if (this.id < o.id){
            return -1;
        }
        return 0;
    }
}
