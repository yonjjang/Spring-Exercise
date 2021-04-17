package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseAutowired {

	@Autowired (required = false) // required = false 이면 해당 객체가 없을 때 Autowired 안 함 (Exception 피하기)
	@Qualifier("usedDao") // appCtx 내 qualifier 속성 setting 후 해당 객체를 가르키게 함 
	private WordDao wordDao; // 객체 이름이 같으면 우선적으로 해당 객체로 Autowired 해줌 (그러나 좋은 방법이 아님)
	
	// 생성자에 Autowired 없이 Property나 Method에 Autowired 사용 시, Default 생성자 꼭 선언 필요
	public WordRegisterServiceUseAutowired() {
		
	}
	
	// 생성자 Parameter의 객체를 type(WordDao)으로 찾아 자동으로 연결
	@Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
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
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
