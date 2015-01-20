//Esta clase se encarga de parsear el xml. Creará los objetos que queramos 
//almacenar en mongo como documentos y los guardará en arrays.
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

     // Para apilar el nombre de las etiquetas que se va encontrando.
    private Stack<String> elementStack = new Stack<String>();
    
     // Para apilar los objetos que vamos creando al encontrar etiquetas determinadas.
    private Stack<Object> objectStack = new Stack<Object>();

    
     // Procesa el inicio de una etiqueta, el nombre de dicha etiqueta. <etiqueta_inico>
    // Apila el nombre de la etiqueta.
    // Según el nombre crea un objeto de una clase determinada.
    // Guarda el objeto creado en un ArrayList.
    // Apila el objeto creado.

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

    
    // Procesa el final de una etiqueta, su cierre. </etiqueta_cierre>
    // Desapila el último nombre de etiqueta apilado.
    // Comprueba dicho nombre y si es igual a alguno de los que apilamos al encontrarnos
    // desapilamos el último objeto apilado.
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.elementStack.pop();
        if ("www".equals(qName) || "article".equals(qName) || "inproceedings".equals(qName) || "book".equals(qName) || "incollection".equals(qName)) {
            this.objectStack.pop();
        }
    }

    
     // Procesa el contenido de una etiqueta <>contenido</>
    // Obtenemos una referencia del último nombre de etiqueta apilado.
    // Obtenemos una referencia del nombre de la etiqueta padre de la anterior.
    // Obtenemos una referencia del último objeto apilado para modificarlo.
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
