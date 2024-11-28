val list = listOf("Pomme", "Banane", "Cerise")  ;
val mutableList = mutableListOf(1, 2, 3)  ;
val set = setOf(1, 2, 3, 3);

fun main(){
    println(set)
}
// Filter and transform data:
val nombres = listOf(1, 2, 3, 4, 5)
val pairs = nombres.filter { it % 2 == 0 }
val carrés = nombres.map { it * it }
fun main(){
    println(pairs)
    println(carrés)
    nombres.forEach{println(it)}
}
// Create a generic function:
fun <T> afficherElement(element: T) {
    println(element)
}

fun main(){
    afficherElement(42)         // Fonctionne avec un Int
    afficherElement("Bonjour")  // Fonctionne avec un String


}

// Create a generic function:
class Boîte<T>(val contenu: T) {
    fun afficherContenu() {
        println("Contenu : $contenu")
    }
}

val boîteInt = Boîte(123)
val boîteString = Boîte("Hello")


fun main(){
    boîteInt.afficherContenu()     // Contenu : 123
    boîteString.afficherContenu()  // Contenu : Hello

}

//Extensions :

fun String.inverser(): String {
    return this.reversed()
}

fun main(){
    println("Kotlin".inverser())  // Résultat : "niltok"


}

// Fonctions d’ordre supérieur :

fun appliquerOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Utilisation
val somme = appliquerOperation(5, 3) { x, y -> x + y }   // 8
val produit = appliquerOperation(5, 3) { x, y -> x * y } // 15

fun main(){
    println(somme)
    println(produit)


}

// Exercices pratiques :
// 1 / Manipulation des collections :

fun main() {
    // Créer une liste de nombres
    val numbers = listOf(5, 12, 8, 21, 3, 18, 7)

    // Filtrer les nombres supérieurs à 10
    val filteredNumbers = numbers.filter { it > 10 }

    // Afficher les résultats
    println("Nombres supérieurs à 10 : $filteredNumbers")
}
//Transformez une liste de chaînes en majuscules.

fun main() {
    // Créer une liste de chaînes
    val strings = ("bonjour")

    // Transformer les chaînes en majuscules
    val uppercasedStrings = strings.map { it.uppercase() }

    // Afficher les résultats
    println("Chaînes en majuscules : $uppercasedStrings")
}

// 2 :Fonctions génériques :

fun <T> getLastElement(list: List<T>): T? = list.lastOrNull()

fun main() {
    val numbers = listOf(1, 2, 3)
    println(getLastElement(numbers)) // Affiche : 3

    val strings = listOf("Kotlin", "Java", "Python")
    println(getLastElement(strings)) // Affiche : Python

    val emptyList = listOf<Int>()
    println(getLastElement(emptyList)) // Affiche : null
}
//Extension :

fun <T> List<T>.secondOrNull(): T? {
    return if (this.size > 1) this[1] else null
}

// Exemple d'utilisation
fun main() {
    val liste = listOf(10, 20, 30)
    println(liste.secondOrNull()) // Renvoie 20

    val listeVide = listOf<Int>()
    println(listeVide.secondOrNull()) // Renvoie null

    val listeUneValeur = listOf(10)
    println(listeUneValeur.secondOrNull()) // Renvoie null
}










