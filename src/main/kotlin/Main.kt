import kotlin.random.Random

fun main() {
    println("Игра 'Быки и коровы'\nКаждый из игроков задумывает и записывает тайное 4-значное число с неповторяющимися цифрами.\n" +
            "Противник сообщает в ответ, сколько цифр угадано без совпадения с их позициями в тайном числе (то есть количество коров) " +
            "и сколько угадано вплоть до позиции в тайном числе (то есть количество быков).")
    println()
    var load = true
    while(load){
    println("Игра против компьютера, поэтому вы вводите комбинации одну за другой, пока не отгадаете всю последовательность.")
    println()
    println("Компьютер загадал число, попробуйте его отгадать.\nВведите 4-значное неповторяющееся число: ")

    var userGuess = readln()
    while (userGuess.length != 4){
        println("Ошибка! Введите 4-х значное число:")
         userGuess = readln()
    }
    val pcGuess = pc()
        println("Загаданное компьютером число: ${pcGuess.contentToString()}")

        var bullsAndCows = compare(userGuess, pcGuess)
        var bulls = bullsAndCows.substringAfter("быков - ").toInt()
        while (bulls != 4) {
            println("$bullsAndCows")
            println("Попробуйте еще раз")
            userGuess = readln()
            bullsAndCows = compare(userGuess, pcGuess)
            bulls = bullsAndCows.substringAfter("быков - ").toInt()
        }
println("Вы угадали!")
    println("Хотите сыграть еще раз?\n 1. Да\n2. Нет")
    if(readln()=="2") load = false}
}
fun pc(): IntArray {
    val num = (0..9).shuffled().take(4).toIntArray()

    return num
}
fun compare(userGuess: String, pcGuess: IntArray): String {
    val user= userGuess.toCharArray()
    val pc = pcGuess
    var cows=0
    var bulls=0
    for (i in 0 until 4) {
        if (pc[i] == user[i].toString().toInt()) {
            bulls += 1
        } else {
            for (j in 0 until 4) {
                if (user[i].toString().toInt() == pc[j]) {
                    cows += 1
                }
            }
        }
    }

    return "Коров - $cows, быков - $bulls"
}






