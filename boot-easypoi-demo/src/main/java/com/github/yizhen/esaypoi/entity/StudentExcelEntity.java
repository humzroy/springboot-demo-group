package com.github.yizhen.esaypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentExcelEntity implements Serializable {
    private static final long serialVersionUID = 435171058019994400L;
    @Excel(name = "姓名")
    public String name;

    @Excel(name = "年龄")
    public Integer age;

    @Excel(name = "年级")
    public String grade;

}
