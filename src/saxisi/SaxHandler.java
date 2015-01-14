/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxisi;

import Models.Article;
import Models.Author;
import Models.Book;
import Models.Incollections;
import Models.Inproceeding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Javier
 */
public class SaxHandler extends DefaultHandler {

    private Map<String, Author> authors = new TreeMap();

    private ArrayList<Book> books = new ArrayList();
    private ArrayList<Article> articles = new ArrayList();
    private ArrayList<Incollections> incollections = new ArrayList();
    private ArrayList<Inproceeding> inproceedings = new ArrayList();

    private Stack<String> elementStack = new Stack<String>();
    private Stack<Object> objectStack = new Stack<Object>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        this.elementStack.push(qName);

        if (null != qName) {
            switch (qName) {
                case "www":
                    Author author = new Author();
                    this.objectStack.push(author);
                    break;
                case "inproceedings":
                    Inproceeding inproceeding = new Inproceeding();
                    this.objectStack.push(inproceeding);
                    this.inproceedings.add(inproceeding);
                    break;
                case "article":
                    Article article = new Article();
                    this.objectStack.push(article);
                    this.articles.add(article);
                    break;
                case "book":
                    Book book = new Book();
                    this.objectStack.push(book);
                    this.books.add(book);
                    break;
                case "incollection":
                    Incollections incollection = new Incollections();
                    this.objectStack.push(incollection);
                    this.incollections.add(incollection);
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.elementStack.pop();
        if ("www".equals(qName) || "article".equals(qName) || "inproceedings".equals(qName) || "book".equals(qName) || "incollection".equals(qName)) {
            this.objectStack.pop();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (length == 0) {
            return;
        }

        String currentElement = currentElement();

        switch (currentElement) {
            case "author":
                if ("www".equals(currentElementParent())) {
                    Author author = (Author) this.objectStack.peek();
                    author.setName(value);
                    authors.put(value, author);
                } else if ("inproceedings".equals(currentElementParent())) {
                    Inproceeding inproceeding = (Inproceeding) this.objectStack.peek();
                    inproceeding.getAuthors().add(value);
                } else if ("article".equals(currentElementParent())) {
                    Article article = (Article) this.objectStack.peek();
                    article.getAuthors().add(value);
                } else if ("book".equals(currentElementParent())) {
                    Book book = (Book) this.objectStack.peek();
                    book.getAuthor().add(value);
                } else if ("incollection".equals(currentElementParent())) {
                    Incollections incollection = (Incollections) this.objectStack.peek();
                    incollection.getAuthor().add(value);
                }
                break;
            case "year":
                if ("inproceedings".equals(currentElementParent())) {
                    Inproceeding inproceeding = (Inproceeding) this.objectStack.peek();
                    inproceeding.setYear(Integer.parseInt(value));
                } else if ("article".equals(currentElementParent())) {
                    Article article = (Article) this.objectStack.peek();
                    article.setYear(Integer.parseInt(value));
                } else if ("book".equals(currentElementParent())) {
                    Book book = (Book) this.objectStack.peek();
                    book.setYear(Integer.parseInt(value));
                } else if ("incollection".equals(currentElementParent())) {
                    Incollections incollection = (Incollections) this.objectStack.peek();
                    incollection.setYear(Integer.parseInt(value));
                }
                break;
            case "journal":
                if ("article".equals(currentElementParent())) {
                    Article article = (Article) this.objectStack.peek();
                    article.setJournal(value);
                }
                break;
            case "title":
                if ("inproceedings".equals(currentElementParent())) {
                    Inproceeding inproceeding = (Inproceeding) this.objectStack.peek();
                    inproceeding.setTitle(value);
                } else if ("article".equals(currentElementParent())) {
                    Article article1 = (Article) this.objectStack.peek();
                    article1.setTitle(value);
                } else if ("book".equals(currentElementParent())) {
                    Book book1 = (Book) this.objectStack.peek();
                    book1.setTitle(value);
                } else if ("incollection".equals(currentElementParent())) {
                    Incollections incollection = (Incollections) this.objectStack.peek();
                    incollection.setTitle(value);
                }
                break;
            case "booktitle":
                if ("inproceedings".equals(currentElementParent())) {
                    Inproceeding inproceeding = (Inproceeding) this.objectStack.peek();
                    inproceeding.setBookTitle(value);
                } else if ("incollection".equals(currentElementParent())) {
                    Incollections incollection = (Incollections) this.objectStack.peek();
                    incollection.setBookTitle(value);
                }
                break;
            case "crossref":
                if ("inproceedings".equals(currentElementParent())) {
                    Inproceeding inproceeding = (Inproceeding) this.objectStack.peek();
                    inproceeding.setCrossref(value);
                } else if ("incollection".equals(currentElementParent())) {
                    Incollections incollection = (Incollections) this.objectStack.peek();
                    incollection.setCrossef(value);
                } else if ("article".equals(currentElementParent())) {
                    Article article1 = (Article) this.objectStack.peek();
                    article1.setCrossref(value);
                }
        }
    }

    private String currentElement() {
        return this.elementStack.peek();
    }

    private String currentElementParent() {
        if (this.elementStack.size() < 2) {
            return null;
        } else {
            return this.elementStack.get(this.elementStack.size() - 2);
        }
    }

    public Map<String, Author> getAuthors() {
        return authors;
    }

//    public void setAuthors(Map<Author> authors) {
//        this.authors = authors;
//    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArrayList<Incollections> getIncollections() {
        return incollections;
    }

    public void setIncollections(ArrayList<Incollections> incollections) {
        this.incollections = incollections;
    }

    public ArrayList<Inproceeding> getInproceedings() {
        return inproceedings;
    }

    public void setInproceedings(ArrayList<Inproceeding> inproceedings) {
        this.inproceedings = inproceedings;
    }

    public Stack<String> getElementStack() {
        return elementStack;
    }

    public void setElementStack(Stack<String> elementStack) {
        this.elementStack = elementStack;
    }

    public Stack<Object> getObjectStack() {
        return objectStack;
    }

    public void setObjectStack(Stack<Object> objectStack) {
        this.objectStack = objectStack;
    }

}
