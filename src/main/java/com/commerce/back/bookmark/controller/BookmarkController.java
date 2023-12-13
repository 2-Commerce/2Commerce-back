package com.commerce.back.bookmark.controller;

import com.commerce.back.bookmark.application.BookmarkRegisterRequest;
import com.commerce.back.bookmark.application.BookmarkRegisterResponse;
import com.commerce.back.bookmark.application.BookmarkService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Operation(summary = "북마크를 등록한다.")
    @PostMapping("/api/bookmark")
    public BookmarkRegisterResponse registerBookmark (BookmarkRegisterRequest bookmarkRegisterRequest){
        return bookmarkService.registerBookmark(bookmarkRegisterRequest).toRegisterResponse();
    }
}
