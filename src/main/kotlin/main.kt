import commands.Ping
import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import io.github.cdimascio.dotenv.dotenv

suspend fun main() {
    System.setProperty("io.ktor.random.secure.random.provider", "DRBG")
    val dotenv = dotenv()
    val client = Kord(dotenv["BOT_TOKEN"])
    val commands = setOf(
        Ping(),
    )
    client.on<MessageCreateEvent> {
        for (command in commands) {
            if(message.content.startsWith("!" + command.name)){
                command.execute(this)
                return@on
            }
        }
    }
    client.login {
        playing("with kotlin")
    }
}

