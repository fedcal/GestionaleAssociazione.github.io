package com.gestionaleonstage.util;

import java.io.File;
import java.nio.file.Files;

import static org.junit.Assert.assertFalse;

public class FolderTree {
    public FolderTree(){

        File fileWithRelativePath = new File( "EstrazioneDati");
        fileWithRelativePath.mkdir();



    }
}
