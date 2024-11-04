
package com.gurudetector.helper

class Realm private constructor(config: RealmConfiguration) {
    companion object {
        fun getInstance(config: RealmConfiguration): Realm {
            return Realm(config)
        }
    }
}