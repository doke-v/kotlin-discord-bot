package commands

import com.github.kittinunf.fuel.httpGet
import dev.kord.core.event.message.MessageCreateEvent
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class JokeData(val value: String)

class Chuck : Command("chuck") {
    override suspend fun execute(event: MessageCreateEvent) {
        val joke = getJoke()
        event.message.channel.createMessage(joke)
    }

    private fun getJoke(): String {
        val (_, _, result) = "https://api.chucknorris.io/jokes/random".httpGet().responseString()
        val (value) = Json { ignoreUnknownKeys = true }.decodeFromString<JokeData>(result.get())
        return value
    }
}