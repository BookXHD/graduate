package com.tzg.xhd.tbooking.entity;


public class Book {
    /**id主键**/
    private Integer bookId;

    /**书名**/
    private String bookName;

    public Book(Integer bookId, String bookName){
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
