package com.gurudetector.helper

import java.io.File

class ContextOther {
    fun getExternalFilesDir(type: String?): File? {
        val baseDir = File(System.getProperty("java.io.tmpdir"), "ExternalFiles")
        return if (type != null) {
            File(baseDir, type)
        } else {
            baseDir
        }
    }
}