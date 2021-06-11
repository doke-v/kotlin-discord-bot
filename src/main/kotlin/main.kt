import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import io.github.cdimascio.dotenv.dotenv

suspend fun main() {
    val dotenv = dotenv()
    val client = Kord(dotenv["BOT_TOKEN"])
    val commands = getCommands()

    client.on<MessageCreateEvent> {
        if (message.author?.isBot == true) return@on
        for (command in commands) {
            if (message.content.startsWith("!" + command.name)) {
                try {
                    command.execute(this)
                } catch (e: Exception) {
                    message.channel.createMessage("This command failed to execute.")
                    throw(e)
                }
            }
        }
    }

    client.login {
        playing("with kotlin")
    }
}