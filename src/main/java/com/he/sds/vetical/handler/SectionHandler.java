package com.he.sds.vetical.handler;


import com.he.sds.common.util.UUIDUtil;
import com.he.sds.vetical.entity.Section;
import com.he.sds.vetical.reponse.SectionVO;
import com.he.sds.vetical.service.SectionService;
import org.springframework.stereotype.Component;


@Component
public abstract class SectionHandler<T> {

    SectionService sectionService;

    //制图，将规格化的数据保存到数据库
    abstract SectionVO handle(FileData<T> fileData,String SectionId);

    public void uploadSectionData(SectionVO sectionVO,String sectionId){
        //上传到存储服务器，暂定华为云
    }

    public void dealData2Section(String uri,FileType fileType){
        String SectionId = UUIDUtil.getRandomBussinessId();
        FileTypeHandler fileHandler =FileHandlerFactory.getFileHandler(fileType);
        FileData<T> fileData = fileHandler.dealFileType(uri);
        //这三步应该做一个事务
        SectionVO vo = handle(fileData,SectionId);
        uploadSectionData(vo,SectionId);
        //sectionService.insertSection(transferSectionVO2PO(vo,SectionId));
    }

    public abstract Section transferSectionVO2PO(SectionVO sectionVO,String sectionId);
}
