package commands
import dev.kord.core.event.message.MessageCreateEvent

class Ping: Command("ping") {
    override suspend fun execute(event: MessageCreateEvent) {
        event.message.channel.createMessage("!pong")
    }
}