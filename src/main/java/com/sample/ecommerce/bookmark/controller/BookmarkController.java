package com.sample.ecommerce.bookmark.controller;

import com.sample.ecommerce.bookmark.application.BookmarkRegisterRequest;
import com.sample.ecommerce.bookmark.application.BookmarkRegisterResponse;
import com.sample.ecommerce.bookmark.application.BookmarkService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Operation(summary = "북마크를 등록한다.")
    @PostMapping("/api/bookmark")
    public BookmarkRegisterResponse registerBookmark (@RequestBody BookmarkRegisterRequest bookmarkRegisterRequest){
        return bookmarkService.registerBookmark(bookmarkRegisterRequest).toRegisterResponse();
    }
}
