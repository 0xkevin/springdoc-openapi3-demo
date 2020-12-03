/**
 * 
 */
package com.kevin.demo.store.web.dto;

import javax.validation.constraints.Max;
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
@Schema(description = "仓库DTO对象")
public class StoreDTO {

//    @NotBlank
    @Size(min = 0, max = 20)
//    @Schema(description = "标题", required = true, hidden = true)
    @Schema(description = "仓库名称", required = true)
    private String name;

//    @NotBlank
    @Max(Integer.MAX_VALUE)
    @Schema(description = "仓库大小", required = true)
    private Integer size;
}
