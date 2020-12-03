/**
 * 
 */
package com.kevin.demo.book.web.dto;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kevin
 *
 */
@Getter
@Setter
@Schema(description = "书传输对象")
public class BookDTO {

//    @NotBlank
    @Size(min = 0, max = 20)
//    @Schema(description = "标题", required = true, hidden = true)
    @Schema(description = "标题", required = true)
    private String title;

//    @NotBlank
    @Size(min = 0, max = 30)
    @Schema(description = "作者", required = true)
    private String author;
}
