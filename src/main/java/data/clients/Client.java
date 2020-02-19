package data.clients;

import data.contract.Invoice;
import data.contract.Price;

import java.util.Set;

public abstract class Client {
    String name;
    String NIF;
    String direction;
    String mail;
    String fechaDeAlta;     //Nombre en ingles?  date?
    Price price;

    Set<Invoice> invoices; //Utilizamos un conjunto?


    Client(String name, String NIF, String direction, String mail){
        this.name = name;
        this.NIF = NIF;
        this.direction = direction;
        this.mail = mail;
        //Averiguar como se obtiene la fehca actual:
        //price
        //invoices
    }
}
