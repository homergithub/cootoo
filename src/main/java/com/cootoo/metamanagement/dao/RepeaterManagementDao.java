package com.cootoo.metamanagement.dao;

import java.util.List;

import com.cootoo.metamanagement.domain.Repeater;

public interface RepeaterManagementDao {

	int insertRepeater(List<Repeater> repeaterList);
	
	int deleteRepeater(List<String> repeaterIDList);
	
	int updateRepeater(Repeater repeater);
}
