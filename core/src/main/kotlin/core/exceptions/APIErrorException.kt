package core.exceptions

open class CoreErrorException(override val message: String = "Core error exception.") : Throwable()

class CoreDataErrorException(override val message: String = "Core Data validation error. Please contact support.") :
    CoreErrorException()
