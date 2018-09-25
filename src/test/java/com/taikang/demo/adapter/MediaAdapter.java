package com.taikang.demo.adapter;

/**
 * 适配器
 *
 * @author Eunice
 * @date 2018/9/3
 */
public class MediaAdapter implements AdvanceMediaPlayer {
    Mp3Player mp3Player;
    private String mediaType;

    public MediaAdapter(String mediaType) {
        this.mediaType = mediaType;
    }

    public MediaAdapter() {
    }


    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void playMp5(String fileName) {

    }

    public void playMp3(String fileName){
        mp3Player.playMp3(fileName);
    }
}
