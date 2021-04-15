package com.word.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseResource {

	// 객체를 이름(wordDao)으로 찾아 자동으로 연결
	@Resource
//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	// 생성자에 Resource 없이 Property나 Method에 Resource 사용 시, Default 생성자 꼭 선언 필요
	public WordRegisterServiceUseResource() {
		
	}
	
	// 생성자가 아닌 Property, Method에만 사용 가능
//	@Resource
	public WordRegisterServiceUseResource(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	//@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}