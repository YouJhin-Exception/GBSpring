package org.youjhin;

import com.google.common.base.Functions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.vdurmont.emoji.EmojiParser;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Пример использования библиотеки Guava для работы с коллекциями и кешем.
 */
public class Main {

    /**
     * Точка входа в программу.
     * @param args Аргументы командной строки (не используются в данном примере).
     */
    public static void main(String[] args) {

        System.out.println("Коллекции гуава");

        // Создаем список чисел
        List<Integer> numbers = Lists.newArrayList(5, 2, 8, 1, 7, 3, 6, 4);

        // Используем Ordering для сортировки списка
        Ordering<Integer> naturalOrdering = Ordering.natural();
        List<Integer> sortedNumbers = naturalOrdering.sortedCopy(numbers);
        System.out.println("Sorted Numbers: " + sortedNumbers);

        // Используем Multiset для подсчета частоты чисел
        Multiset<Integer> numberFrequency = HashMultiset.create(numbers);
        System.out.println("Frequency of 3: " + numberFrequency.count(3));

        // Используем Function для преобразования чисел в их квадраты
        List<Integer> squares = Lists.transform(numbers, Functions.compose(input -> input * input, Functions.identity()));
        System.out.println("Squares: " + squares);

        System.out.println();

        // Создаем мультисет фруктов с использованием Emoji в названиях
        Multiset<String> fruits = HashMultiset.create();
        fruits.add(EmojiParser.parseToUnicode("apple \uD83C\uDF4E"));
        fruits.add(EmojiParser.parseToUnicode("banana \uD83C\uDF4C"));
        fruits.add(EmojiParser.parseToUnicode("pear \uD83C\uDF50"));
        fruits.add(EmojiParser.parseToUnicode("kiwi \uD83E\uDD5D"));
        fruits.add(EmojiParser.parseToUnicode("peach \uD83C\uDF51"));
        fruits.add(EmojiParser.parseToUnicode("watermelon \uD83C\uDF49"));
        fruits.add(EmojiParser.parseToUnicode("apple \uD83C\uDF4E"));

        // Выводим фрукты и их количество
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("how many apples ?  - " + fruits.count("apple \uD83C\uDF4E"));

        // Преобразуем мультисет фруктов в список
        List<String> fruitList = Lists.newArrayList(fruits);

        // Разбиваем список фруктов на подсписки размером 2
        List<List<String>> doubleFruits = Lists.partition(fruitList, 2);
        System.out.println("Double fruits: " + doubleFruits);

        System.out.println();
        System.out.println("Кеш гуава");

        // Создаем кеш с максимальным размером 100 и временем жизни элементов 10 минут
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        // Помещаем значение в кеш
        cache.put(EmojiParser.parseToUnicode("hamburger \uD83C\uDF54"), "someCode");

        // Выводим значение из кеша
        System.out.println("Value for \uD83C\uDF54 : " + cache.getIfPresent(EmojiParser.parseToUnicode("hamburger \uD83C\uDF54")));
    }
}