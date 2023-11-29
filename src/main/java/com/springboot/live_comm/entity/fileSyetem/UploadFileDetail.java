package com.springboot.live_comm.entity.fileSyetem;

import com.springboot.live_comm.base.model.impl.BaseModelAdapter;
import lombok.*;

import java.util.Date;

/**
 * @ClassName: UploadFileDetail
 * @Author : ever
 * @Date :2023/11/29  17:12
 * @Description: TODO
 * @Version :1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UploadFileDetail extends BaseModelAdapter<String> {
    private Integer userId;
    private String path;
    private String fileName;
    private Date createTime;
    private Date updateTime;
}
