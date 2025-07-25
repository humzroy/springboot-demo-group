package com.github.yizhen.demo.feign.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yizhen
 * @date 2024/04/27 21:16
 **/
@Data
public class FileUploadModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fileName;

}
