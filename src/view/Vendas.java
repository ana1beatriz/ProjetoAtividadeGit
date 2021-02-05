/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Ana Beatriz
 */
@Entity
@Table(name = "vendas", catalog = "papelaria", schema = "")
public class Vendas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendas")
    private Integer idvendas;
    @Column (name = "dataVenda")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda; 
//    @Column (name = "horaVenda")
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date horaVenda; 

    @ManyToOne
    private Produtos produto; 
    
    @ManyToOne
    private Clientes cliente;

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        Produtos oldProduto = this.produto;
        this.produto = produto;
        changeSupport.firePropertyChange("produto", oldProduto, produto);
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        Clientes oldCliente = this.cliente;
        this.cliente = cliente;
        changeSupport.firePropertyChange("cliente", oldCliente, cliente);
    }

    
    
    public Vendas() {
    }

    public Vendas(Integer idvendas) {
        this.idvendas = idvendas;
    }

    public Integer getIdvendas() {
        return idvendas;
    }

    public void setIdvendas(Integer idvendas) {
        Integer oldIdvendas = this.idvendas;
        this.idvendas = idvendas;
        changeSupport.firePropertyChange("idvendas", oldIdvendas, idvendas);
    }



    public void setProdutosidProdutos(Integer produtosidProdutos) {
        Produtos oldProduto = this.produto;
        this.produto = produto;
        changeSupport.firePropertyChange("produto", oldProduto, produto);
    }

  

    public void setClientesIdclientes(Integer clientesIdclientes) {
        Clientes oldCliente = this.cliente;
        this.cliente= cliente;
        changeSupport.firePropertyChange("cliente", oldCliente, cliente);
        
        
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        Date oldDate = this.dataVenda;
        this.dataVenda = dataVenda;
        changeSupport.firePropertyChange("dataVenda", oldDate, dataVenda);
    }

//    public Date getHoraVenda() {
//        return horaVenda;
//    }
//
//    public void setHoraVenda(Date horaVenda) {
//        Date oldDate = this.horaVenda;
//        this.horaVenda = horaVenda;
//        changeSupport.firePropertyChange("horaVenda", oldDate, horaVenda);
//    }

    

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
