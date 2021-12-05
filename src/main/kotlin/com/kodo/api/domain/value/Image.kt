package com.kodo.api.domain.value

class Image(val image: String){
    companion object {
        fun create(image: String): Image {
            return Image(image)
        }
    }
}
