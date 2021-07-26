import java.io.Serializable

data class PersonData (
    var country: String,
    var name: String,
    var dateOfBirth: String,
    var age: Int,
    var email: List<String>? = null
):Serializable