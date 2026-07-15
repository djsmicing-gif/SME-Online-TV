package com.smeonlinetv.app

import org.koin.dsl.module
import com.smeonlinetv.app.data.repository.ChannelRepository
import com.smeonlinetv.app.data.repository.VideoRepository
import com.smeonlinetv.app.data.repository.NewsRepository
import com.smeonlinetv.app.data.repository.UserRepository

val appModule = module {
    single { ChannelRepository() }
    single { VideoRepository() }
    single { NewsRepository() }
    single { UserRepository() }
}
