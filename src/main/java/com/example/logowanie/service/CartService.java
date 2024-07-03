package com.example.logowanie.service;

import com.example.logowanie.model.Book;
import com.example.logowanie.model.Cart;
import com.example.logowanie.model.User;
import com.example.logowanie.repository.CartRepository;
import com.example.logowanie.repository.IBookDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private IBookDAO bookRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public Cart getCart() {
        User user = userService.getCurrentUser();
        return user.getCart();
    }

    @Transactional
    public Cart addToCart(int bookId, int quantity) {
        Cart cart = getCart();
        Book book = bookRepository.getById(bookId).orElseThrow(()
                -> new RuntimeException("Book not found"));
        cart.addItem(book, quantity);
        return saveCart(cart);
    }

    @Transactional
    public Cart removeFromCart(int bookId) {
        Cart cart = getCart();
        Book book = bookRepository.getById(bookId).orElseThrow(()
                -> new RuntimeException("Book not found"));
        cart.removeItem(book);
        return saveCart(cart);
    }

    @Transactional
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}