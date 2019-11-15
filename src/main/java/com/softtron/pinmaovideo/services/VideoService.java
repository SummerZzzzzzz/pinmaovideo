package com.softtron.pinmaovideo.services;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtron.pinmaovideo.daos.VideoDao;
import com.softtron.pinmaovideo.domains.TVideo;

@Service
public class VideoService {
	@Autowired
	VideoDao videoDao;

	public int saveVideo(Map video) {
		return videoDao.saveVideo(video);
	}
	public int updateVideo(Map video) {
		return videoDao.updateVideo(video);
	}

	public Set<TVideo> findAllVideos(Map map) {
		return videoDao.findAllVideos(map);
	}

	public int findAllVideos() {
		return videoDao.findAllVideos2();
	}
	
	public int deleteVideo(int videoId) {
		return videoDao.deleteVideo(videoId);
	}
}
