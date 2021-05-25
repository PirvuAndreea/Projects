package com.ps.Magazin.utils.exporter;

import java.io.File;

public class TXTFileExporter implements FileExporter {
    @Override
    public String exportData(Object object) {
        return object.toString();
    }
}
