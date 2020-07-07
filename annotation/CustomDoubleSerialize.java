package com.ltj.common.format;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 将double类型的数据格式化成小数点后两位的字符串数据：如输出为“900.00”
 * @author lintingjie
 * @date 2020/5/14 13:54
 */
public class CustomDoubleSerialize extends JsonSerializer<Double> {

    private DecimalFormat df = new DecimalFormat("#0.00");

    public CustomDoubleSerialize() {
    }

    public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(this.df.format(value));
    }

}
