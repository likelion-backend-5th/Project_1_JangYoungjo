package com.example.mutsamarket.controller;

import com.example.mutsamarket.dto.item.*;
import com.example.mutsamarket.service.SalesItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class SalesItemController {

    private final SalesItemService itemService;

    @PostMapping
    public ResponseDto create(@RequestBody ItemDto dto) {
        return itemService.addItem(dto);
    }

    @GetMapping
    public Page<ResponsePageDto> readAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "20") Integer limit
    ) {
        return itemService.readAllItems(page, limit);
    }

    @GetMapping("/{itemId}")
    public ResponseItemDto readOne(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.readOneItem(itemId);
    }

    @PutMapping("/{itemId}")
    public ResponseDto update(
            @PathVariable("itemId") Long itemId, @RequestBody ItemDto dto
    ) {
        return itemService.updateItemInfo(itemId, dto);
    }

    @PutMapping(value = "/{itemId}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseDto updateImage(
            @PathVariable("itemId") Long itemId, @RequestParam("image") MultipartFile itemImage
    ) {
        return itemService.updateItemImage(itemId, itemImage);
    }

    @DeleteMapping("/{itemId}")
    public ResponseDto delete(
            @PathVariable("itemId") Long itemId, @RequestBody ItemDto dto
    ) {
        return itemService.deleteItem(itemId, dto);
    }
}
