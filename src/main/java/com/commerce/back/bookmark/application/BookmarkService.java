package com.commerce.back.bookmark.application;

import com.commerce.back.bookmark.domain.Bookmark;
import com.commerce.back.bookmark.domain.BookmarkRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookmarkService {

    BookmarkRepository bookmarkRepository;

    public BookmarkDto registerBookmark(BookmarkRegisterRequest bookmarkRegisterRequest) {
        Optional<Bookmark> bookmark = bookmarkRepository.findByUserIdAndProductId(bookmarkRegisterRequest.getUserId(), bookmarkRegisterRequest.getProductId());
        if(bookmark.isEmpty()){
            return bookmarkRepository.save(new Bookmark(bookmarkRegisterRequest)).toDto();
        }else{
            return bookmark.get().toDto();
        }
    }
}
