package task.task2.p2.model.service;

import task.task2.p2.model.domain.Book;

class BookArrayParser {
    static String parse(Book[] books) {
        if (books == null) {
            return "Repository consist of 0 books.";
        }
        StringBuilder str = new StringBuilder();
        str.append(String.format("Repository consist of %d books.", books.length));
        if (books.length > 0) {
            str.append(" They are:");
        }
        str.append("\n");
        for (Book book :
                books) {
            str.append(book.toString());
            str.append('\n');
        }
        return str.toString();
    }
}
