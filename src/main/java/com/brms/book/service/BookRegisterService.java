package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookRegisterService implements InitializingBean, DisposableBean{

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	
	// 객체 생성 단계에서 사용되는 method를 appCtx에서 설정
	public void initMethod() {
		System.out.println("BookRegisterService 빈(Bean) 객체 생성 - initMethod");
	}

	// 객체 소멸 단계에서 사용되는 method를 appCtx에서 설정
	public void destroyMethod() {
		System.out.println("BookRegisterService 빈(Bean) 객체 소멸 - destroyMethod");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BookRegisterService 빈(Bean) 객체 생성 - afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("BookRegisterService 빈(Bean) 객체 소멸 - destroy");
	}

	
}