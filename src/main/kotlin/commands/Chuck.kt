package commands
import com.github.kittinunf.fuel.httpGet
import dev.kord.core.event.message.MessageCreateEvent
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class JokeData(val value: String)

class Chuck : Command("chuck") {
    override suspend fun execute(event: MessageCreateEvent) {
        val (_, _, result) = "https://api.chucknorris.io/jokes/random".httpGet().responseString()
        val obj = Json { ignoreUnknownKeys = true }.decodeFromString<JokeData>(result.get())
        event.message.channel.createMessage(obj.value)
    }
}