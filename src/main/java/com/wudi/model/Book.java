package com.wudi.model;

public class Book {
    private Integer bookid;

    private String isbn;

    private String title;

    private String author;

    private Integer pyear;

    private String publisher;

    private String images;

    private String imagem;

    private String imagel;

//    private int size;
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getPyear() {
        return pyear;
    }

    public void setPyear(Integer pyear) {
        this.pyear = pyear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem == null ? null : imagem.trim();
    }

    public String getImagel() {
        return imagel;
    }

    public void setImagel(String imagel) {
        this.imagel = imagel == null ? null : imagel.trim();
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pyear=" + pyear +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}