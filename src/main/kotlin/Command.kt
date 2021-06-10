import dev.kord.core.event.message.MessageCreateEvent

abstract class Command(val name: String) {
    abstract suspend fun execute(event: MessageCreateEvent)
}