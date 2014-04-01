/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.rpgruler.data.entitity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "expertise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expertise.findAll", query = "SELECT e FROM Expertise e"),
    @NamedQuery(name = "Expertise.findById", query = "SELECT e FROM Expertise e WHERE e.id = :id"),
    @NamedQuery(name = "Expertise.findByTitle", query = "SELECT e FROM Expertise e WHERE e.title = :title"),
    @NamedQuery(name = "Expertise.findByKeyskill", query = "SELECT e FROM Expertise e WHERE e.keyskill = :keyskill"),
    @NamedQuery(name = "Expertise.findByValue", query = "SELECT e FROM Expertise e WHERE e.value = :value")})
public class Expertise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "keyskill")
    private BigInteger keyskill;
    @Column(name = "value")
    private BigInteger value;
    @JoinColumn(name = "id_player_char", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlayerChar idPlayerChar;

    public Expertise() {
    }

    public Expertise(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getKeyskill() {
        return keyskill;
    }

    public void setKeyskill(BigInteger keyskill) {
        this.keyskill = keyskill;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public PlayerChar getIdPlayerChar() {
        return idPlayerChar;
    }

    public void setIdPlayerChar(PlayerChar idPlayerChar) {
        this.idPlayerChar = idPlayerChar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expertise)) {
            return false;
        }
        Expertise other = (Expertise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.rpgruler.data.entitity.Expertise[ id=" + id + " ]";
    }
    
}
