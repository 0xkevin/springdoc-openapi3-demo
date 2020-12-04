package com.kevin.demo.book.web.vo;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kevin
 *
 */
@Getter
@Setter
@Schema(description = "书对象")
public class BookVO {
	@Schema(description = "书id")
	private long id;

    @Schema(description = "标题", required = true)
    private String title;

    @Schema(description = "作者", required = true)
    private String author;
    
    //对前端隐藏不可见
    @Hidden
    private String secret;
}
