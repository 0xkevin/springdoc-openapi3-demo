package com.kevin.demo.store.web.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kevin
 *
 */
@Getter
@Setter
@Schema(description = "仓库VO对象")
public class StoreVO {
	@Schema(description = "仓库id")
	private long id;

	@Schema(description = "仓库名称", required = true)
    private String name;

    @Schema(description = "仓库大小", required = true)
    private Integer size;
    
}
