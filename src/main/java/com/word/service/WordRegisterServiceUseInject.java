package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseInject {

	// 생성자 Parameter의 객체를 이름(WordDao)으로 찾아 자동으로 연결
	@Inject // 생성하려는 객체 이
	@Named(value="wordDao1") // 생성자 Parameter의 객체의 이름(WordDao)으로 찾을 수 없다면, 객체 이름을 직접 따로 지정해줌으로써 appCtx 내 해당 객체와 연결
	private WordDao wordDao;
	
	public WordRegisterServiceUseInject() {
		
	}
	
//	@Inject
	public WordRegisterServiceUseInject(WordDao wordDao) {
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
	
//	@Inject
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
