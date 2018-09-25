package com.taikang.demo;

/**
 * @author Eunice
 * @date 2018/8/27
 */
public enum SingletonEnum {
    INSTANCE;

    private Animal animal;

    SingletonEnum(){
        this.animal = new Animal();
    }

    public Animal getInstance(){
        return animal;
    }

}
