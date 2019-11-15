package com.softtron.pinmaovideo.daos;

import java.util.Map;
import java.util.Set;

import com.softtron.pinmaovideo.domains.TVideo;

public interface VideoDao {
	public int saveVideo(Map video);
	public int updateVideo(Map video);
	public Set<TVideo> findAllVideos(Map map);
	public int findAllVideos2();
	public int deleteVideo(int videoId);
}
