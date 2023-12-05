package com.springboot.live_comm.entity.fileSystem;

import com.springboot.live_comm.base.model.impl.BaseModelAdapter;
import lombok.*;

/**
 * @ClassName: UploadFileDetail
 * @Author : ever
 * @Date :2023/11/29  17:12
 * @Version :1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UploadFileDetail extends BaseModelAdapter<String> {
    private String fileId;
    private Integer userId;
    private String path;
    private String fileName;
}
