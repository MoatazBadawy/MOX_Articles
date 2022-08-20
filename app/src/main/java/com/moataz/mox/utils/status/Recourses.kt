package com.moataz.mox.utils.status

sealed class Recourses<T>{
    class Success<T>(val transferredData: T) : Recourses<T>()
    class Failure<T>(message: String) : Recourses<T>()
    class Loading<T> : Recourses<T>()
}