interface UseCase<in INPUT, out OUTPUT> {

    fun execute(param: INPUT? = null): OUTPUT
}