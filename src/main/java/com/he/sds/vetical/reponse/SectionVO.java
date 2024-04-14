package com.he.sds.vetical.reponse;

import lombok.Data;

@Data
public class SectionVO {
    String sectionName;
    String sectionSourceId;
    String description;

    String PdfUri;

    public SectionVO(String sectionName, String sectionSourceId, String description, String pdfUri) {
        this.sectionName = sectionName;
        this.sectionSourceId = sectionSourceId;
        this.description = description;
        PdfUri = pdfUri;
    }

    public SectionVO() {
    }
}
