package com.kevin.demo.book.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kevin.demo.book.web.dto.BookDTO;
import com.kevin.demo.book.web.vo.BookVO;
import com.kevin.demo.common.response.R;
import com.kevin.demo.exception.CustomException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author kevin
 *
 */
@RestController
@RequestMapping("/api/book")
@Tag(name = "书籍管理")
public class BookController {
	
	//security属性会要求在swagger-ui页面请求调试的时候，需要带上指定的header -> HttpHeaders.AUTHORIZATION，安全配置请参考OpenApiConfig.java的@SecurityScheme
	@Operation(summary ="查询某一本书籍", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @GetMapping("/{id}")
    public R<BookVO> findById(@Parameter(description="书籍的id")@PathVariable long id) {
    	BookVO book = new BookVO();
    	book.setId(1L);
    	book.setTitle("java");
    	book.setAuthor("kevin1");
        return new R<BookVO>().success().data(book);
    }

	@Operation(summary ="查询书籍列表", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @GetMapping
    public R<List<BookVO>> findBooks() {
    	BookVO b1 = new BookVO();
    	b1.setId(1L);
    	b1.setTitle("java");
    	b1.setAuthor("kevin1");
    	BookVO b2 = new BookVO();
    	b2.setId(2L);
    	b2.setTitle("c");
    	b2.setAuthor("kevin2");
    	BookVO b3 = new BookVO();
    	b3.setId(3L);
    	b3.setTitle("c++");
    	b3.setAuthor("kevin3");
    	
    	List<BookVO> list = new ArrayList<>();
    	list.add(b1);
    	list.add(b2);
    	list.add(b3);
        return new R<List<BookVO>>().success().data(list);
    }

	@Operation(summary ="修改某一本书籍", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @PutMapping("/{id}")
    public R<BookVO> updateBook(@Parameter(description="书籍的id")@PathVariable("id") final String id, 
    		@Valid @RequestBody BookDTO book) {
        return new R<BookVO>().success();
    }
	
	@Operation(summary ="文件上传", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @PostMapping(value = "/uploadFile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public R<String> uploadFile(@Parameter(description="需要上传的文件，仅支持文件类型：jpg,png")@RequestParam(value = "file") MultipartFile file) throws CustomException{
		return new R<String>().success().data("http://xxx.xxx.com/12345.jpg");
    }
}
