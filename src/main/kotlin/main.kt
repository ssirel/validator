import com.beust.klaxon.Klaxon
import java.io.File

fun main(args: Array<String>) {
    println("Hello! Email validation is started!")
    //json file location
    val file = File("resources/personData")
    val persons = Klaxon().parse<Persons>(file)
    if (persons != null) {
        val validateEmails = emailValidator().validateEmails(persons.personData)
        for (result in validateEmails)
            println("Incorrect email: " + result.email + " for person " + result.metadata)
    }
}