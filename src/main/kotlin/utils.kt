import commands.Command
import org.reflections.Reflections

fun getCommands (): MutableSet<Command> {
    val commands = mutableSetOf<Command>()
    val reflections = Reflections(Command::class.java)
    val classes = reflections.getSubTypesOf(Command::class.java)
    for(C in classes){
        val command = C.getDeclaredConstructor().newInstance()
        commands.add(command)
    }
    return commands
}
