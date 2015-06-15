package com.cootoo.metamanagement.service;

import java.util.List;
import java.util.Map;

import com.cootoo.metamanagement.domain.Repeater;

public interface RepeaterManagementService {

	Map<String,Object> addRepeater(List<Repeater> repeaterList);
	
	Map<String,Object> deleteRepeater(List<String> repeaterIDList);
	
	Map<String,Object> modifyRepeater(Repeater repeater);
}
