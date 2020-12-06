/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Ana Beatriz
 */
@Entity
@Table(name = "vendas", catalog = "papelaria", schema = "")

public class Vendas implements Serializable {

    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
    }

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendas")
    private Integer idvendas;
    @Basic(optional = false)
    @Column(name = "Produtos_idProdutos")
    
    @ManyToOne
    private Clientes cliente;
    
    @ManyToOne
    private Produtos produto;

    public Vendas() {
    }

    public Vendas(Integer idvendas) {
        this.idvendas = idvendas;
    }

    public Vendas(Integer idvendas, int produtosidProdutos, int clientesIdclientes) {
        this.idvendas = idvendas;
        this.produto = produto;
        this.cliente = cliente;
    }

    public Integer getIdvendas() {
        return idvendas;
    }

    public void setIdvendas(Integer idvendas) {
        Integer oldIdvendas = this.idvendas;
        this.idvendas = idvendas;
        changeSupport.firePropertyChange("idvendas", oldIdvendas, idvendas);
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvendas != null ? idvendas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.idvendas == null && other.idvendas != null) || (this.idvendas != null && !this.idvendas.equals(other.idvendas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Vendas[ idvendas=" + idvendas + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
