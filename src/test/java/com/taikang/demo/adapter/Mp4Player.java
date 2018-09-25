package com.taikang.demo.adapter;

/**
 * MP4播放器
 *
 * @author Eunice
 * @date 2018/9/3
 */
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("播放MP4: " + fileName);
    }

    @Override
    public void playMp5(String fileName) {

    }
}
