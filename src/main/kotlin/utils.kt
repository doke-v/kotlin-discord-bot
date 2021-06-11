import commands.Command
import org.reflections.Reflections

fun getCommands (): MutableSet<Command> {
    val commands = mutableSetOf<Command>()
    val reflections = Reflections(Command::class.java)
    reflections.getSubTypesOf(Command::class.java).forEach {
        val command = it.getDeclaredConstructor().newInstance()
        commands.add(command)
    }
    return commands
}
