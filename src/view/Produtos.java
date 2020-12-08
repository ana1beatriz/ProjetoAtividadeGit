/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Ana Beatriz
 */
@Entity
@Table(name = "produtos", catalog = "papelaria", schema = "")

public class Produtos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProdutos")
    private Integer idProdutos;
   
    @Column(name = "nome")
    private String nome;
        
    private String quantidadeEmEstoque;
    
    @OneToMany (mappedBy = "produto" )
    private List<Vendas> vendas = new ArrayList<>();

    public List<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(List<Vendas> vendas) {
        this.vendas = vendas;
    }

    public Produtos() {
    }

    public Produtos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        Integer oldIdProdutos = this.idProdutos;
        this.idProdutos = idProdutos;
        changeSupport.firePropertyChange("idProdutos", oldIdProdutos, idProdutos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(String quantidadeEmEstoque) {
        String oldQuantidadeEmEstoque = this.quantidadeEmEstoque;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        changeSupport.firePropertyChange("quantidadeEmEstoque", oldQuantidadeEmEstoque, quantidadeEmEstoque);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutos != null ? idProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idProdutos == null && other.idProdutos != null) || (this.idProdutos != null && !this.idProdutos.equals(other.idProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Produtos[ idProdutos=" + idProdutos + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
