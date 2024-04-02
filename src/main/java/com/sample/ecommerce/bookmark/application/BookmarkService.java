package com.sample.ecommerce.bookmark.application;

import com.sample.ecommerce.bookmark.domain.Bookmark;
import com.sample.ecommerce.bookmark.domain.BookmarkRepository;
import com.sample.ecommerce.product.domain.Product;
import com.sample.ecommerce.product.domain.ProductRepository;
import com.sample.ecommerce.user.domain.User;
import com.sample.ecommerce.user.domain.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookmarkService {

    BookmarkRepository bookmarkRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    public BookmarkDto registerBookmark(BookmarkRegisterRequest bookmarkRegisterRequest) {
        User user = userRepository.findByUserId(bookmarkRegisterRequest.getUserId()).orElseThrow();
        Product product = productRepository.findById(bookmarkRegisterRequest.getProductId()).orElseThrow();

        Optional<Bookmark> findBookmark = bookmarkRepository.findByUserAndProduct(user, product);

        if(findBookmark.isPresent()) throw new IllegalArgumentException("This Bookmark is already registered");

        Bookmark bookmark = new Bookmark(bookmarkRegisterRequest);
        bookmark.assignUser(user);
        bookmark.assignProduct(product);

        return bookmarkRepository.save(bookmark).toDto();
    }
}
