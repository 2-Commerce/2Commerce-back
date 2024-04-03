package com.sample.ecommerce.bookmark.application;

import com.sample.ecommerce.bookmark.domain.Bookmark;
import com.sample.ecommerce.bookmark.domain.BookmarkRepository;
import com.sample.ecommerce.product.application.ProductService;
import com.sample.ecommerce.product.domain.Product;
import com.sample.ecommerce.user.application.UserService;
import com.sample.ecommerce.user.domain.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookmarkService {

    BookmarkRepository bookmarkRepository;

    UserService userService;
    ProductService productService;

    public BookmarkDto registerBookmark(BookmarkRegisterRequest bookmarkRegisterRequest) {
        final User user = userService.getUser(bookmarkRegisterRequest.getUserId());
        final Product product = productService.getProduct(bookmarkRegisterRequest.getProductId());

        Optional<Bookmark> findBookmark = bookmarkRepository.findByUserAndProduct(user, product);

        if(findBookmark.isPresent()) throw new IllegalArgumentException("This Bookmark is already registered");

        Bookmark bookmark = new Bookmark(user, product);

        return bookmarkRepository.save(bookmark).toDto();
    }
}
