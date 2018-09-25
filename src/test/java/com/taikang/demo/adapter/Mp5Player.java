package com.taikang.demo.adapter;

/**
 * MP5播放器
 *
 * @author Eunice
 * @date 2018/9/3
 */
public class Mp5Player implements AdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void playMp5(String fileName) {
        System.out.println("播放MP5: " + fileName);
    }
}
