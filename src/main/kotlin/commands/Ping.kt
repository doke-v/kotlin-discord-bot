package commands
import dev.kord.core.event.message.MessageCreateEvent
import io.ktor.util.date.*

class Ping: Command("ping") {
    override suspend fun execute(event: MessageCreateEvent) {
        val messageTimestamp = event.message.timestamp.toEpochMilli()
        val currentTimestamp = getTimeMillis()
        val diff = currentTimestamp - messageTimestamp;
        event.message.channel.createMessage("Pong! Got your message after **${diff}**ms")
    }
}