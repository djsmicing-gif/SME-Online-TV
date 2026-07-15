package com.smeonlinetv.app.data.repository

import com.smeonlinetv.app.data.model.Channel

class ChannelRepository {
    fun getAllChannels(): List<Channel> {
        return listOf(
            Channel(
                id = "1",
                name = "Channel 1",
                thumbnail = "https://via.placeholder.com/400x225?text=Channel+1",
                streamUrl = "https://example.com/stream1",
                isLive = true
            ),
            Channel(
                id = "2",
                name = "Channel 2",
                thumbnail = "https://via.placeholder.com/400x225?text=Channel+2",
                streamUrl = "https://example.com/stream2",
                isLive = true
            )
        )
    }
    
    fun searchChannels(query: String): List<Channel> {
        return getAllChannels().filter { it.name.contains(query, ignoreCase = true) }
    }
}
