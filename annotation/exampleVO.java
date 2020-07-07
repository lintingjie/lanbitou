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
public class AppActivityVO {

    @ApiModelProperty(value = "活动id", notes = "活动id", dataType = "String")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "课程id", notes = "课程id", dataType = "String")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;

    @ApiModelProperty(value = "banner图片", notes = "banner图片", dataType = "String")
    private String bannerUrl;

    @ApiModelProperty(value = "支付状态，1已购买，2未购买", notes = "支付状态，1已购买，2未购买", dataType = "Integer")
    private Integer payStatus;

    @ApiModelProperty(value = "课程价格", notes = "课程价格", dataType = "Double")
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double price;

}
