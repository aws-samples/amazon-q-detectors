package com.gurudetector.helper

class RealmConfiguration private constructor(val encryptionKey: ByteArray?) {
    class Builder {
        private var encryptionKey: ByteArray? = null

        fun encryptionKey(key: ByteArray): Builder {
            this.encryptionKey = key
            return this
        }

        fun build(): RealmConfiguration {
            return RealmConfiguration(encryptionKey)
        }
    }
}