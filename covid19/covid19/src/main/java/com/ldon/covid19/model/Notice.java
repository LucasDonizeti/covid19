package com.ldon.covid19.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * author LucasDonizeti
 */
@Entity
public class Notice {
    @Id
    private String link;
    private String titulo;
    private String timestamp;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
