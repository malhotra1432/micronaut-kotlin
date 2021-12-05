package com.kodo.api.domain.value

class Name(val name: String) {
    companion object {
        fun create(name: String): Name {
            return Name(name)
        }
    }
}
