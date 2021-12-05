package com.kodo.api.domain.value

class Description(val description: String) {
    companion object {
        fun create(description: String): Description {
            return Description(description)
        }
    }
}
