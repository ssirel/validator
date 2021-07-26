import java.util.regex.Pattern

class emailValidator {

    fun validateEmails(persons: List<PersonData>): List<EmailValidationResult> {
        var incorrectEmails: ArrayList<EmailValidationResult> = ArrayList()

        for (person in persons) {
            val emails = person.email
            if (emails != null)
                for (email in emails) {
                    if (!isEmailValid(email))
                        incorrectEmails.add(EmailValidationResult(email, person.toString()))
                }
        }

        return incorrectEmails;
    }

    fun isEmailValid(email: String): Boolean =
        email.isNotEmpty() && Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
                    ")+"
        ).matcher(email).matches()
}