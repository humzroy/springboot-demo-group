package com.github.humzroy.esaypoi.controller;


import cn.afterturn.easypoi.handler.inter.IExcelExportServer;
import cn.hutool.core.convert.Convert;
import com.github.humzroy.esaypoi.entity.StudentExcelEntity;
import com.github.humzroy.framework.file.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ExcelController {

    // 普通导出数据
    @GetMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) {
        String fileName = "学生信息表.xlsx";
        ExcelUtil.exportExcel(getStudentList(20),
                "学生信息导出",
                "学生",
                StudentExcelEntity.class,
                fileName,
                response);
    }

    // 导出大文件
    @GetMapping("exportBigExcel")
    public void exportBigExcel(HttpServletResponse response) {
        String fileName = "big学生信息表.xlsx";
        // 这里使用匿名内部类写法，更好的理解参数及逻辑
        ExcelUtil.exportBigExcel("学生信息导出", "学生", StudentExcelEntity.class, fileName, new IExcelExportServer() {
            /**
             *
             * @param param 限制条件，后面的参数，此例为3
             * @param page 页数，从1开始，每次+1
             * @return
             */
            @Override
            public List<Object> selectListForExcelExport(Object param, int page) {
                log.info("当前查询第{}页，参数:{}", page, param);
                // page每次+1，当达到指定的限制条件时，代码停止
                if (Convert.toInt(param) == page) {
                    return null;
                }
                // 符合条件，循环selectListForExcelExport方法，每次导出1w条数据
                List<StudentExcelEntity> studentList = getStudentList(1 * 10000);
                // 处理后返回
                return Arrays.asList(studentList.toArray());
            }
        }, 3, response);

        // lambda写法
        //ExcelUtil.exportBigExcel("学生信息导出", "学生", StudentExcelEntity.class, fileName, (param, page) -> {
        //    log.info("当前查询第{}页，参数:{}", page, param);
        //    // page每次+1，当达到指定的限制条件时，代码停止
        //    if (Convert.toInt(param) == page) {
        //        return null;
        //    }
        //    // 符合条件，循环selectListForExcelExport方法，每次导出1w条数据
        //    List<StudentExcelEntity> studentList = getStudentList(1 * 10000);
        //    // 处理后返回
        //    return Arrays.asList(studentList.toArray());
        //}, 3, response);

        // 使用mybatis查询的伪代码
        //ExcelUtil.exportBigExcel("大数据导出", "大数据", Support.class, fileName, new IExcelExportServer() {
        //    @Override
        //    public List<Object> selectListForExcelExport(Object o, int indexPage) {
        //        Page<Support> pg = new Page<>(indexPage, 100);
        //        IPage<Support> page = supportService.select(pg, pm);
        //        if (page.getRecords() == null || page.getRecords().size() == 0) {
        //            return null;
        //        }
        //        List<SupportExcel> excelList = page.getRecords().stream().map(x -> {
        //            SupportExcel se = new SupportExcel();
        //            BeanUtil.copyProperties(x, se);
        //            se.setExcelDetails(x.getSupportDetailList());
        //            se.setNo(index.getAndIncrement());
        //            return soe;
        //        }).collect(Collectors.toList());
        //        return Arrays.asList(excelList.toArray());
        //    }
        //}, pm, response);

    }


    /**
     * 返回指定行数的学生对象
     *
     * @param row
     * @return
     */
    private List<StudentExcelEntity> getStudentList(int row) {
        List<StudentExcelEntity> list = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            StudentExcelEntity studentExcelEntity = new StudentExcelEntity();
            studentExcelEntity.setAge(i);
            studentExcelEntity.setName(i + "_张三");
            studentExcelEntity.setGrade(i + "年级");
            list.add(studentExcelEntity);
        }
        return list;
    }
}
