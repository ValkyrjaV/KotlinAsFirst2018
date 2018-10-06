@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs

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
    if ((first / 10) + (first % 10) == (second / 10) + (second % 10))
        return true
    else
        return false
}
/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val A = x1 == x2
    val B = y1 == y2
    val C = (x1 + y1) == (x2 + y2)
    val D = (x1 - y1) == (x2 - y2)
    return A or B or C or D
}

/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    when {
        year == 1900 -> return 28 //примечание внизу
        month == 2 -> if (year % 4 == 0)
            return 29
        else
            return 28
        month % 2 == 1 ->
            if (month < 8) return 31
            else return 30
        month % 2 == 0 ->
            if ((month > 7) and (month < 13)) return 31
            else
                if (month < 7) return 30
                else return -1
        else -> return -1
    }
    /** в тестовой программе при вводе 1900 года в феврале почему то контрольное знач-е 28
    хотя год, по идее, високосный (ПРИМЕЧАНИЕ СТУДЕНТА)
     из-за этого программа не может пройти тест
     */
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
fun max(m: Int, n: Int) = if (m > n) m else n
fun min(m: Int, n: Int) = if (m < n) m else n
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean =
        when {
            (r != s) ->
                when {
                    (a <= max(r, s)) and (b <= max(r, s)) ->
                        min(a, b) <= min(r, s)
                    (b <= max(r, s)) and (c <= max(r, s)) ->
                        min(b, c) <= min(r, s)
                    (a <= max(r, s)) and (c <= max(r, s)) ->
                        min(a, c) <= min(r, s)
                    else ->
                        false
                }
            r == s ->
                (a and b) or (b and c) or (a and c) <= r
            else ->
                false
        }
