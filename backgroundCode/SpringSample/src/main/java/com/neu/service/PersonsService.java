package com.neu.service;

import java.util.List;

import com.neu.vo.PersonsVO;

public interface PersonsService {
	public List<PersonsVO> getPersonList(String id);
}
