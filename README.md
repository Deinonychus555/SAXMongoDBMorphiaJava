# SAXMongoDBMorphiaJava

Este programa lo que hace es procesar un documento XML mediante SAX, guardando los datos que nos interesen en MongoDB (base de datos NoSQL orientada a documentos de tipo JSON escrita en C++). Para ello utiliza Morphia (librería Java desarrollada por Google), que convertirá los objetos Java en documentos Mongo. La configución de Morphia se realiza mediante anotaciones en los POJOs (clases simples de Java).

##### Referencias:

* [**Java SAX Parsing Example**][1]
* [**Get element attributes in SAX XML parsing**][2]

[1]:http://tutorials.jenkov.com/java-xml/sax-example.html
[2]:http://examples.javacodegeeks.com/core-java/xml/sax/get-element-attributes-in-sax-xml-parsing
