package com.example.manualdi

import com.example.manualdi.data.UserLocalDataSource
import com.example.manualdi.data.UserRemoteDataSource

class UserRepository(private val localDataSource: UserLocalDataSource,
                     private val remoteDataSource: UserRemoteDataSource
){

}