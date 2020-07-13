package com.ltj.service.builder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author lintingjie
 * @date 2020/4/29 16:09
 */
public class FunctionDemo {
	
	//1、Function：接受一个输入参数，返回一个结果
	//我们通过传入不同的Function，实现了在同一个方法中实现不同的操作。
	//Function<T, R> => R apply(T t);
	
	//2、Predicate：接受一个输入参数，返回布尔值
	//Predicate<T> => boolean test(T t);
	
	//3、Consumer：接受一个输入参数，无返回值
	//Consumer<T> => void accept(T t);
	
	//4、Supplier：无输入参数，返回一个结果
	//Supplier<T> => T get();

    @Autowired
    BaseFeignService baseFeignService;


    /**
     * 设置教师名称
     * @param teacherId
     * @param teacherName
     */
    public void buildTeacherName(Long teacherId, Consumer<String> teacherName) {
		
        TeacherInfoVO teacherInfo = baseFeignService.getTeacherInfo(teacherId);
        teacherName.accept(teacherInfo.getTeacherName()); 
    }
	
	 public int calculate(Function<Integer> func, int number) {
        return func.apply(number1); 
    }


	public static void main(String[] args){
		CourseInfo courseInfo = courseService.getById(1);
		buildTeacherName(courseInfo.getTeacherId(), courseInfo::setTeacherName);
		
		Function<Integer,Integer> test1=i->i+1;
		Function<Integer,Integer> test2=i->i*i;
		System.out.println(calculate(test1,5));//6
		System.out.println(calculate(test2,5));//25
	}
	




}
