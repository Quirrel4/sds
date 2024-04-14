package com.he.sds.common.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getRandomBussinessId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
