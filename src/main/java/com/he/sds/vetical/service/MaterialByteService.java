package com.he.sds.vetical.service;

import com.he.sds.vetical.entity.MaterialByte;

public interface MaterialByteService {

    MaterialByte getMaterialByteByName(String MaterialName);

    void insertMaterialByte(MaterialByte materialByte);
}
