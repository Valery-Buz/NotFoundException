package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    @Test
    public void shouldNotFoundException() {
        ProductRepository repository = new ProductRepository();

        Product book1 = new Book(1, "Java for dummies", 150, "author1", 300, 2022);
        Product book2 = new Book(2,"No war", 200, "author2", 150, 2021);
        Product TShirt1 = new TShirt(3, "Cat on the chair", 199, "black", "XXL");
        Product TShirt2 = new TShirt(4, "Cat yelling meow", 350, "Green", "XS");

        repository.save(book1);
        repository.save(book2);
        repository.save(TShirt1);
        repository.save(TShirt2);

        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();

        Product book1 = new Book(1, "Java for dummies", 150, "author1", 300, 2022);
        Product book2 = new Book(2,"No war", 200, "author2", 150, 2021);
        Product TShirt1 = new TShirt(3, "Cat on the chair", 199, "black", "XXL");
        Product TShirt2 = new TShirt(4, "Cat yelling meow", 350, "Green", "XS");

        repository.save(book1);
        repository.save(book2);
        repository.save(TShirt1);
        repository.save(TShirt2);

        repository.removeById(3);
        Product[] expected = {book1, book2, TShirt2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }



}