package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	@Mock
	BookRepository bookRepository;
	@InjectMocks
	BookServiceImpl bookServiceImpl;
	Book book=new Book();
	BookDto bookDto;
	@Before
	public void initiateDate() {
		book=new Book();
		book.setBookId(1);
		book.setBookCode(101);
		book.setAuthor("Jyoshna");
		book.setBookName("Java");
		book.setUserId(1);
		
		bookDto = new BookDto();
		 bookDto.setAuthor("Shilendra");
		 bookDto.setBookName("java");
		 bookDto.setUserId(1);

	}
	
	@Test
	public void testGetBookList() {
		List<Book> bookList=new ArrayList<>();
		bookList.add(book);
		Mockito.when(bookRepository.findAll()).thenReturn(bookList);
		List<Book> bookInfo=bookServiceImpl.getBookList();
		assertNotNull(bookInfo);		
	}
	
	@Test
	public void addbookTest() {
	 
	 Mockito.when(bookRepository.save(Mockito.anyObject())).thenReturn(Mockito.anyObject());
	 
	 ResponseDto responseDto = bookServiceImpl.save(bookDto);
	 
	 assertEquals("Book Added Successfully", responseDto.getMessage());
	 
	}

}
