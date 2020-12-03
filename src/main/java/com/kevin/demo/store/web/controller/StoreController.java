/**
 * 
 */
package com.kevin.demo.store.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.demo.common.response.R;
import com.kevin.demo.store.web.dto.StoreDTO;
import com.kevin.demo.store.web.vo.StoreVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author kevin
 *
 */
@RestController
@RequestMapping("/api/store")
@Tag(name = "仓库管理")
public class StoreController {

	@Operation(summary ="查询某个仓库", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @GetMapping("/{id}")
    public R<StoreVO> findById(@Parameter(description="仓库的id")@PathVariable long id, HttpServletRequest request) {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		System.out.println(token);
    	StoreVO store = new StoreVO();
    	store.setId(1L);
    	store.setName("1号库");
    	store.setSize(100);
        return new R<StoreVO>().success().data(store);
    }

	@Operation(summary ="查询仓库列表", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @GetMapping
    public R<List<StoreVO>> findStores() {
    	StoreVO b1 = new StoreVO();
    	b1.setId(1L);
    	b1.setName("1号库");
    	b1.setSize(100);
    	StoreVO b2 = new StoreVO();
    	b2.setId(2L);
    	b2.setName("2号库");
    	b2.setSize(200);
    	StoreVO b3 = new StoreVO();
    	b3.setId(3L);
    	b3.setName("3号库");
    	b3.setSize(300);
    	
    	List<StoreVO> list = new ArrayList<>();
    	list.add(b1);
    	list.add(b2);
    	list.add(b3);
        return new R<List<StoreVO>>().success().data(list);
    }

	@Operation(summary ="修改某一本仓库", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @PutMapping("/{id}")
    public R<StoreVO> updateStore(@Parameter(description="仓库的id")@PathVariable("id") final String id, 
    		@Valid @RequestBody StoreDTO Store) {
        return new R<StoreVO>().success();
    }
}
