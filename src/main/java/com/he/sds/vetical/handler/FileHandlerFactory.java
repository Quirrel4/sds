package com.he.sds.vetical.handler;



import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileHandlerFactory {
    private static final Map<FileType,Class<? extends FileTypeHandler>> handlerMap = new HashMap<>();

    static{
        handlerMap.put(FileType.CSV,FileCSVHandler.class);
    }

    public static FileTypeHandler getFileHandler(FileType fileType){
        Class<? extends FileTypeHandler> handlerClass = handlerMap.get(fileType);
        if (handlerClass == null){
            throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
        try{
            Constructor<? extends FileTypeHandler> constructor = handlerClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create file handler for type: " + fileType, e);
        }
    }
}
