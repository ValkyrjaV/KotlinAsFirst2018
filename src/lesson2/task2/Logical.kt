@file:Suppress("UNUSED_PARAMETER", "UNREACHABLE_CODE")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.max
import kotlin.math.min

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val first = number / 100
    val second = number % 100
    return (first / 10) + (first % 10) == (second / 10) + (second % 10)
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val a = x1 == x2
    val b = y1 == y2
    val c = (x2 + y2) == (x1 + y1)
    val d = (x1 - y1) == (x2 - y2)
    return a || b || c || d
}

/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    return when {
        year == 1700 -> 28
        year == 1800 -> 28
        year == 1900 -> 28
        year == 2100 -> 28
        year == 2200 -> 28
        year == 2300 -> 28
        month == 2 -> if (year % 4 == 0)
            29
        else
            28
        month % 2 == 1 ->
            if (month < 8) 31
            else 30
        month % 2 == 0 ->
            when {
                (month > 7) && (month < 13) -> 31
                month < 7 -> 30
                else -> -1
            }
        else -> -1
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */

fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean = TODO()

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */

fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val m1 = min(r, s)
    val m2 = max(r, s)
    return when {
        a <= m1 -> ((b <= m2) || (c <= m2))
        b <= m1 -> ((a <= m2) || (c <= m2))
        c <= m1 -> ((a <= m2) || (b <= m2))
        else -> false
    }
}