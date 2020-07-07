package com.ltj.core.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hikvision.fireprotection.course.common.format.CustomDoubleSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author lintingjie
 * @date 2020/5/6 14:16
 */
@Data
public class exampleVO {

    @ApiModelProperty(value = "活动id", notes = "活动id", dataType = "String")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "课程价格", notes = "课程价格", dataType = "Double")
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double price;

}
