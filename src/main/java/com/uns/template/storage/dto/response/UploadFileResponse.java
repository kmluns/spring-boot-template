package com.uns.template.storage.dto.response;

import lombok.Getter;
import lombok.Setter;

public class UploadFileResponse {
    @Getter
    @Setter
    private String fileName;

    @Getter
    @Setter
    private String fileDownloadUri;

    @Getter
    @Setter
    private String fileType;

    @Getter
    @Setter
    private long size;

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

}