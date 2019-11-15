package com.softtron.pinmaovideo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtron.pinmaovideo.domains.TVideo;
import com.softtron.pinmaovideo.services.VideoService;

@RestController
public class Router {
	@Autowired
	VideoService videoService;

	@RequestMapping(path = "index")
	public String get() {
		return "hello world!";
	}

	@RequestMapping(path = "savevideo")
	public Map saveVideo(@RequestBody Map map) {
		Map resultMap = new HashMap();
		Map video = (Map) map.get("video");

		if (Integer.parseInt(String.valueOf(video.get("videoId"))) == -1) {// 插入
			videoService.saveVideo(video);
			resultMap.put("videoId", video.get("videoId"));
		} else {
			videoService.updateVideo(video);
		}

		return resultMap;
	}

	@RequestMapping(path = "findallvideos/{page}/{count}.do")
	public Map findAllVideos(@PathVariable("page") int page, @PathVariable("count") int count) {
		Map resultMap = new HashMap();
		Map map = new HashMap();
		map.put("start", (page - 1) * count);
		map.put("count", count);
		// 获取分页数据
		resultMap.put("videos", videoService.findAllVideos(map));
		// 获取总数
		resultMap.put("total", videoService.findAllVideos());
		return resultMap;
	}
	@RequestMapping(path = "deletevideo/{videoId}.do")
	public Map deleteVideo(@PathVariable int videoId) {
		 videoService.deleteVideo(videoId);
		 return null;
	}
}
