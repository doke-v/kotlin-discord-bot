package commands
import Command
import dev.kord.core.event.message.MessageCreateEvent

class Ping : Command("ping") {
    override suspend fun execute(event: MessageCreateEvent) {
        val msg = event.message
        msg.channel.createMessage("pong!")
    }
}