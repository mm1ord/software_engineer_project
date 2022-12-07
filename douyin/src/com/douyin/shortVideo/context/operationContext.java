package com.douyin.shortVideo.context;

import com.douyin.shortVideo.entity.Video;

import java.util.HashMap;
import java.util.Map;

public class operationContext {

    public Map<Integer, Video> map1 = new HashMap<>();
    public Map<Integer, Video> map2 = new HashMap<>();

    public Video getVideo(Integer id) {
        System.out.println("刷到下一个视频");
        return map1.get(id);
    }

    public void updateVideo(Integer id,Video video) {
        map2.put(id, video);
    }

    public void deleteVideo(Integer id) {
        map2.remove(id);
    }


}
