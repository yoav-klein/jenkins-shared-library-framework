def call(String name) {
    println("Hello ${name}, from library!")
    bat "echo ${name}"
}
