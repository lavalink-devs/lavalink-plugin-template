package org.example.plugin

import dev.arbjerg.lavalink.api.ISocketContext
import dev.arbjerg.lavalink.api.PluginEventHandler
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SampleEventHandler : PluginEventHandler() {
    init {
        log.info("Hello, world!")
    }

    override fun onWebSocketOpen(context: ISocketContext, resumed: Boolean) {
        log.info("Websocket opened!")
    }

    companion object {
        private val log = LoggerFactory.getLogger(SampleEventHandler::class.java)
    }
}